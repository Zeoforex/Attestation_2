package Attestation2.Attestation2.DZ.tetstss.src.main.java.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="schedule")
public class Schedule {



    public Schedule(int duration, int start_dt, int start_time, int end_dt, int end_time, Boolean active){
        this.duration = duration;
        this.start_dt = start_dt;
        this.start_time = start_time;
        this.end_dt = end_dt;
        this.end_time = end_time;
        this.active = active;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestList test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    private int duration;


    private int start_time;


    private int end_time;

    private Boolean active;

    public Schedule(){}


    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public TestList getTest() {
        return test;
    }

    public void setTest(TestList test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", test=" + test +
                ", group=" + group +
                ", duration=" + duration +
                ", start_dt=" + start_dt +
                ", start_time=" + start_time +
                ", end_dt=" + end_dt +
                ", end_time=" + end_time +
                ", active=" + active +
                '}';
    }
}
