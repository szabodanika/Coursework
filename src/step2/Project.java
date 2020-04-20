package step2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Project implements Comparable<Project> {

    private String title;
    private Date start, end;
    private Queue<TeamMember> teamMembers = new LinkedList<>();

    public Project(String title, Date start, Date end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }


    @Override
    public String toString() {
        SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
        String s = "\n" + title + "\nStarting " + dateF.format(start) +
                "\nEnding " + dateF.format(end);
        return s;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }

    public boolean hasTeamMember(TeamMember tMember) {
        for (TeamMember name : this.teamMembers) if (tMember == name) return true;
        return false;
    }

    public boolean addTeamMember(TeamMember tMember) {
        if (!hasTeamMember(tMember)) {
            this.teamMembers.add(tMember);
            return true;
        } else return false;
    }

    public TeamMember[] getAllTeamMembersAsArray() {
        return this.teamMembers.toArray(new TeamMember[0]);
    }

    public int getTeamMembersNumber() {
        return this.teamMembers.size();
    }

    public boolean findTeamMemberByName(String name) {
        for (TeamMember m : this.teamMembers) if (m.getName().equals(name)) return true;
        return false;
    }

    public void removeTeamMember(TeamMember member) {
        this.teamMembers.remove(member);
    }

    public TeamMember getByName(String name) {
        for (TeamMember m : this.teamMembers) if (m.getName().equals(name)) return m;
        return null;
    }
}