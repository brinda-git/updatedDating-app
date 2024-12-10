package com.example.dating_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "users")
public class Entity {
    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "interests", nullable = false)
    private String interests;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Entity() {
    }

    public Entity(String name, String gender, int age, String interests) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.interests = interests;

    }
//    public String[] getSkillsArray() {
//        return interests != null ? interests.split(",") : new String[0];
//    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", interests='" + interests + '\'' +
                '}';
    }
}