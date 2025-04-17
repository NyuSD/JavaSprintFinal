package org.keyin.memberships;

import org.keyin.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipDAO {

    public void createMembership(Membership m) {
        String sql = "INSERT INTO memberships(membershipType, membershipDescription, membershipCost, memberID) "
                   + "VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getMembershipType());
            stmt.setString(2, m.getMembershipDescription());
            stmt.setDouble(3, m.getMembershipCost());
            stmt.setInt(4, m.getMemberId());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    m.setMembershipId(generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Membership getMembershipById(int membershipId) {
        String sql = "SELECT * FROM memberships WHERE membershipid = ?";
        Membership membership = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, membershipId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                membership = new Membership();
                membership.setMembershipId(rs.getInt("membershipId"));
                membership.setMembershipType(rs.getString("membershipType"));
                membership.setMembershipDescription(rs.getString("membershipDescription"));
                membership.setMembershipCost(rs.getDouble("membershipCost"));
                membership.setMemberId(rs.getInt("memberId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membership;
    }

    public List<Membership> getAllMemberships() {
        List<Membership> list = new ArrayList<>();
        String sql = "SELECT * FROM memberships";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Membership m = new Membership();
                m.setMembershipId(rs.getInt("membershipId"));
                m.setMembershipType(rs.getString("membershipType"));
                m.setMembershipDescription(rs.getString("membershipDescription"));
                m.setMembershipCost(rs.getDouble("membershipCost"));
                m.setMemberId(rs.getInt("memberId"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateMembership(Membership m) {
        String sql = "UPDATE memberships SET membershipType=?, membershipDescription=?, "
                   + "membershipCost=?, memberId=? WHERE membershipId=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getMembershipType());
            stmt.setString(2, m.getMembershipDescription());
            stmt.setDouble(3, m.getMembershipCost());
            stmt.setInt(4, m.getMemberId());
            stmt.setInt(5, m.getMembershipId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMembership(int membershipId) {
        String sql = "DELETE FROM memberships WHERE membershipid=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, membershipId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
