package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Можно не указывать column если совпадает с названием столбца
    @Column(name = "name")
    private String name;

    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;


    public User() {
    }


    public User(String name, int age) {
        this.name = name;
        this.age = age;
        autos = new ArrayList<Auto>();
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
