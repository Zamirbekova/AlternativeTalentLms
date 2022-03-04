package com.hadicha.service;

import com.hadicha.entity.Course;
import com.hadicha.entity.Group;

import java.util.List;

public interface GroupService {
    void saveGroup(Group group);
    void deleteGroupById(int id);
    Group getById(int id);
    List<Group> getAllGroup();
    void updateGroup(Group group);
}
