package com.nthduc.jobms.job.mapper;
import com.nthduc.jobms.job.Job;
import com.nthduc.jobms.job.dto.JobWithCompanyDTO;
import com.nthduc.jobms.job.external.Company;
import com.nthduc.jobms.job.external.Review;

import java.util.List;

//Mapper
public class JobMapper {

    public static JobWithCompanyDTO jobDTO(Job job, Company company, List<Review> review) {
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();

        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setReview(review);

        return jobWithCompanyDTO;
    }
}