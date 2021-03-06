package com.dibirov.dibirov.controller;

import com.dibirov.dibirov.exception.ResourceNotFoundException;
import com.dibirov.dibirov.model.*;
import com.dibirov.dibirov.repository.RoleRepository;
import com.dibirov.dibirov.repository.UserRepository;
import com.dibirov.dibirov.repository.GroupRepository;
import jdk.internal.jrtfs.JrtFileSystemProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("users")
public class UserController<RoleRepository> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User " + userId + " not found"));
    }


    @PostMapping
    public User createUser(@Valid @RequestBody User user) {

        if (user.getRole_id() == null)
            throw new ParameterNotSpecified("You should specify the role_id");
        else
            user.setRole(roleRepository.findById(user.getRole_id()).orElseThrow());
        if (user.getGroup_id() != null)
            user.setGroup((org.apache.catalina.Group) groupRepository.findById(user.getGroup_id()).orElseThrow());
        User temp = userRepository.save(user);
        if (temp.getTestListList() != null)
            temp.getTestListList().forEach(testList -> testList.setTeacher_id(user.getId()));
        return userRepository.save(user);
    }

    @PutMapping("{userId}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody User userRequest) {
        return userRepository.findById(userId).map(user -> {
            user.setFirst_name(userRequest.getFirst_name());
            user.setLast_name(userRequest.getLast_name());
            user.setMiddle_name(userRequest.getMiddle_name());

            user.setLogin(userRequest.getLogin());
            if (userRequest.getRole_id() == null)
                throw new ParameterNotSpecified("You should specify the role_id");
            else
                user.setRole(roleRepository.findById(userRequest.getRole_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Role " + userRequest.getRole_id() + " not found!"
                        )), userRequest.getRole_id());

            if (userRequest.getGroup_id() != null)
                user.setGroup((org.apache.catalina.Group) groupRepository.findById(userRequest.getGroup_id())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Group " + userRequest.getGroup_id() + " not found!"
                        )), userRequest.getGroup_id());

            if (userRequest.getTestListList() != null) {
                List<TestList> tempList = user.getTestListList();
                user.setTestListList(userRequest.getTestListList());
                JrtFileSystemProvider testListRepository;
                tempList.forEach(testList -> testListRepository.delete(testList));
            }


            User temp = userRepository.save(user);
            temp.getTestListList().forEach(testList -> testList.setTeacher_id(user.getId()));

            return userRepository.save(user);

        }).orElseThrow(() -> new ResourceNotFoundException("User " + userId + " not found!"));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("User " + userId + " not found!"));
    }


}