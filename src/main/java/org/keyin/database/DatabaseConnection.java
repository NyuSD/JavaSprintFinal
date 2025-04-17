package org.keyin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>Utility class that creates {@link java.sql.Connection} objects for the
 * entire application.  <br>
 * All DAOs call {@link #getConnection()} which encapsulates the JDBC URL,
 * user name, and password in one place.</p>
 *
 * <h3>Usage</h3>
 * <pre>{@code
 * try (Connection conn = DatabaseConnection.getConnection()) {
 *     // use conn …
 * }
 * }</pre>
 *
 * @author  Jacob
 */
public final class DatabaseConnection {

    /** JDBC URL of the PostgreSQL database. */
    private static final String DB_URL =
            "jdbc:postgresql://localhost:5433/s3javafinal";

    /** Database user who owns the schema. */
    private static final String USER = "postgres";

    /** Password for {@link #USER}. */
    private static final String PASS = "hG2srZWt";

    /** Hide public constructor – utility class. */
    private DatabaseConnection() { }

    /**
     * Obtain a new JDBC connection.
     *
     * @return fresh {@link Connection}
     * @throws SQLException if the connection cannot be opened
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
