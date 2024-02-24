package com.nthduc.jobms.job.impl;

import com.nthduc.jobms.job.Job;
import com.nthduc.jobms.job.JobRepository;
import com.nthduc.jobms.job.JobService;
import com.nthduc.jobms.job.clients.CompanyClient;
import com.nthduc.jobms.job.dto.JobWithCompanyDTO;
import com.nthduc.jobms.job.external.Company;
import com.nthduc.jobms.job.external.Review;
import com.nthduc.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    private final JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    private CompanyClient companyClient;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
    }

    private JobWithCompanyDTO convertToDto(Job job){
        Company company = restTemplate.getForObject("http://company-service:8082/companies/" +  + job.getCompanyId(), Company.class);

        ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange(
                "http://review-service:8083/reviews?companyId=" + job.getCompanyId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>() {}
        );

        List<Review> reviews = reviewResponse.getBody();



        JobWithCompanyDTO jobWithCompanyDTO = JobMapper.jobDTO(job,company, reviews );

        return jobWithCompanyDTO;
    }
    @Override
    public List<JobWithCompanyDTO> findAll() {

        List<Job> jobs = jobRepository.findAll();
        List<JobWithCompanyDTO> jobWithCompanyDTOS = new ArrayList<>();

        return jobs.stream().map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    //Get user by id:
    @Override
    public JobWithCompanyDTO getJobById(Long id) {

        Job job = jobRepository.findById(id).orElse(null);

        return convertToDto(job);

    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job> jobOptional  = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMinSalary(updateJob.getMinSalary());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setLocation(updateJob.getLocation());
            jobRepository.save(job);
            return true;

        }
        return false;
    }
}