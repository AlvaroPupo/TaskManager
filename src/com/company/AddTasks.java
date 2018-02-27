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
    private NewTaskObjects newCompletedTask;
    private int integer;
    private String addedDate;
    private String newString;
    private String editTitle;
    private String editDueDate;
    private NewTaskObjects editedGame;
    private String itIsDueOn = " that it is due on: ";
    private int Int;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
    public List<NewTaskObjects> addToArrayList = new ArrayList<>();
    public List<NewTaskObjects> completed = new ArrayList<>();

    /** Unnecessary. This could all be accomplished by creating a new task object and getting the values from methods that return Strings
     * and date objects:
     * Task task = new Task(getTitle(), getDetails(), getDueDate()); This will allow the user to more-easily understand what the Task's parameters
     * are comprised of.
     *
     * */
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

    Calendar calendar = Calendar.getInstance();
    newTask.setAddDate(dateFormat.format(calendar.getTime()));
    newTask.setCompletedOrNot("not completed");

    System.out.println("What is the deadline of the task?");
    date = scanner.nextLine();
    newTask.setDueDate(date);
    addToArrayList.add(newTask);

    System.out.println("Would you like to add another task? y/n");
    answer = scanner.nextLine();
    if (answer.equalsIgnoreCase("y")){
        newTask();
    } else if (answer.equalsIgnoreCase("n")){
        for (NewTaskObjects list : addToArrayList) {
            System.out.println("you added: " + list.title + " on " + list.addDate + "\nand it is due on " + list.dueDate + "\nand it is " + list.completedOrNot + "\n");
        }
        System.out.println("Press enter to go to the main menu");
        response = scanner.nextLine();
    } else {
        System.out.println("Please enter y or n");
    }
        menu.mainMenu();
    }
    public void displayAll () {

        if (addToArrayList.isEmpty()) {
            System.out.println("There are no tasks in your task manager" + "\n");
            menu.mainMenu();
        } else {
            System.out.println("This is all your tasks: ");
        }
            int uno = 1;
            for (NewTaskObjects list : addToArrayList) {
                System.out.println(uno++ + ". " + list.title + " " + itIsDueOn + " " + list.dueDate + "\nand it is " + list.completedOrNot);
            }
            if (completed.isEmpty()){
                System.out.println("\n" + "What do you want to do?\n1. see details of a task\n2. mark a task as complete\n3. delete a task\n4. go to the main menu");
            } else {
        for (NewTaskObjects list2: completed) {
            System.out.println(uno++ + ". " + list2.title + " was added on " + list2.addDate + "\nand it was completed on " + newCompletedTask.dueDate);
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
                menu.mainMenu();
            } else {
                System.out.println("Enter a valid number!!" + "\n");
                menu.mainMenu();
            }
    }
    public void deleteTasks() {


        /** Rather than using multiple loops to access tasks for deletion, you could have one method that takes in user input and determines which
         * Task they're editing and pass that into deleteTasks or markAsComplete, etc.
         *
         * So, Task task = addToArrayList.get(userInput); deleteTasks(task), then, in deleteTasks, addToArrayList.remove(task)*/

        if (addToArrayList.isEmpty()){
            System.out.println("There are no task to delete at the moment" + "\n");
            menu.mainMenu();
        } else {
            System.out.println("What task would you like to delete?\nPlease enter the number besides the task!!");
        }
            int uno = 1;
            for (NewTaskObjects list : addToArrayList) {
                System.out.println(uno++ + ". " + list.title);
        }
            Int = scanner.nextInt();
            addToArrayList.remove(Int - 1);
            System.out.println("The task has been removed from the task manager" + "\n");
            menu.mainMenu();
            scanner.nextLine();
        }

    public void completedTaskList () {

        if (completed.isEmpty()){
            System.out.println("You haven't completed any task" + "\n");
            menu.mainMenu();
        }else {
            System.out.println("Here is the list of the tasks that you've completed");
            System.out.println("(Press 1 to delete them all)\n(Press 2 to go to the main menu)");
        int uno = 1;
        for (NewTaskObjects list : completed) {
            System.out.println(uno++ + ". " + list.title + " has been completed on: " + list.dueDate);
        }
        }
            newString = scanner.nextLine();
            if (newString.equals("1")) {
                completed.removeAll(completed);
                System.out.println("All completed tasks has been deleted" + "\n");
                menu.mainMenu();
            } else if (newString.equals("2")) {
                menu.mainMenu();
            } else {
                System.out.println("Please enter a valid number" + "\n");
                completedTaskList();
            }
    }
    public void markAsComplete () {
        /** See comment in deleteTasks at the top */

        newTaskCompleted = new NewTaskObjects(newTask.addDate,newTask.title,"","");
        if (addToArrayList.isEmpty()){
            System.out.println("There are no tasks on your task manager" + "\n");
            menu.mainMenu();
        }else {
            System.out.println("Which task would you like to mark as completed\nPlease enter the number");
        int uno = 1;
        for (NewTaskObjects list: addToArrayList) {
            System.out.println(uno++ + ". " + list.title);
        }
        }
        Int = scanner.nextInt();
        newCompletedTask = addToArrayList.get(Int - 1);  //take user input and added it to a string
        Calendar calendar1 = Calendar.getInstance();
        newCompletedTask.setDueDate(dateFormat.format(calendar1.getTime()));
        completed.add(newCompletedTask);                //add the string to the completed tasks list
        addToArrayList.remove(Int - 1);
        System.out.println(newCompletedTask.title + " has been marked as completed" + "\n");
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
        for (NewTaskObjects list3 : addToArrayList) {
            System.out.println(uno++ + ". " + list3.title + " that was added on " + list3.addDate + "\nand it is not completed.");
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
    public  void seeDetails() {

        /** See comment in deleteTasks at the top */

        if (addToArrayList.isEmpty()) {
            System.out.println("There are no tasks to edit on your task manager" + "\n");
            menu.mainMenu();
        } else {
            System.out.println("These are the details of the tasks you have added:" + "\n");
            int uno = 1;
            for (NewTaskObjects diplayDetails : addToArrayList) {
                System.out.println(uno++ + ". " + diplayDetails.title + "\nthat you added on " + diplayDetails.addDate + "\nand is due on " + diplayDetails.dueDate + "\nit is " + diplayDetails.completedOrNot + "\n");
            }
        }
        System.out.println("Which one would you like to change?\nPlease enter the number");
        editTask();
    }
    public void editTask(){

        /** See comment in deleteTasks at the top */

        integer = scanner.nextInt();
        editedGame = addToArrayList.get(integer - 1);
        Calendar calendar2 = Calendar.getInstance();

        System.out.println("What would you like to change?\n1. Name\n2. Due date");

        switch (scanner.nextInt()) {

            case 1 :
                System.out.println("What will be the new name for the task " + editedGame.title);
                scanner.nextLine();
                addToArrayList.get(integer - 1).setTitle(scanner.nextLine());
                break;

            case 2 :
                System.out.println("What would be the new due date for the task " + editedGame.title);
                scanner.nextLine();
                addToArrayList.get(integer - 1).setDueDate(scanner.nextLine());
                break;

            default:
                System.out.println("Please enter a valid number");
                editTask();

        }
        System.out.println("The modifications have been realized" + "\n");
        menu.mainMenu();


    }
}

