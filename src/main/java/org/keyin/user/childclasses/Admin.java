package org.keyin.user.childclasses;

import org.keyin.user.User;

/**
 * Marker subclass whose {@code role} is to {@code "admin"}.
 */
public class Admin extends User {
    public Admin() { super(); setRole("admin"); }
    public Admin(int id, String name, String pw,
                 String email, String addr, String phone) {
        super(id, name, pw, email, addr, phone, "admin");
    }
}
