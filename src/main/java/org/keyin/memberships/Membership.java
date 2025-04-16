package org.keyin.memberships;

public class Membership {
    private int membershipId;
    private String membershipType;
    private String membershipDescription;
    private double membershipCost;
    private int memberId;

    public Membership() {}

    public Membership(int membershipId, String membershipType, String membershipDescription,
                      double membershipCost, int memberId) {
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.membershipDescription = membershipDescription;
        this.membershipCost = membershipCost;
        this.memberId = memberId;
    }
}
