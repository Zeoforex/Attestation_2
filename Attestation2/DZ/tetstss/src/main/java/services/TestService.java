package Attestation2.Attestation2.DZ.tetstss.src.main.java.services;

import dao.Test;
import models.Test;

import java.util.List;

public class TestService {
    private Test test = new Test();

    public TestService(){}

    public Test findTest(int id){
        return test.findById(id);
    }

    public void saveTest(Test test){
        test.save(test);
    }

    public void updateTest(Test test){
        test.update(test);
    }

    public void deleteTest(Test test){
        test.delete(test);
    }

    public List<Test> findAllTests(){
        return test.getAll();
    }

}
