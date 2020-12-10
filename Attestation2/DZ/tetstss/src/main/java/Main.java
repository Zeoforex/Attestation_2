import models.*;
import services.*;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        GroupService groupService = new GroupService();
        RoleService roleService = new RoleService();
        User user123 = new User("Murat", "Dibirov", "SHamilevich", "321fff", "zeoforex");
        userService.saveUser(user);
        user123.setGroup(groupService.findGroup(1));
        user123.setRole(roleService.findRole(3));
        userService.updateUser(user123);
        User user1234 = new User("Chelovek", "Misha", "Masha","MishaMasha", "zeoforex1");
        userService.saveUser(user1234);
        user123.setGroup(groupService.findGroup(3));
        user123.setRole(roleService.findRole(1));
        userService.updateUser(user1234);
        userService.findAllUsers();
        userService.findAllUsers();
        User user12345 = new User("Chelovek233", "Misha34", "Masha55","5", "zeoforex123");
        userService.saveUser(user12345);
        user123.setGroup(groupService.findGroup(4));
        user12345.setRole(roleService.findRole(2));
    }

}