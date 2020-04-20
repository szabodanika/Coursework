package step3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeProject implements Comparable<BinaryTreeProject> {

    private String title;
    private Date start, end;
    private Queue<TeamMember> teamMembers = new LinkedList<>();
    private BinaryTreeProject left, right;

    public BinaryTreeProject(String title, Date start, Date end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public void moveDataTo(BinaryTreeProject project) {
        project.title = this.title;
        project.start = this.start;
        project.end = this.end;
        project.teamMembers = this.teamMembers;
    }

    public BinaryTreeProject getLeft() {
        return left;
    }

    public static BinaryTreeProject findSmallestNode(BinaryTreeProject root) {
        if (root.left == null) return root;
        else return findSmallestNode(root.left);
    }

    public BinaryTreeProject findByTitle(String title) {
        if (this.title.equals(title)) return this;
        BinaryTreeProject found = null;
        if (this.left != null && this.title.compareTo(title) > 0) {
            found = this.left.findByTitle(title);
        }
        if (found != null) return found;
        if (this.right != null && this.title.compareTo(title) < 0) {
            found = this.right.findByTitle(title);
        }
        return found;
    }

    public void insert(BinaryTreeProject binaryTreeProject) {
        if (this.compareTo(binaryTreeProject) > 0) {
            if (this.left == null) {
                this.left = binaryTreeProject;
            } else {
                this.left.insert(binaryTreeProject);
            }
        } else if (this.compareTo(binaryTreeProject) < 0) {
            if (this.right == null) {
                this.right = binaryTreeProject;
            } else {
                this.right.insert(binaryTreeProject);
            }
        }
    }

    public void setLeft(BinaryTreeProject p) {
        this.left = p;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(BinaryTreeProject binaryTreeProject) {
        return this.title.compareTo(binaryTreeProject.title);
    }

    public boolean findTeamMember(TeamMember tMember) {
        for (TeamMember teamMember : this.teamMembers) if (tMember.getName().toLowerCase().equals(teamMember.getName().toLowerCase())) return true;
        return false;
    }

    public boolean addMember(TeamMember tMember) {
        if (!findTeamMember(tMember)) {
            teamMembers.add(tMember);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
        String stringF = "%-20s %-10s %-10s";
        String s = "\n" + title + "\nStarting " + dateF.format(start) +
                "\nEnding " + dateF.format(end) + "\nMembers of " + title + "\n" + String.format(stringF, "Name", "ID", "Division");
        for (TeamMember t : teamMembers) s += "\n" + t.toString();
        return s;
    }

    public String toMemberNumberString() {
        String stringF = "%-20s %-10s";
        switch (teamMembers.size()) {
            case 0:
                return String.format(stringF, title, "No members");
            case 1:
                return String.format(stringF, title, teamMembers.size() + " member");
            default:
                return String.format(stringF, title, teamMembers.size() + " members");
        }
    }

    public void printTeamSizes() {
        if (this.left != null) this.left.printTeamSizes();
        System.out.println(this.toMemberNumberString());
        if (this.right != null) this.right.printTeamSizes();
    }

    public boolean removeTeamMemberByName(String name) {
        TeamMember teamMember = getTeamMemberByName(name);
        if (teamMember == null) return false;
        teamMembers.remove(teamMember);
        return true;
    }

    public boolean remove(String title, BinaryTreeProject parent) {
        if (this.title.compareTo(title) > 0) {
            if (left == null) return false;
            return left.remove(title, this);
        } else if (this.title.compareTo(title) < 0) {
            if (right == null) return false;
            return right.remove(title, this);
        } else {
            if (left != null && right != null) {
                findSmallestNode(right).moveDataTo(this);
                right.remove(this.title, this);
            } else if (parent.left == this) {
                parent.left = left != null ? left : right;
            } else if (parent.right == this) {
                parent.right = right != null ? right : left;
            }
            return true;
        }
    }

    public TeamMember getTeamMemberByName(String name) {
        for (TeamMember members : teamMembers) {
            if (members.getName().equals(name)) return members;
        }
        return null;
    }

    public void print() {
        if (this.left != null) this.left.print();
        System.out.println(this.toString());
        if (this.right != null) this.right.print();
    }

}