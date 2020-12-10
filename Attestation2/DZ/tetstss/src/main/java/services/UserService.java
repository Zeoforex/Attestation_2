package Attestation2.Attestation2.DZ.tetstss.src.main.java.services;

import dao.User;
import models.User;

import java.util.List;

public class UserService {
    private User user = new User();

    public UserService(){}

    public User findUser(int id){
        return user.findById(id);
    }

    public void saveUser(User user){
        user.save(user);
    }

    public void updateUser(User user){
        user.update(user);
    }

    public void deleteUser(User user){
        user.delete(user);
    }

    public List<User> findAllUsers(){
        return user.getAll();
    }

}
