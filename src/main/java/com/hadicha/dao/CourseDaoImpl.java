package com.hadicha.dao;

import com.hadicha.entity.Company;
import com.hadicha.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public Course getById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public List<Course> getAllCourse() {
        return entityManager.createQuery("select d from Course d", Course.class).getResultList();
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }
}
