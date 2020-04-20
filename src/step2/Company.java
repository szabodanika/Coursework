package step2;

import java.util.ArrayList;
import java.util.Arrays;

public class Company {

    private ArrayList<Project> projects = new ArrayList<>();

    public boolean addProject(Project p) {
        if (!hasProject(p)) {
            projects.add(p);
            return true;
        } else return false;
    }

    public boolean hasProject(Project p) {
        for (int i = 0; i < projects.size(); i++) if(projects.get(i).equals(p)) return true;
        return false;
    }

    public boolean hasProject(String title) {
        for (int i = 0; i < projects.size(); i++) if(projects.get(i).getTitle().equals(title)) return true;
        return false;
    }

    public Project getProjectByTitle(String title) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTitle().equals(title)) return projects.get(i);
        }
        return null;
    }

    public Project[] getSortedList() {
        Project[] projects = this.projects.toArray(new Project[0]);
        Arrays.sort(projects);
        return projects;
    }

    public int getNumberOfProjects() {
        return this.projects.size();
    }

    public void removeProject(Project p) {
        this.projects.remove(p);
    }
}
