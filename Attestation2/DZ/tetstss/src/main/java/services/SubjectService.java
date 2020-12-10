package Attestation2.Attestation2.DZ.tetstss.src.main.java.services;

import dao.Subject;
import models.Subject;

import java.util.List;

public class SubjectService {
    private Subject subject = new Subject();

    public SubjectService(){}

    public Subject findSubject(int id){
        return subject.findById(id);
    }

    public void saveSubject(Subject subject){
        subject.save(subject);
    }

    public void updateSubject(Subject subject){
        subject.update(subject);
    }

    public void deleteSubject(Subject subject){
        subject.delete(subject);
    }

    public List<Subject> findAllSubjects(){
        return subject.getAll();
    }

}
