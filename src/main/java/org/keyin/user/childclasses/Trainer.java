package org.keyin.user.childclasses;

import org.keyin.user.User;

public class Trainer extends User {
    public Trainer() {
        super();
        this.setRole("trainer");
    }

    public Trainer(int userId, String userName, String password, 
                   String email, String address, String phoneNumber) {
        super(userId, userName, password, email, address, phoneNumber, "trainer");
    }
}
