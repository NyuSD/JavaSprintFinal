package org.keyin.memberships;

/**
 * Entity representing one purchased gym membership.
 * Maps directly to a row in the <em>memberships</em> table.
 */
public class Membership {

    private int    membershipId;          // unique id (primary key)
    private String membershipType;        // "Monthly", "Annual"…
    private String membershipDescription; // label
    private double membershipCost;        // cost at purchase time
    private int    memberId;              

    public Membership() { }

    public Membership(int id, String type, String desc,
                      double cost, int memberId) {
        this.membershipId          = id;
        this.membershipType        = type;
        this.membershipDescription = desc;
        this.membershipCost        = cost;
        this.memberId              = memberId;
    }

    // getters / setters
    public int getMembershipId()               { return membershipId; }
    public void setMembershipId(int id)        { this.membershipId = id; }

    public String getMembershipType()          { return membershipType; }
    public void setMembershipType(String type) { this.membershipType = type; }

    public String getMembershipDescription()          { return membershipDescription; }
    public void setMembershipDescription(String desc) { this.membershipDescription = desc; }

    public double getMembershipCost()          { return membershipCost; }
    public void setMembershipCost(double cost) { this.membershipCost = cost; }

    public int getMemberId()             { return memberId; }
    public void setMemberId(int memberId){ this.memberId = memberId; }

    @Override
    public String toString() {
        return "Membership[id=%d, type=%s, cost=%.2f, memberId=%d]"
                .formatted(membershipId, membershipType, membershipCost, memberId);
    }
}
