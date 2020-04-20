package step2;

public class TeamMember implements Comparable<TeamMember> {

    private String name;
    private int number;
    private String department;

    public TeamMember(String name, int number, String department) {
        this.name = name;
        this.number = number;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(TeamMember member) {
        return this.name.compareTo(member.name);
    }

    @Override
    public String toString() {
        String memberDetails = "";
        memberDetails += this.name + "\t" + this.number + "\t" + this.department;
        return memberDetails;
    }
}
