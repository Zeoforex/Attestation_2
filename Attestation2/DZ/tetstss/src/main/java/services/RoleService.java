package Attestation2.Attestation2.DZ.tetstss.src.main.java.services;

import dao.Role;
import models.Role;

import java.util.List;

public class RoleService {
    private Role role = new Role();

    public RoleService(){}

    public Role findRole(int id){
        return role.findById(id);
    }

    public void saveRole(Role role){
        role.save(role);
    }

    public void updateRole(Role role){
        role.update(role);
    }

    public void deleteRole(Role role){
        role.delete(role);
    }

    public List<Role> findAllRoles(){
        return role.getAll();
    }

}