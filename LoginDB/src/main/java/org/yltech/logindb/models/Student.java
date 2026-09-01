package org.yltech.logindb.models;

public class Student {
    private String firstname,lastname,course,index;
    private int age;
    private long phone;

    public Student() {
    }

    public Student(String firstname, String lastname, String course,String index, int age, long phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.course = course;
        this.age = age;
        this.phone = phone;
        this.index = index;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getIndex() {
        return index;
    }
}
