package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mainMenu {

    private Scanner scanner = new Scanner(System.in);
    private int response;
    private AddTasks goToAddTasks = new AddTasks(this);


    public void mainMenu () {

        System.out.println("Welcome to your Task Manager\nWhat would you like to do?\n1. Add a new task\n2. Remove a task\n3. Show list of all tasks\n4. Show list of completed tasks\n5. Show list of uncompleted tasks\n6. Edit a task\n7. Exit the program");

        try {
            switch (response = scanner.nextInt()) {
                case 1:
                    goToAddTasks.newTask();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Have a good day, night or whatever!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid number!!\n");
                    mainMenu();
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Please enter a number, not letters!!\n");
            scanner.nextInt();
            mainMenu();


        }
    }
}
