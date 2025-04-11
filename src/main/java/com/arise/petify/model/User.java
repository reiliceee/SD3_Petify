package com.arise.petify.model;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String birthdate;
    private String address;
    private String email;
    private String password;

    public User() {}

    public User(String firstName, String lastName, int age, String gender, String birthdate, String address, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirthdate() { return birthdate; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassord(String password) { this.password = password; }
}