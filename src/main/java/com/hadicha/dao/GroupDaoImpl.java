package com.hadicha.dao;

import com.hadicha.entity.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class GroupDaoImpl implements GroupDao{
    @PersistenceContext
private EntityManager entityManager;
    @Override
    @Transactional
    public void saveGroup(Group group) {
        entityManager.persist(group);
    }

    @Override
    @Transactional
    public void deleteGroupById(int id) {
        Group group=entityManager.find(Group.class,id);
        entityManager.remove(group);
    }

    @Override
    @Transactional
    public Group getById(int id) {
       return entityManager.find(Group.class,id);
    }

    @Override
    @Transactional
    public List<Group> getAllGroup() {
        return entityManager.createQuery("select f from Group f",Group.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void updateGroup(Group group) {
        entityManager.merge(group);
    }
}
