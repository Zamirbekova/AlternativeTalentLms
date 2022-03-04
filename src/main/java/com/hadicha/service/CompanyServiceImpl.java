package com.hadicha.service;

import com.hadicha.dao.CompanyDao;
import com.hadicha.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public void saveCompany(Company company) {
        companyDao.saveCompany(company);
    }

    @Override
    public void deleteCompanyById(int id) {
        companyDao.deleteCompanyById(id);

    }

    @Override
    public Company getById(int id) {
        return companyDao.getById(id);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Override
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }
}
