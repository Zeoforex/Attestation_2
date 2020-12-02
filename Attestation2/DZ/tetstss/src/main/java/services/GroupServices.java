package services;

import DAO.GroupDao;
import models.Group;

import java.util.List;

public class GroupService {
    private GroupDao groupDao = new GroupDao();

    public GroupService() {
    }

    public Group findGroup(int id) {
        return groupDao.findById(id);
    }

    public void saveGroup(Group group) {
        groupDao.save(group);
    }

    public void updateGroup(Group group) {
        groupDao.update(group);
    }

    public void deleteGroup(Group group) {
        groupDao.delete(group);
    }

    public List<Group> findAllGroups() {
        return groupDao.getAll();
    }

}