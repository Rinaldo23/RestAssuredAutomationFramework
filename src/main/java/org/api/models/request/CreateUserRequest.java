package org.api.models.request;

public class CreateUserRequest {

    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String phone;
    int userStatus;

    public CreateUserRequest(String email, String firstName, int id, String lastName, String phone, String username, int userStatus) {
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.phone = phone;
        this.username = username;
        this.userStatus = userStatus;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateUserRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public int getId() {
        return id;
    }

    public CreateUserRequest setId(int id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateUserRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateUserRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CreateUserRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public CreateUserRequest setUserStatus(int userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
