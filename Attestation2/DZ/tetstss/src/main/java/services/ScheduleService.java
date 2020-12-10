package Attestation2.Attestation2.DZ.tetstss.src.main.java.services;

import dao.Schedule;
import models.Schedule;

import java.util.List;

public class ScheduleService {
    private Schedule schedule = new Schedule();

    public ScheduleService(){}

    public Schedule findSchedule(int id){
        return schedule.findById(id);
    }

    public void saveSchedule(Schedule schedule){
        schedule.save(schedule);
    }

    public void updateSchedule(Schedule schedule){
        schedule.update(schedule);
    }

    public void deleteSchedule(Schedule schedule){
        schedule.delete(schedule);
    }

    public List<Schedule> findAllSchedules(){
        return schedule.getAll();
    }

}