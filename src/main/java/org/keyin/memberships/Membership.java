package org.keyin.memberships;

public class Membership {
    private int membershipId;
    private String membershipType;
    private String membershipDescription;
    private double membershipCost;
    private int memberId;

    public Membership() {}

    public Membership(int membershipId, String membershipType, 
                      String membershipDescription, double membershipCost, int memberId) {
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.membershipDescription = membershipDescription;
        this.membershipCost = membershipCost;
        this.memberId = memberId;
    }

    public int getMembershipId() {
        return membershipId;
    }
    public String getMembershipType() {
        return membershipType;
    }
    public String getMembershipDescription() {
        return membershipDescription;
    }
    public double getMembershipCost() {
        return membershipCost;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
    public void setMembershipDescription(String membershipDescription) {
        this.membershipDescription = membershipDescription;
    }
    public void setMembershipCost(double membershipCost) {
        this.membershipCost = membershipCost;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Membership [id=" + membershipId 
            + ", type=" + membershipType 
            + ", description=" + membershipDescription 
            + ", cost=" + membershipCost 
            + ", memberId=" + memberId + "]";
    }
}
