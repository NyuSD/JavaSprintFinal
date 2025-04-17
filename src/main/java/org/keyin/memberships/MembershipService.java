package org.keyin.memberships;

import java.util.List;

/**
 * Business logic for {@link MembershipDAO}
 * Also provides convenience methods such as total‐revenue calculation
 */
public class MembershipService {

    private final MembershipDAO dao = new MembershipDAO();

    /** Insert membership after optional validation */
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

    /** @return total revenue from <em>all</em> memberships in the DB. */
    public double getTotalRevenue() {
        return dao.getAllMemberships()
                  .stream()
                  .mapToDouble(Membership::getMembershipCost)
                  .sum();
    }
}
