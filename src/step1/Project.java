package step1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Project implements Comparable<Project> {

    private String title;
    private Date starting, ending;

    public Project(String title, Date starting, Date end) {
        this.title = title;
        this.starting = starting;
        this.ending = end;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
        String s = "\n" + title + "\nStarting " + dateF.format(starting) +
                "\nEnding " + dateF.format(ending);
        return s;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }
}
