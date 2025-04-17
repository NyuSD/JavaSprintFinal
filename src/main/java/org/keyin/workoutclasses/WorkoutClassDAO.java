package org.keyin.workoutclasses;

import org.keyin.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutClassDAO {

    public void createWorkoutClass(WorkoutClass wc) {
        String sql = "INSERT INTO workoutclasses(workoutClassType, workoutClassDescription, trainerID) "
                   + "VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, wc.getWorkoutClassType());
            stmt.setString(2, wc.getWorkoutClassDescription());
            stmt.setInt(3, wc.getTrainerId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    wc.setWorkoutClassId(generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public WorkoutClass getWorkoutClassById(int id) {
        String sql = "SELECT * FROM workoutclasses WHERE workoutclassid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                WorkoutClass wc = new WorkoutClass();
                wc.setWorkoutClassId(rs.getInt("workoutclassid"));
                wc.setWorkoutClassType(rs.getString("workoutclasstype"));
                wc.setWorkoutClassDescription(rs.getString("workoutclassdescription"));
                wc.setTrainerId(rs.getInt("trainerid"));
                return wc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<WorkoutClass> getAllWorkoutClasses() {
        List<WorkoutClass> list = new ArrayList<>();
        String sql = "SELECT * FROM workoutclasses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                WorkoutClass wc = new WorkoutClass();
                wc.setWorkoutClassId(rs.getInt("workoutclassid"));
                wc.setWorkoutClassType(rs.getString("workoutclasstype"));
                wc.setWorkoutClassDescription(rs.getString("workoutclassdescription"));
                wc.setTrainerId(rs.getInt("trainerid"));
                list.add(wc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateWorkoutClass(WorkoutClass wc) {
        String sql = "UPDATE workoutclasses SET workoutClassType=?, workoutClassDescription=?, "
                   + "trainerID=? WHERE workoutclassid=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, wc.getWorkoutClassType());
            stmt.setString(2, wc.getWorkoutClassDescription());
            stmt.setInt(3, wc.getTrainerId());
            stmt.setInt(4, wc.getWorkoutClassId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorkoutClass(int id) {
        String sql = "DELETE FROM workoutclasses WHERE workoutclassid=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
