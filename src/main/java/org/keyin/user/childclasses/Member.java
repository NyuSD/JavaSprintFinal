package org.keyin.user.childclasses;

import org.keyin.user.User;

public class Member extends User {
    public Member() {
        super();
        this.setRole("member");
    }

    public Member(int userId, String userName, String password,
                  String email, String address, String phoneNumber) {
        super(userId, userName, password, email, address, phoneNumber, "member");
    }
}
