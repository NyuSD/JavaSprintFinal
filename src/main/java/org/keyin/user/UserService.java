package org.keyin.user;

import org.keyin.user.childclasses.Admin;
import org.keyin.user.childclasses.Trainer;
import org.keyin.user.childclasses.Member;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public void registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);

        userDao.createUser(user);
    }

    public User login(String userName, String password) {
        List<User> allUsers = userDao.getAllUsers();
        for (User u : allUsers) {
            if (u.getUserName().equalsIgnoreCase(userName)) {
                if (BCrypt.checkpw(password, u.getPassword())) {
                    return u;
                }
            }
        }
        return null;
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public Admin createAdmin(String userName, String password, 
                             String email, String address, String phone) {
        Admin admin = new Admin(0, userName, password, email, address, phone);
        registerUser(admin);
        return admin;
    }

    public Trainer createTrainer(String userName, String password,
                                 String email, String address, String phone) {
        Trainer trainer = new Trainer(0, userName, password, email, address, phone);
        registerUser(trainer);
        return trainer;
    }

    public Member createMember(String userName, String password,
                               String email, String address, String phone) {
        Member member = new Member(0, userName, password, email, address, phone);
        registerUser(member);
        return member;
    }
}
