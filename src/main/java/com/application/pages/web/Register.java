package com.application.pages.web;

public class Register {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String password;

    public Register(RegisterBuilder registerBuilder){
        this.firstName = registerBuilder.firstName;
        this.lastName = registerBuilder.lastName;
        this.userName = registerBuilder.userName;
        this.password = registerBuilder.password;
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static class RegisterBuilder{
        private String firstName;
        private String lastName;
        private String userName;
        private String password;

        //setters
        public RegisterBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public RegisterBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public RegisterBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public RegisterBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Register build(){
            return new Register(this);
        }
    }
}
