package step2;// Java program to demonstrate working of Queue
// interface in Java

import java.util.Date;
import java.util.Scanner;

public class TeamMemberTest {
    public static Project project1 = new Project("project", new Date(), new Date());

    public static void main(String[] args) {
        showMenu();
    }

    private static int displayMenu(String title, String... options) {
        String s = title;
        s += "\n0 Exit";
        for (int i = 0; i < options.length; i++) {
            s += "\n" + (i + 1) + " " + options[i];
        }
        int choice = getInt("");
        return choice;
    }

    private static void showMenu() {
        while (true) {
            switch (displayMenu("Main Menu", "Add Team Member", "Remove  Team Member",
                    "Find Team Member", "Display Team Member", "Display All Team Members")) {
                case 0:
                    if (getString("Quit? (y/n)").equals("y")) System.exit(0);
                case 1:
                    String name = getString("Please enter name of team member");
                    int id = getInt("Please enter a number with 6 digits");
                    String s = getString("Please enter division name");
                    project1.addTeamMember(new TeamMember(name, id, s));
                    break;
                case 2:
                    boolean found = project1.findTeamMemberByName(getString("Please enter member's name"));
                    if (found) System.out.println("Member was found");
                    else System.out.println("Member was not found");
                    break;
                case 3:
                    TeamMember member = project1.getByName(getString("Please enter member's name"));
                    if (member != null) System.out.println(member.toString());
                    else System.out.println("Member was not found");
                    break;
                case 4:
                    member = project1.getByName(getString("Please enter member's name"));
                    if (member != null) {
                        project1.removeTeamMember(member);
                        System.out.println("Removed was successfully");
                    } else System.out.println("step2.Project was not found");
                    break;
                case 5:
                    if (project1.getTeamMembersNumber() == 0) System.out.println("No Members were found");
                    for (TeamMember members : project1.getAllTeamMembersAsArray()) System.out.println(members.toString());
                    break;
            }
        }
    }

    public static String getString(String prompt) {
        System.out.print(prompt + "\n > ");
        String input = new Scanner(System.in).nextLine();
        if (input.length() == 0) {
            System.out.println("Please enter a valid value");
            return getString(prompt);
        }
        return input;
    }

    public static int getInt(String prompt) {
        System.out.print(prompt + "\n > ");
        Integer input;
        try {
            input = new Scanner(System.in).nextInt();
            return input;
        } catch (Exception e) {
            System.out.println("Please enter an integer");
            return getInt(prompt);
        }
    }

    public int getInt(String prompt, int digits) {
        System.out.print(prompt + "\n > ");
        String input;
        Integer i;
        try {
            input = new Scanner(System.in).nextLine();
            if (input.length() != digits) {
                return getInt(prompt, digits);
            }
            i = Integer.valueOf(input);
        } catch (Exception e) {
            System.out.println("Please enter an integer");
            return getInt(prompt, digits);
        }
        return i;
    }

    public Date getDate(String prompt) {
        String s = getString(prompt + " (dd/mm/yyyy)");

        try {
            Date d = parseDate(s);
            return d;
        }catch (Exception e){
            System.out.println("Invalid format. Example: '23/03/2020'");
            return getDate(prompt + " (dd/mm/yyyy)");
        }
    }

    public Date parseDate(String s) {
        int day = Integer.valueOf(s.split("/")[0]);
        int month = Integer.valueOf(s.split("/")[1])-1;
        int year = Integer.valueOf(s.split("/")[2])-1900;
        Date date = new Date(year, month, day);
        return date;
    }
}


