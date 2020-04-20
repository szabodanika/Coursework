package step3;

import java.util.Date;
import java.util.Scanner;

public class UserInterface {

    private String menuString = "\n1 Add project \n" +
            "2 Add team member \n" +
            "3 Remove team member \n" +
            "4 Remove project \n" +
            "5 Display project \n" +
            "6 Display all projects \n" +
            "7 Display project team sizes \n" +
            "0 Quit";

    public int showMenu() {
        int i = getInt(menuString);
        if (!(i < 0 || i > 8)) {
            return i;
        } else {
            System.out.println("Invalid option. Please enter value between 0 and 8");
            return showMenu();
        }
    }

    public String getString(String prompt) {
        System.out.print(prompt + "\n > ");
        String input = new Scanner(System.in).nextLine();
        if (input.length() == 0) {
            System.out.println("Please enter a valid value");
            return getString(prompt);
        }
        return input;
    }

    public int getInt(String prompt) {
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
