package com.hadicha.dao;

import com.hadicha.entity.Company;

import java.util.List;

public interface CompanyDao {
  void saveCompany(Company company);
  void deleteCompanyById(int id);
  Company getById(int id);
  List<Company> getAllCompany();
void updateCompany(Company company);

}
