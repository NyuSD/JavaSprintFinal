package org.keyin.user;


public class User {
    private int userId;
    private String userName;
    private String password; 
    private String email;
    private String address;
    private String phoneNumber;
    private String role;

    public User() {}

    public User(int userId, String userName, String password, 
                String email, String address, String phoneNumber, String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password; 
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    // Getters and setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "User [id=" + userId + ", name=" + userName 
               + ", role=" + role + ", email=" + email + "]";
    }
}