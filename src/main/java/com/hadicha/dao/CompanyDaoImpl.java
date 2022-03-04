package com.hadicha.dao;

import com.hadicha.entity.Company;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    @Transactional
    public void deleteCompanyById(int id) {
        entityManager.remove(getById(id));

    }

    @Override
    @Transactional
    public Company getById(int id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    @Transactional
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select u from Company u", Company.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void updateCompany(Company company) {
        entityManager.merge(company);

    }
}

