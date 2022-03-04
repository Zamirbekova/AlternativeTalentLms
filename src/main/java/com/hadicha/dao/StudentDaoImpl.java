package com.hadicha.dao;

import com.hadicha.entity.Group;
import com.hadicha.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository

public class StudentDaoImpl implements StudentDao{


    @PersistenceContext
private EntityManager entityManager;
    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
     public Student getById(int id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public List<Student> getAllStudent() {
        return entityManager.createQuery("select v from Student v",Student.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
entityManager.merge(student);
    }
}
