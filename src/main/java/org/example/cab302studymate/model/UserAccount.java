package org.example.cab302studymate.model;



public class UserAccount {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public UserAccount(int id, String firstName, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public UserAccount(String firstName, String lastName, String emailAddress) {
        // ID is auto-incremented, no constructor needed
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    // Getters for user details
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    // Setters for user details
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void setFirstName() {
        this.firstName = firstName;
    }
    public void setLastName() {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress=" + emailAddress +
                '}';
    }
}