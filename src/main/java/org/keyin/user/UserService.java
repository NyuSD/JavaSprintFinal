package org.keyin.user;

import org.keyin.user.childclasses.Admin;
import org.keyin.user.childclasses.Member;
import org.keyin.user.childclasses.Trainer;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

/**
 * <p>Business layer around {@link UserDao}. Performs:</p>
 * <ul>
 *   <li>Password hashing / verification</li>
 *   <li>Simple validations</li>
 *   <li>Helper methods for specialised roles</li>
 * </ul>
 */
public class UserService {

    private final UserDao userDao = new UserDao();

    /**
     * Persist a new user.  Hashes plaintext password with BCrypt
     * <em>before</em> handing the object to the DAO.
     *
     * @param user user with plaintext password
     */
    public void registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        userDao.createUser(user);
    }

    /**
     * Attempt login with a username + plaintext password.
     *
     * @return matching {@link User} if authentication succeeds; {@code null} otherwise
     */
    public User login(String userName, String password) {
        for (User u : userDao.getAllUsers()) {
            if (u.getUserName().equalsIgnoreCase(userName)
                    && BCrypt.checkpw(password, u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    public User getUserById(int id)             { return userDao.getUserById(id); }
    public List<User> getAllUsers()             { return userDao.getAllUsers(); }
    public void updateUser(User user)           { userDao.updateUser(user); }
    public void deleteUser(int id)              { userDao.deleteUser(id); }

    /** Helper method */
    public Admin createAdmin(String name, String pw,
                             String email, String addr, String phone) {
        Admin a = new Admin(0, name, pw, email, addr, phone);
        registerUser(a);
        return a;
    }

    /** Helper method */
    public Trainer createTrainer(String name, String pw,
                                 String email, String addr, String phone) {
        Trainer t = new Trainer(0, name, pw, email, addr, phone);
        registerUser(t);
        return t;
    }

    /** Helper method */
    public Member createMember(String name, String pw,
                               String email, String addr, String phone) {
        Member m = new Member(0, name, pw, email, addr, phone);
        registerUser(m);
        return m;
    }
}
