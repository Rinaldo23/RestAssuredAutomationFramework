package org.api.models.request;

public class CreateUserBPRequest {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int userStatus;

    public CreateUserBPRequest(String email, String firstName, int id, String lastName, String phone, String username, int userStatus) {
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

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public static class Builder {

        private int id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private int userStatus;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setUserStatus(int userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public CreateUserBPRequest build() {
            return new CreateUserBPRequest(email, firstName, id, lastName, phone, username, userStatus);
        }
    }
}
