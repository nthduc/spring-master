package com.nthduc.companyms.company;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CompanyRequest {

    private String name;
    private String description;

}