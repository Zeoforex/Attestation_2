import models.*;
import services.AutoService;
import services.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        AutoService autoService = new AutoService();
        String[] colors = {"red", "yellow", "green", "cyan"};
        String[] models = {"BMW", "Mercedes", "Volkswagen", "Renault"};
        String[] names = {"Misha", "Tom", "Max", "Ivan","Alesha"};
        Integer[] ages = {20, 6, 57, 62};

        for (int i=0; i < 10; i++){
            User user = new User(names[my_getRandom(names)], ages[my_getRandom(ages)]);
            userService.saveUser(user);
            Auto auto = new Auto(models[my_getRandom(models)], colors[my_getRandom(colors)]);
            autoService.saveAuto(auto);
            user.addAuto(auto);
            userService.updateUser(user);
        }

        for (int i=0; i < 10; i++){
            User user = userService.findUser(i+1);
            userService.deleteUser(user);
        }
        List<User> userList = userService.findAllUsers();
        for (User userFor:userList) {
            System.out.println(userFor);
        }

        List<Auto> autoList = autoService.findAllAutos();
        for (Auto autoFor:autoList) {
            System.out.println(autoFor);
        }

        System.out.println(userService.findUser(5));
        System.out.println(autoService.findAuto(3));
        System.out.println(autoService.findAuto(2));
        System.out.println(userService.findUser(1));




    }



    public static <T> int my_getRandom(T[] array){
        Random r=new Random();
        return r.nextInt(array.length);

    }

}