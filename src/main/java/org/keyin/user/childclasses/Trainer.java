package org.keyin.user.childclasses;

import org.keyin.user.User;

/** Subclass whose {@code role} is {@code "trainer"}. */
public class Trainer extends User {
    public Trainer() { super(); setRole("trainer"); }
    public Trainer(int id, String name, String pw,
                   String email, String addr, String phone) {
        super(id, name, pw, email, addr, phone, "trainer");
    }
}
