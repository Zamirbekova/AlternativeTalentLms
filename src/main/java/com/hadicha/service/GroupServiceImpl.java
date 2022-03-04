package com.hadicha.service;

import com.hadicha.dao.GroupDao;
import com.hadicha.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{

    private GroupDao groupDao;
@Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void saveGroup(Group group) {
        groupDao.saveGroup(group);
    }

    @Override
    public void deleteGroupById(int id) {
groupDao.deleteGroupById(id);
    }

    @Override
    public Group getById(int id) {
        return groupDao.getById(id);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
    }

    @Override
    public void updateGroup(Group group) {
        groupDao.updateGroup(group);

    }
}
