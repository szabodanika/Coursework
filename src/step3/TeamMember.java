package step3;

public class TeamMember implements Comparable<TeamMember> {

    private String name;
    private int employeeID;
    private String division;

    public TeamMember(String name, int employeeID, String division) {
        this.name = name;
        this.employeeID = employeeID;
        this.division = division;
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
        String stringF = "%-20s %-10s %-10s";
        return String.format(stringF, this.name, this.employeeID, this.division);
    }
}
