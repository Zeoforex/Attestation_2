package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int year;

    private int semester;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> studentList = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> scheduleList = new ArrayList<>();

    public Group() {
    }

    public Group(String name, int year, int semester) {
        this.name = name;
        this.year = year;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<User> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<User> studentList) {
        this.studentList = studentList;
    }

    public void addUser(User user) {
        user.setGroup(this);
        studentList.add(user);
    }

    public void removeStudent(User student) {
        studentList.remove(student);
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public void addSchedule(Schedule schedule) {
        schedule.setGroup(this);
        scheduleList.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        scheduleList.remove(schedule);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", studentList=" + studentList +
                ", scheduleList=" + scheduleList +
                '}';
    }
}