package com.dibirov.dibirov.controller;

import com.dibirov.dibirov.exception.ResourceNotFoundException;
import com.dibirov.dibirov.model.Group;
import com.dibirov.dibirov.model.Schedule;
import com.dibirov.dibirov.model.User;
import com.dibirov.dibirov.repository.GroupRepository;
import com.dibirov.dibirov.repository.ScheduleRepository;
import com.dibirov.dibirov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;


    @GetMapping
    public Page<Group> getAllGroups(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @GetMapping("{groupId}")
    public Group getGroupById(@PathVariable Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Role " + groupId + " not found!"));
    }


    @PutMapping("{groupId}")
    public Group updateGroup(@PathVariable Long groupId, @Valid @RequestBody Group groupRequest, Pageable pageable) {
        return groupRepository.findById(groupId).map(group -> {
            group.setName(groupRequest.getName());
            group.setSemester(groupRequest.getSemester());
            group.setYear(groupRequest.getYear());

            List<User> tempList = group.getUserList();
            tempList.forEach(user -> userRepository.delete(user));

            List<Schedule> tempList1 = group.getScheduleList();
            tempList1.forEach(schedule -> scheduleRepository.delete(schedule));

            groupRequest.getUserList().forEach(user -> {
                if (user.getRole_id() == null)
                    throw new ParameterNotSpecified("You should specify role_id");
            });
            group.setUserList(groupRequest.getUserList());

            groupRequest.getScheduleList().forEach(schedule -> {
                if (schedule.getTest_id() == null)
                    throw new ParameterNotSpecified("You should specify test_id");
            });
            group.setUserList(groupRequest.getUserList());
            group.setScheduleList(groupRequest.getScheduleList());


            Group temp = groupRepository.save(group);
            temp.getUserList().forEach(user -> user.setGroup_id(group.getId()));
            temp.getScheduleList().forEach(schedule -> schedule.setGroup_id(group.getId()));


            return groupRepository.save(temp);
        }).orElseThrow(() -> new ResourceNotFoundException("Group " + groupId + " not found!"));
    }

    @DeleteMapping("{groupId}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long groupId) {
        return groupRepository.findById(groupId).map(group -> {
            groupRepository.delete(group);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Group " + groupId + " not found!"));
    }
}