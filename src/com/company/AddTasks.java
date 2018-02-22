package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class AddTasks{

    public mainMenu menu;
    private Scanner scanner = new Scanner(System.in);
    private String response;
    private String answer;
    private String date;
    private String newCompletedTask;
    private String addedDate;
    private String completedDate;
    private String newTasks1;
    private String dueDate;
    private String itIsDueOn = " that it is due on: ";
    private String completedOrNot;
    private int Int;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
    public List<String> addToArrayList = new ArrayList<>();
    public List<String> completed = new ArrayList<>();
    Calendar calendar = Calendar.getInstance();
    NewTaskObjects newTask = new NewTaskObjects("","","", "");
    NewTaskObjects newTaskCompleted = new NewTaskObjects("","","","");

    public AddTasks(mainMenu menu) {
        this.menu = menu;
    }
    public void newTask() {

    newTask = new NewTaskObjects("","","", "");
    System.out.println("What is the title of the task?");
    response = scanner.nextLine();
    newTask.setTitle(response);

    addedDate = dateFormat.format(calendar.getTime());
    newTask.setAddDate(addedDate);
    newTask.setCompletedOrNot("not completed");

    System.out.println("What is the deadline of the task?");
    date = scanner.nextLine();
    newTask.setDueDate(date);
    System.out.println("your new task is: " + newTask.getTitle() + "\nthat you added on " + newTask.getAddDate() + "\nand it is due on " + newTask.getDueDate() + "\nand it is " + newTask.getCompletedOrNot() + "\n");
    completedOrNot = newTask.completedOrNot;    //add the task completed or not completed to the list
    dueDate = newTask.dueDate;                  //add the due date value into a string
    newTasks1 = newTask.title;                  //add the title value into a string
    addToArrayList.add(newTasks1);              //add the string to the list of all tasks
    System.out.println("Would you like to add another task? y/n");
    answer = scanner.nextLine();
    if (answer.equalsIgnoreCase("y")){
        newTask();
    } else if (answer.equalsIgnoreCase("n")){
        menu.mainMenu();
    } else {
        System.out.println("Please enter y or n");
        menu.mainMenu();
    }
    }
    public void displayAll () {

        if (addToArrayList.isEmpty()) {
            System.out.println("There are no tasks in your task manager" + "\n");
            menu.mainMenu();
        } else {
            System.out.println("This is all your tasks: ");
        }
            int uno = 1;
            for (String list : addToArrayList) {
                System.out.println(uno++ + ". " + list + " " + itIsDueOn + " " + dueDate + "\nand it is " + completedOrNot);
            }
            if (completed.isEmpty()){
                System.out.println("\n" + "What do you want to do?\n1. see details of a task\n2. mark a task as complete\n3. delete a task\n4. go to the main menu");
            } else {
        for (String list2: completed) {
            System.out.println(uno++ + ". " + list2 + " was added on " + addedDate + "\nand it was completed on " + completedDate);
        }
                System.out.println("\n" + "What do you want to do?\n1. see details of a task\n2. mark a task as complete\n3. delete a task\n4. go to the main menu");
            }
            answer = scanner.nextLine();
            if (answer.equals("1")) {
                seeDetails();
            } else if (answer.equals("2")) {
                markAsComplete();
            } else if (answer.equals("3")) {
                deleteTasks();
            } else if (answer.equals("4")){
                System.out.println();
                menu.mainMenu();
            } else {
                System.out.println("Enter a valid number!!" + "\n");
                menu.mainMenu();
            }
    }
    public void deleteTasks() {

        System.out.println("What task would you like to delete?\nPlease enter the number besides the task!!");
        int uno = 1;
        for (String list: addToArrayList) {
            System.out.println(uno++ + ". " + list);
        }
        Int = scanner.nextInt();
        if (addToArrayList.isEmpty()){
            System.out.println("There are no task to delete at the moment" + "\n");
            menu.mainMenu();
        } else {
            addToArrayList.remove(Int - 1);
            System.out.println("The task has been removed from the task manager" + "\n");
            menu.mainMenu();
            scanner.nextLine();
        }
    }
    public void completedTaskList () {

        Calendar calendar2 = Calendar.getInstance();
        if (completed.isEmpty()){
            System.out.println("You haven't completed any task" + "\n");
            menu.mainMenu();
        }else {
            System.out.println("Here is the list of the tasks that you've completed");
        }
            System.out.println("(Press 1 to delete them all)\n(Press 2 to go to the main menu)");
        completedDate = dateFormat.format(calendar2.getTime());
        int uno = 1;
        for (String list : completed) {
            System.out.println(uno++ + ". " + list + " has been completed on: " + completedDate);
        }
            answer = scanner.nextLine();
            if (answer.equals("1")) {
                completed.removeAll(completed);
                System.out.println("All completed tasks has been deleted" + "\n");
                menu.mainMenu();
            } else if (answer.equals("2")) {
                menu.mainMenu();
            } else {
                System.out.println("Please enter a valid number" + "\n");
                completedTaskList();
            }
    }
    public void markAsComplete () {

        newTaskCompleted = new NewTaskObjects(addedDate,newTasks1,"","");
        if (addToArrayList.isEmpty()){
            System.out.println("There are no tasks on your task manager" + "\n");
            menu.mainMenu();
        }else {
            System.out.println("Which task would you like to mark as completed\nPlease enter the number");
        }
        int uno = 1;
        for (String list: addToArrayList) {
            System.out.println(uno++ + ". " + list);
        }
        Int = scanner.nextInt();
        scanner.nextLine();
        newCompletedTask = addToArrayList.get(Int - 1);  //take user input and added it to a string
        completed.add(newCompletedTask);                 //add the string to the completed tasks list
        newTaskCompleted.setDueDate(completedDate);
        addToArrayList.remove(Int -1);
        System.out.println(newCompletedTask + " has been marked as completed" + "\n");
        menu.mainMenu();
    }
    public void uncompletedTaskList () {

        if (addToArrayList.isEmpty()){
            System.out.println("There are no uncompleted tasks at this moment");
            System.out.println();
            menu.mainMenu();
        }else {
            System.out.println("Here is the list of the task you haven't completed");
        }
        int uno = 1;
        for (String list3 : addToArrayList) {
            System.out.println(uno++ + ". " + list3 + " that was added on " + addedDate + "\nand it is not completed.");
        }
        System.out.println("\n" + "What would you like to do?\n1. Edit a task\n2. mark as complete\n3. delete a task\n4. go to the main menu");
        answer = scanner.nextLine();

        if (answer.equals("1")){
            seeDetails();
        } else if (answer.equals("2")){
            markAsComplete();
        } else if (answer.equals("3")){
            deleteTasks();
        } else if (answer.equals("4")){
            menu.mainMenu();
        }
    }
    public  void seeDetails(){
        
    }
}
