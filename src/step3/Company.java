package step3;


public class Company {

    private BinaryTreeProject root;

    public void addProject(BinaryTreeProject binaryTreeProject) {
        if (root != null) root.insert(binaryTreeProject);
        else root = binaryTreeProject;
    }

    public BinaryTreeProject getProjectByTitle(String title) {
        if (root == null) return null;
        return root.findByTitle(title);
    }

    public boolean findByTitle(String title) {
        return getProjectByTitle(title) != null;
    }

    public boolean removeProject(BinaryTreeProject binaryTreeProject) {
        if (root != null && binaryTreeProject != null) {
            if (root.equals(binaryTreeProject)) {
                BinaryTreeProject temp = new BinaryTreeProject(null, null, null);
                temp.setLeft(root);
                boolean success = root.remove(binaryTreeProject.getTitle(), temp);
                root = temp.getLeft();
                return success;
            } else return this.root.remove(binaryTreeProject.getTitle(), this.root);
        } else return false;
    }

    public void displayAll() {
        if (root != null) root.print();
        else System.out.println("No projects to show");
    }

    public void showAllTeamSizes() {
        if (root != null) root.printTeamSizes();
        else System.out.println("No projects to show");
    }


    public int getProjectsNumber() {
        if(root == null) return 0;
        else return root.count();
    }
}
