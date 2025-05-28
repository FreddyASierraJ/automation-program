package dataclasses;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String LastName;
    private String email;

    private String country;
    private int age;
    private String date;

    List<String> courses;



    public Student(String name, String country, String date) {
        this.name = name;
        this.country = country;
        this.date = date;
        courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String courses) {
        this.courses.add(courses);
    }
}
