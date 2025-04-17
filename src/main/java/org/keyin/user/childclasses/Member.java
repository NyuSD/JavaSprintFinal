package org.keyin.user.childclasses;

import org.keyin.user.User;

/** Subclass whose {@code role} is {@code "member"}. */
public class Member extends User {
    public Member() { super(); setRole("member"); }
    public Member(int id, String name, String pw,
                  String email, String addr, String phone) {
        super(id, name, pw, email, addr, phone, "member");
    }
}
