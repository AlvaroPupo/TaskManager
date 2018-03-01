package com.company;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mainMenu {

    private Scanner scanner = new Scanner(System.in);
    private int response;
    private AddTasks goToAddTasks = new AddTasks(this);

    private static final String BLUE_BOLD = "\033[1;34m";
    private static final String RESET = "\033[0m";
    private static final String RED_BOLD = "\033[1;31m";
    private static final String GREEN_BOLD = "\033[1;32m";
    private static final String YELLOW_BOLD = "\033[1;33m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String BLACK_BOLD = "\033[1;30m";

    public void mainMenu () {

        System.out.println(BLACK_BOLD + "Welcome to your Task Manager" + RESET + YELLOW_BOLD +"\nWhat would you like to do?" + RESET + CYAN_BOLD +"\n1. Add a new task" + RESET + PURPLE_BOLD + "\n2. Remove a task" + RESET + GREEN_BOLD + "\n3. Show list of all tasks" + RESET + BLUE_BOLD +"\n4. Show list of completed tasks" + RESET + WHITE_BOLD +"\n5. Show list of uncompleted tasks" + RESET + CYAN_BOLD + "\n6. Edit a task" + RESET + GREEN_BOLD + "\n7. Exit the program" + RESET);

        try {
            switch (response = scanner.nextInt()) {
                case 1:
                    goToAddTasks.newTask();
                    break;
                case 2:
                    goToAddTasks.deleteTasks();
                    break;
                case 3:
                    goToAddTasks.displayAll();
                    break;
                case 4:
                    goToAddTasks.completedTaskList();
                    break;
                case 5:
                    goToAddTasks.uncompletedTaskList();
                    break;
                case 6:
                    goToAddTasks.seeDetails();
                    break;
                case 7:
                    System.out.println(WHITE_BOLD + "Have a good day, night or whatever!!" + RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.println(RED_BOLD + "Please enter valid number!!\n" + RESET);
                    break;
            }
            mainMenu();
        } catch (InputMismatchException ime) {
            System.out.println(RED_BOLD + "Please enter a number, not letters!!\n" + RESET);
            scanner.nextLine();
            mainMenu();
        }catch (IndexOutOfBoundsException ioobe){
            System.out.println(RED_BOLD + "Choose a valid option on the list\n" + RESET);
            scanner.nextLine();
            mainMenu();
        }catch (DateTimeParseException ex){
            System.out.print(RED_BOLD + "Please enter a valid date\n\n" + RESET);
            scanner.nextLine();
            goToAddTasks.newTask();
        }
    }
}
