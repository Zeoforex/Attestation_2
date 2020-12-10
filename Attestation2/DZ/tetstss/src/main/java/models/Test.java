package Attestation2.Attestation2.DZ.tetstss.src.main.java.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="test")
public class Test {

    public void addQuestion(Question question){
        question.setTest(this);
        this.questions.add(question);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<TestList> testLists = new ArrayList<>();

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    public Test(){}

    public int getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public void removeQuestion(Question question){
        this.questions.remove(question);
    }

    public List<TestList> getTestLists() {
        return testLists;
    }

    public void setTestLists(List<TestList> testLists) {
        this.testLists = testLists;
    }

    public void addTest(TestList testList){
        testList.setTest(this);
        this.testLists.add(testList);
    }

    public void removeTest(TestList testList){
        this.testLists.remove(testList);
    }

}
