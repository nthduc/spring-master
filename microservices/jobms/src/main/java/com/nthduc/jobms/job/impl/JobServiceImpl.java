package com.nthduc.jobms.job.impl;

import com.nthduc.jobms.job.Job;
import com.nthduc.jobms.job.JobRepository;
import com.nthduc.jobms.job.JobService;
import com.nthduc.jobms.job.clients.CompanyClient;
import com.nthduc.jobms.job.clients.ReviewClient;
import com.nthduc.jobms.job.dto.JobWithCompanyDTO;
import com.nthduc.jobms.job.external.Company;
import com.nthduc.jobms.job.external.Review;
import com.nthduc.jobms.job.mapper.JobMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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

    private final CompanyClient companyClient;
    private final ReviewClient reviewClient;

    int attempt = 0;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    private JobWithCompanyDTO convertToDto(Job job){
        Company company = companyClient.getCompany(job.getCompanyId());

        List<Review> reviews = reviewClient.getReviews(job.getCompanyId());

        JobWithCompanyDTO jobWithCompanyDTO = JobMapper.jobDTO(job,company, reviews );

        return jobWithCompanyDTO;
    }

    public List<String> companyBreakerFallback(Exception e){
        List<String> list = new ArrayList<>();
        list.add("Dummy");
        return list;
    }

    @Override
    //@CircuitBreaker(name = "companyBreaker", fallbackMethod = "companyBreakerFallback")
    @Retry(name = "companyBreaker", fallbackMethod = "companyBreakerFallback")
    public List<JobWithCompanyDTO> findAll() {
        System.out.println("Attempt: " + ++attempt);
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