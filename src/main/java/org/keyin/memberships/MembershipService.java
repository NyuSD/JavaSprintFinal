package org.keyin.memberships;

import java.util.List;

public class MembershipService {
    private MembershipDAO dao = new MembershipDAO();

    public void purchaseMembership(Membership m) {
        dao.createMembership(m);
    }

    public Membership getMembershipById(int id) {
        return dao.getMembershipById(id);
    }

    public List<Membership> getAllMemberships() {
        return dao.getAllMemberships();
    }

    public void updateMembership(Membership m) {
        dao.updateMembership(m);
    }

    public void deleteMembership(int id) {
        dao.deleteMembership(id);
    }

    public double getTotalRevenue() {
        double total = 0.0;
        List<Membership> all = dao.getAllMemberships();
        for (Membership m : all) {
            total += m.getMembershipCost();
        }
        return total;
    }
}
