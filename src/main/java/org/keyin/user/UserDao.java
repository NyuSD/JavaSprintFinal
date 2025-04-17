package org.keyin.user;

import org.keyin.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Data‑Access Object for the <strong>users</strong> table.  </p>
 * Provides basic CRUD operations and maps {@link ResultSet} rows to
 * {@link User} objects.
 *
 * <h3>Generated keys</h3>
 * After an INSERT the DAO calls {@link PreparedStatement#getGeneratedKeys()}
 * and writes the auto‑generated primary key back into the supplied
 * {@code User} instance via {@link User#setUserId(int)}.
 *
 * @author  Jacob
 */
public class UserDao {

    /**
     * Insert a new user.
     *
     * @param user  domain object with all fields set; {@code userId} can be 0
     * @throws SQLException if the insert fails
     */
    public void createUser(User user) {
        String sql = """
            INSERT INTO users
                  (userName, password, email, address, phoneNumber, role)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getPhoneNumber());
            stmt.setString(6, user.getRole());

            stmt.executeUpdate();

            // Get the generated keys (userId) and set it in the user object
            // ensures the user object has the correct ID
            // after insertion

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setUserId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Lookup user by primary key. @return nullable User */
    public User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE userId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** @return list of all users (may be empty, never {@code null}). */
    public List<User> getAllUsers() {
        List<User> out = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            while (rs.next()) out.add(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }

    /**
     * Update every column by primary key.
     *
     * @param user must already contain a valid {@code userId}
     */
    public void updateUser(User user) {
        String sql = """
            UPDATE users SET
                  userName=?,
                  password=?,
                  email=?,
                  address=?,
                  phoneNumber=?,
                  role=?
            WHERE userId=?
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getPhoneNumber());
            stmt.setString(6, user.getRole());
            stmt.setInt   (7, user.getUserId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Delete a user by primary key. */
    public void deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE userId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // helpers

    /** Map one {@link ResultSet} row → {@link User}. */
    private static User mapRow(ResultSet rs) throws SQLException {
        User u = new User();
        u.setUserId     (rs.getInt   ("userId"));
        u.setUserName   (rs.getString("userName"));
        u.setPassword   (rs.getString("password"));
        u.setEmail      (rs.getString("email"));
        u.setAddress    (rs.getString("address"));
        u.setPhoneNumber(rs.getString("phoneNumber"));
        u.setRole       (rs.getString("role"));
        return u;
    }
}
