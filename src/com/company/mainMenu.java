package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mainMenu {

    private Scanner scanner = new Scanner(System.in);
    private int response;

    /** Naming convention. goToAddTasks isn't necessary. It'd be more readable if it was simply addTasks. However, AddTasks would probably be
     * better-suited as a method, rather than its own class, as its functionality isn't very complex. */
    private AddTasks goToAddTasks = new AddTasks(this);

    public void mainMenu () {

        System.out.println("Welcome to your Task Manager\nWhat would you like to do?\n1. Add a new task\n2. Remove a task\n3. Show list of all tasks\n4. Show list of completed tasks\n5. Show list of uncompleted tasks\n6. Edit a task\n7. Exit the program");

        /** One way I prefer to use menu case/switchs is with a String, instead of an int. Because anything can be a String, '1', '2', '!', '@',
         * this way, if the user enters an invalid entry, you can handle it in the default and use recursion to call the method again. This will allow
         * you to avoid a try/catch altogether. */
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
                    System.out.println("Have a good day, night or whatever!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid number!!\n");
                    break;
            }
            mainMenu();
        } catch (InputMismatchException ime) {
            System.out.println("Please enter a number, not letters!!\n");
            scanner.nextLine();
            mainMenu();
        }
    }
}
