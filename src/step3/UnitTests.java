package step3;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UnitTests {

    private Company testCompany;
    private BinaryTreeProject testProject1;
    private BinaryTreeProject testProject2;
    private BinaryTreeProject testProject3;
    private TeamMember testTeamMember1;
    private TeamMember testTeamMember2;
    private TeamMember testTeamMember3;

    @Before
    public void before(){
        testCompany = new Company();

        testProject1 = new BinaryTreeProject("Test Project 1", new Date(1,2,2020), new Date(14,4,2020));
        testProject2 = new BinaryTreeProject("Test Project 2", new Date(6,4,2020), new Date(14,7,2020));
        testProject3 = new BinaryTreeProject("Test Project 3", new Date(16,3,2020), new Date(38,3,2020));

        testTeamMember1 = new TeamMember("Test Person 1",1, "Department");
        testTeamMember2 = new TeamMember("Test Person 2", 1, "Department");
        testTeamMember3 = new TeamMember("Test Person 3",1, "Department");
    }

    @Test
    public void addProjectTest(){
        testCompany.addProject(testProject1);
        testCompany.addProject(testProject2);
        testCompany.addProject(testProject3);

        assertEquals(true, testCompany.findByTitle(testProject1.getTitle()));
        assertEquals(true, testCompany.findByTitle(testProject2.getTitle()));
        assertEquals(true, testCompany.findByTitle(testProject3.getTitle()));
    }

    @Test
    public void removeProjectTest(){

        testCompany.addProject(testProject1);
        testCompany.addProject(testProject2);
        testCompany.addProject(testProject3);

        assertEquals(true, testCompany.findByTitle(testProject1.getTitle()));
        assertEquals(true, testCompany.findByTitle(testProject2.getTitle()));
        assertEquals(true, testCompany.findByTitle(testProject3.getTitle()));

        testCompany.removeProject(testProject1);
        assertEquals(false, testCompany.findByTitle(testProject1.getTitle()));
        testCompany.removeProject(testProject2);
        assertEquals(false, testCompany.findByTitle(testProject1.getTitle()));
        testCompany.removeProject(testProject3);
        assertEquals(false, testCompany.findByTitle(testProject1.getTitle()));
    }

    @Test
    public void findProjectTest(){
        testCompany.addProject(testProject1);
        testCompany.addProject(testProject2);
        testCompany.addProject(testProject3);

        assertEquals(testProject1, testCompany.getProjectByTitle(testProject1.getTitle()));
        assertEquals(testProject2, testCompany.getProjectByTitle(testProject2.getTitle()));
        assertEquals(testProject3, testCompany.getProjectByTitle(testProject3.getTitle()));
    }

    @Test
    public void projectComparisonTest(){
        boolean comp1 = testProject1.compareTo(testProject2) > 0;
        boolean comp2 = testProject1.compareTo(testProject3) > 0;
        boolean comp3 = testProject3.compareTo(testProject1) > 0;

        assertEquals(false, comp1);
        assertEquals(false, comp2);
        assertEquals(true, comp3);
    }

    @Test
    public void addTeamMemberTest(){
        testProject1.addMember(testTeamMember1);
        testProject1.addMember(testTeamMember2);
        testProject1.addMember(testTeamMember3);

        assertEquals(true, testProject1.findTeamMember(testTeamMember1));
        assertEquals(true, testProject1.findTeamMember(testTeamMember2));
        assertEquals(true, testProject1.findTeamMember(testTeamMember3));
    }

    @Test
    public void removeTeamMemberTest(){
        testProject1.addMember(testTeamMember1);
        testProject1.addMember(testTeamMember2);
        testProject1.addMember(testTeamMember3);

        assertEquals(true, testProject1.findTeamMember(testTeamMember1));
        assertEquals(true, testProject1.findTeamMember(testTeamMember2));
        assertEquals(true, testProject1.findTeamMember(testTeamMember3));

        testProject1.removeTeamMemberByName(testTeamMember1.getName());
        testProject1.removeTeamMemberByName(testTeamMember2.getName());
        testProject1.removeTeamMemberByName(testTeamMember3.getName());

        assertEquals(false, testProject1.findTeamMember(testTeamMember1));
        assertEquals(false, testProject1.findTeamMember(testTeamMember2));
        assertEquals(false, testProject1.findTeamMember(testTeamMember3));
    }

    @Test
    public void findTeamMemberTest(){
        testProject1.addMember(testTeamMember1);
        testProject1.addMember(testTeamMember2);
        testProject1.addMember(testTeamMember3);

        assertEquals(testTeamMember1, testProject1.getTeamMemberByName(testTeamMember1.getName()));
        assertEquals(testTeamMember2, testProject1.getTeamMemberByName(testTeamMember2.getName()));
        assertEquals(testTeamMember3, testProject1.getTeamMemberByName(testTeamMember3.getName()));
    }

    @Test
    public void teamMemberComparisonTest(){
        boolean comp1 = testTeamMember1.compareTo(testTeamMember2) > 0;
        boolean comp2 = testTeamMember1.compareTo(testTeamMember3) > 0;
        boolean comp3 = testTeamMember3.compareTo(testTeamMember2) > 0;

        assertEquals(false, comp1);
        assertEquals(false, comp2);
        assertEquals(true, comp3);
    }
}
