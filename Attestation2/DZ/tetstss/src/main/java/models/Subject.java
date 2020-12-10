package Attestation2.Attestation2.DZ.tetstss.src.main.java.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestList> test = new ArrayList<>();

    public Subject(){}

    public Subject(String name) {
        this.name = name;
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

    public List<TestList> getTestList() {
        return test;
    }

    public void setTest(List<TestList> test) {
        this.test = test;
    }

    public void addTest(TestList test){
        test.setSubject(this);
        this.test.add(test);
    }

    public void removeTest(TestList test){
        this.test.remove(test);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", test=" + test +
                '}';
    }
}
