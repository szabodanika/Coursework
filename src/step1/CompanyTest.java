package step1;

import java.util.Date;
import java.util.Scanner;

public class CompanyTest {

    private static Company company = new Company();

    public static void main(String[] args) {
       showMenu();
    }

    private static void showMenu() {
        while (true) {
            switch (displayMenu("Main Menu", "Add step1.Project", "Remove step1.Project",
                    "Find step1.Project", "Display step1.Project", "Display All Projects")) {
                case 0:
                    if (getString("Quit? (y/n)").equals("y")) System.exit(0);
                case 1:
                    String title = getString("Please enter project title");
                    if (company.hasProject(title)) {
                        System.out.println("step1.Project already exists by this name");
                    } else {
                        Date start, end;
                        while (true) {
                            start = getDate("Please enter project starting date");
                            end = getDate("Please enter project ending date");
                            if (end.before(start)) {
                                System.out.println("End date should be after start date");
                            } else break;
                        }
                        company.addProject(new Project(title, start, end));
                        System.out.println("step1.Project added");
                    }
                    break;
                case 2:
                    Project p = company.getProjectByTitle(getString("Please enter project title"));
                    if (p != null) {
                        company.removeProject(p);
                        System.out.println("Removed successfully");
                    } else System.out.println("step1.Project not found");
                    break;
                case 3:
                    boolean b = company.hasProject(getString("Please enter project title"));
                    if (b) System.out.println("step1.Project found");
                    else System.out.println("step1.Project not found");
                    break;
                case 4:
                    p = company.getProjectByTitle(getString("Please enter project title"));
                    if (p != null) System.out.println(p.toString());
                    else System.out.println("step1.Project not found");
                    break;
                case 5:
                    if (company.getNumberOfProjects() == 0) System.out.println("No Projects");
                    for (Project pj : company.getSortedList()) {
                        System.out.println(pj.toString());
                    }
                    break;
            }
        }
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
        Integer i;
        try {
            i = new Scanner(System.in).nextInt();
            return i;
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

    public static Date getDate(String prompt) {
        String s = getString(prompt + " (dd/mm/yyyy)");

        try {
            Date d = parseDate(s);
            return d;
        }catch (Exception e){
            System.out.println("Invalid format. Example: '23/03/2020'");
            return getDate(prompt + " (dd/mm/yyyy)");
        }
    }

    public static Date parseDate(String s) {
        int day = Integer.valueOf(s.split("/")[0]);
        int month = Integer.valueOf(s.split("/")[1])-1;
        int year = Integer.valueOf(s.split("/")[2])-1900;
        Date date = new Date(year, month, day);
        return date;
    }
}
