package step3;

import java.util.Date;

public class BinaryTreeTest {

    private static Company company = new Company();
    private static UserInterface userInterface = new UserInterface();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while(true) {
            switch (userInterface.showMenu()) {
                case 0:
                    if (userInterface.getString("Quit? (y/n)").equals("y")) System.exit(1);
                case 1:
                    String title = userInterface.getString("Project title");
                    if (company.findByTitle(title)) System.out.println(title + " already exists");
                    else {
                        BinaryTreeProject p = new BinaryTreeProject(title, userInterface.getDate("Start date"), userInterface.getDate("End date"));
                        company.addProject(p);
                        System.out.println(title + " added");
                    }
                    break;
                case 2:
                    String projectTitle = userInterface.getString("Project title");
                    BinaryTreeProject temp = company.getProjectByTitle(projectTitle);
                    if (temp == null) {
                        System.out.println("Could not find " + projectTitle);
                        break;
                    }
                    String name = userInterface.getString("Please enter name");
                    int id = userInterface.getInt("Please enter ID (6digits)", 6);
                    String division = userInterface.getString("Division");
                    temp.addMember(new TeamMember(name, id, division));
                    System.out.println(name + " added to " + temp.getTitle());
                    break;
                case 3:
                    projectTitle = userInterface.getString("Project title");
                    temp = company.getProjectByTitle(projectTitle);
                    if (temp == null) {
                        System.out.println("Could not find " + projectTitle);
                        break;
                    }
                    name = userInterface.getString("Team member name");
                    if (temp.removeTeamMemberByName(name)) System.out.println(name + " has been removed from project " + projectTitle);
                    else System.out.println(name + " is not in the project " + projectTitle);

                    break;
                case 4:
                    projectTitle = userInterface.getString("Project title");
                    temp = company.getProjectByTitle(projectTitle);
                    if (company.removeProject(temp))  System.out.println("Project " + projectTitle + " removed");
                    else System.out.println("Could not find " + projectTitle);
                    break;
                case 5:
                    projectTitle = userInterface.getString("Project title");
                    temp = company.getProjectByTitle(projectTitle);
                    if (temp == null) {
                        System.out.println("Could not find " + projectTitle);
                        break;
                    }
                    System.out.println(temp.toString());
                    break;
                case 6:
                    company.displayAll();
                    break;
                case 7:
                    company.showAllTeamSizes();
                    break;
            }
        }
    }
}
