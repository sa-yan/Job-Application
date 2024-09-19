package com.sayan.FirstJob.company.impl;

import com.sayan.FirstJob.company.ComapnyRepository;
import com.sayan.FirstJob.company.Company;
import com.sayan.FirstJob.company.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.RequestContextFilter;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final RequestContextFilter requestContextFilter;
    private ComapnyRepository comapnyRepository;

    public CompanyServiceImpl(ComapnyRepository comapnyRepository, RequestContextFilter requestContextFilter) {
        this.comapnyRepository = comapnyRepository;
        this.requestContextFilter = requestContextFilter;
    }

    @Override
    public List<Company> getAllCompanies() {
       return comapnyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> optionalCompany = comapnyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company1 = optionalCompany.get();
            company1.setName(company.getName());
            company1.setDescription(company.getDescription());
            company1.setJobs(company.getJobs());
            comapnyRepository.save(company1);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        comapnyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if(comapnyRepository.existsById(id)){
            comapnyRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return comapnyRepository.findById(id).orElse(null);
    }
}
