package com.hadicha.dao;

import com.hadicha.entity.Company;
import com.hadicha.entity.Group;

import java.util.List;

public interface GroupDao {

    void saveGroup(Group group);
    void deleteGroupById(int id);
    Group getById(int id);
    List<Group> getAllGroup();
    void updateGroup(Group group);

}
