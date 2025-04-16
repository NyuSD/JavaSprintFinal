package org.keyin.user.childclasses;

import org.keyin.user.User;

public class Admin extends User {
    public Admin() {
        super();
        this.setRole("admin");
    }

    public Admin(int userId, String userName, String password, 
                 String email, String address, String phoneNumber) {
        super(userId, userName, password, email, address, phoneNumber, "admin");
    }
}