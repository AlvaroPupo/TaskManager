package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class AddTasks{

    public final mainMenu menu;
    private Scanner scanner = new Scanner(System.in);
    private String response;
    private String date;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private List<String> addToArrayList = new ArrayList<>();
    Calendar calendar = Calendar.getInstance();

    public AddTasks(mainMenu menu) {
        this.menu = menu;
    }

    public void newTask() {

    NewTaskObjects newTask = new NewTaskObjects("","","", "");
    System.out.println("What is the title of the task?");
    response = scanner.nextLine();
    newTask.setTitle(response);

    newTask.setAddDate(dateFormat.format(calendar.getTime()));
    newTask.setCompletedOrNot("not completed");

    System.out.println("What is the deadline of the task?");
    date = scanner.nextLine();
    newTask.setDueDate(date);
    System.out.println("your new task is: " + newTask.getTitle() + "\nthat you added on " + newTask.getAddDate() + "\nand it is due on " + newTask.getDueDate() + "\nand it is " + newTask.getCompletedOrNot() + "\n" + "\nPress enter to go to the main menu...");
    addToArrayList.add(newTask.title);
    scanner.nextLine();
    menu.mainMenu();
    }
    
}
