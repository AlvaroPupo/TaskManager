package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AddTasks {

    public mainMenu menu;
    private Scanner scanner = new Scanner(System.in);
    private String response;
    private String answer;
    private String date;
    private NewTaskObjects newCompletedTask;
    private int integer;
    private String newString;
    private NewTaskObjects editedGame;
    private String itIsDueOn = " that it is due on: ";
    private int Int;
    public List<NewTaskObjects> addToArrayList = new ArrayList<>();
    public List<NewTaskObjects> completed = new ArrayList<>();

    public FileWriter fw;

    private static final String BLUE_BOLD = "\033[1;34m";
    private static final String RESET = "\033[0m";
    private static final String RED_BOLD = "\033[1;31m";
    private static final String GREEN_BOLD = "\033[1;32m";
    private static final String YELLOW_BOLD = "\033[1;33m";
    private static final String PURPLE_BOLD = "\033[1;35m";
    private static final String CYAN_BOLD = "\033[1;36m";
    private static final String WHITE_BOLD = "\033[1;37m";
    private static final String BLACK_BOLD = "\033[1;30m";

    NewTaskObjects newTask = new NewTaskObjects("", "", "", "");
    NewTaskObjects newTaskCompleted = new NewTaskObjects("", "", "", "");

    private LocalDateTime time = LocalDateTime.now();
    private LocalDate dueDate;
    private LocalDate newDueDateLocalDate;
    private DateTimeFormatter mDY = DateTimeFormatter.ofPattern("MMMM d, YYYY hh:mm:ss a");
    private DateTimeFormatter mdY2 = DateTimeFormatter.ofPattern("MMMM d, YYYY");

    public AddTasks(mainMenu menu) {
        this.menu = menu;
    }

    public void newTask() throws IOException{

//        fw = new FileWriter("text1");
        newTask = new NewTaskObjects("", "", "", "");
        String s = time.format(mDY);
        newTask.setAddDate(s);
        newTask.setCompletedOrNot(RED_BOLD + "not completed" + RESET);

        System.out.println(BLUE_BOLD + "What is the title of the task?" + RESET);
        response = scanner.nextLine();
        newTask.setTitle(response);
        deadLine();
    }
    public void deadLine() {

        System.out.println(GREEN_BOLD + "What is the deadline of the task? (yyyy-mm-dd)" + RESET);
        date = scanner.nextLine();
        dueDate = LocalDate.parse(date);
        if (dueDate.isBefore(LocalDate.now())) {
            System.out.println(CYAN_BOLD + "That date has already passed, try to add a date in the future\n" + RESET);
            deadLine();
        } else if (dueDate.isAfter(LocalDate.now())) {
            newTask.setDueDate(dueDate.format(mdY2));
            addToArrayList.add(newTask);
        }
//        try {
//            for (int i = 0; i < 1; i++)
//                fw.write(String.valueOf(newTask));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        again();
    }
        public void again () {
            System.out.println(YELLOW_BOLD + "Would you like to add another task? y/n" + RESET);
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                try {
                    newTask();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (answer.equalsIgnoreCase("n")) {
                for (NewTaskObjects list : addToArrayList) {
                    System.out.println(WHITE_BOLD + "you added: " + GREEN_BOLD + list.title + RESET + " on " + CYAN_BOLD + list.addDate + RESET + "\nand it is due on " + PURPLE_BOLD + list.dueDate + RESET + "\nand it is " + RESET + list.completedOrNot + "\n");
                }
                System.out.println(CYAN_BOLD + "Press enter to go to the main menu" + RESET);
                response = scanner.nextLine();
            } else {
                System.out.println(RED_BOLD + "Please enter y or n" + RESET);
                again();
            }
            menu.mainMenu();
        }
    public void displayAll() {

        if (addToArrayList.isEmpty()) {
            System.out.println(RED_BOLD + "There are no tasks in your task manager" + "\n" + RESET);
            menu.mainMenu();
        } else {
            System.out.println(BLACK_BOLD + "This is all your tasks: " + RESET);
        }
        int uno = 1;
        for (NewTaskObjects list : addToArrayList) {
            System.out.println(WHITE_BOLD + uno++ + ". " + list.title + " " + itIsDueOn + " " + list.dueDate + "\nand it is " + RESET + list.completedOrNot);
        }
        if (completed.isEmpty()) {
            System.out.println("\n" + GREEN_BOLD + "What do you want to do?" + RESET + BLUE_BOLD + "\n1. see details of a task" + RESET + YELLOW_BOLD + "\n2. mark a task as complete" + RESET + PURPLE_BOLD + "\n3. delete a task" + RESET + CYAN_BOLD + "\n4. Sort tasks" + RESET + YELLOW_BOLD + "\n5. go to the main menu" + RESET);
        } else {
            for (NewTaskObjects list2 : completed) {
                System.out.println(WHITE_BOLD + uno++ + ". " + list2.title + " was added on " + list2.addDate + "\nand it was completed on " + time.format(mDY) + RESET);
            }
            System.out.println("\n" + GREEN_BOLD + "What do you want to do?" + RESET + BLUE_BOLD + "\n1. see details of a task" + RESET + YELLOW_BOLD + "\n2. mark a task as complete" + RESET + PURPLE_BOLD + "\n3. delete a task" + RESET + CYAN_BOLD +"\n4. Sort tasks" + RESET + YELLOW_BOLD + "\n5. go to the main menu" + RESET);
        }
        answer = scanner.nextLine();
        if (answer.equals("1")) {
            seeDetails();
        } else if (answer.equals("2")) {
            markAsComplete();
        } else if (answer.equals("3")) {
            deleteTasks();
        }else if (answer.equals("4")) {
            sortTasksMenu();
        } else if (answer.equals("5")) {
            menu.mainMenu();
        } else {
            System.out.println(RED_BOLD + "Enter a valid number!!" + "\n" + RESET);
            menu.mainMenu();
        }
    }
    public void deleteTasks() {

        if (addToArrayList.isEmpty()) {
            System.out.println(RED_BOLD + "There are no task to delete at the moment" + "\n" + RESET);
            menu.mainMenu();
        } else {
            System.out.println(YELLOW_BOLD + "What task would you like to delete?" + RESET + CYAN_BOLD + "\nPlease enter the number besides the task!!" + RESET);
        }
        int uno = 1;
        for (NewTaskObjects list : addToArrayList) {
            System.out.println(WHITE_BOLD + uno++ + ". " + list.title + RESET);
        }
        Int = scanner.nextInt();
        addToArrayList.remove(Int - 1);
        System.out.println(RED_BOLD + "The task has been removed from the task manager" + "\n" + RESET);
        menu.mainMenu();
        scanner.nextLine();
    }
    public void completedTaskList() {

        if (completed.isEmpty()) {
            System.out.println(RED_BOLD + "You haven't completed any task" + "\n" + RESET);
            menu.mainMenu();
        } else {
            System.out.println(WHITE_BOLD + "Here is the list of the tasks that you've completed" + RESET);
            System.out.println(YELLOW_BOLD + "(Press 1 to delete them all)" + RESET + CYAN_BOLD + "\n(Press 2 to go to the main menu)" + RESET);
            int uno = 1;
            for (NewTaskObjects list : completed) {
                System.out.println(WHITE_BOLD + uno++ + ". " + list.title + " has been completed on: " + time.format(mDY) + RESET);
            }
        }
        newString = scanner.nextLine();
        if (newString.equals("1")) {
            completed.removeAll(completed);
            System.out.println(BLUE_BOLD + "All completed tasks has been deleted" + "\n" + RESET);
            menu.mainMenu();
        } else if (newString.equals("2")) {
            menu.mainMenu();
        } else {
            System.out.println(RED_BOLD + "Please enter a valid number" + "\n" + RESET);
            completedTaskList();
        }
    }
    public void markAsComplete() {

        newTaskCompleted = new NewTaskObjects(newTask.addDate, newTask.title, "", "");
        if (addToArrayList.isEmpty()) {
            System.out.println(RED_BOLD + "There are no tasks on your task manager" + "\n" + RESET);
            menu.mainMenu();
        } else {
            System.out.println(GREEN_BOLD + "Which task would you like to mark as completed" + RESET + CYAN_BOLD + "\nPlease enter the number" + RESET);
            int uno = 1;
            for (NewTaskObjects list : addToArrayList) {
                System.out.println(WHITE_BOLD + uno++ + ". " + list.title + RESET);
            }
        }
        Int = scanner.nextInt();
        newCompletedTask = addToArrayList.get(Int - 1);  //take user input and added it to a string
        newCompletedTask.setDueDate(dueDate.format(mDY));
        completed.add(newCompletedTask);                //add the string to the completed tasks list
        addToArrayList.remove(Int - 1);
        System.out.println(BLUE_BOLD + newCompletedTask.title + RESET + BLACK_BOLD + " has been marked as completed" + "\n" + RESET);
        menu.mainMenu();
    }
    public void uncompletedTaskList() {

        if (addToArrayList.isEmpty()) {
            System.out.println(RED_BOLD + "There are no uncompleted tasks at this moment" + RESET);
            System.out.println();
            menu.mainMenu();
        } else {
            System.out.println(PURPLE_BOLD + "Here is the list of the task you haven't completed" + RESET);
        }
        int uno = 1;
        for (NewTaskObjects list3 : addToArrayList) {
            System.out.println(WHITE_BOLD + uno++ + ". " + list3.title + " that was added on " + RESET + CYAN_BOLD + list3.addDate + RESET + WHITE_BOLD + "\nand it is not completed." + RESET);
        }
        System.out.println(BLUE_BOLD + "\n" + "What would you like to do?" + RESET + GREEN_BOLD + "\n1. Edit a task" + RESET + YELLOW_BOLD + "\n2. mark as complete" + RESET + PURPLE_BOLD + "\n3. delete a task" + RESET + WHITE_BOLD + "\n4. go to the main menu" + RESET);
        answer = scanner.nextLine();

        if (answer.equals("1")) {
            seeDetails();
        } else if (answer.equals("2")) {
            markAsComplete();
        } else if (answer.equals("3")) {
            deleteTasks();
        } else if (answer.equals("4")) {
            System.out.println(RED_BOLD + "Please enter a valid number" + "\n" + RESET);
            menu.mainMenu();
        }
    }
    public void seeDetails() {

        if (addToArrayList.isEmpty()) {
            System.out.println(RED_BOLD + "There are no tasks to edit on your task manager" + "\n" + RESET);
            menu.mainMenu();
        } else {
            System.out.println(BLUE_BOLD + "These are the details of the tasks you have added:" + "\n" + RESET);
            int uno = 1;
            for (NewTaskObjects diplayDetails : addToArrayList) {
                System.out.println(WHITE_BOLD + uno++ + ". " + diplayDetails.title + "\nthat you added on " + diplayDetails.addDate + "\nand is due on " + diplayDetails.dueDate + "\nit is " + diplayDetails.completedOrNot + "\n" + RESET);
            }
        }
        System.out.println(BLUE_BOLD + "Please choose one of the following:" + RESET + CYAN_BOLD +  "\n1. edit a task" + RESET + GREEN_BOLD + "\n2. go to main menu" + RESET);
        response = scanner.nextLine();
        if (response.equals("1")){
            System.out.println(YELLOW_BOLD + "Which one would you like to change?" + RESET + GREEN_BOLD + "\nPlease enter the number" + RESET);
            editTask();
        }else if (response.equals("2")) {
            menu.mainMenu();
        }
    }
    public void editTask() {

        integer = scanner.nextInt();
        editedGame = addToArrayList.get(integer - 1);

        System.out.println(BLUE_BOLD + "What would you like to change?" + RESET + CYAN_BOLD + "\n1. Name" + RESET + GREEN_BOLD + "\n2. Due date" + RESET);

        switch (scanner.nextInt()) {

            case 1:
                System.out.println(WHITE_BOLD + "What will be the new name for the task " + RESET + BLUE_BOLD + editedGame.title + RESET);
                scanner.nextLine();
                addToArrayList.get(integer - 1).setTitle(scanner.nextLine());
                break;
            case 2:
                do { scanner.nextLine();
                    System.out.println(BLUE_BOLD + "What would be the new due date for the task " + editedGame.title + "? (yyyy-mm-dd)" + RESET);
                    String newDueDate;
                    newDueDate = scanner.nextLine();
                    newDueDateLocalDate = LocalDate.parse(newDueDate);
                    addToArrayList.get(integer - 1).setDueDate(String.valueOf(newDueDateLocalDate.format(mDY)));
                    if (newDueDateLocalDate.isBefore(LocalDate.now())) {
                        System.out.println(CYAN_BOLD + "That date has already passed, try to add a date in the future\nPress enter to try again" + RESET);
                    } else if (newDueDateLocalDate.isAfter(LocalDate.now())) {
                        newTask.setDueDate(newDueDateLocalDate.format(mDY));
                    }
                }while (newDueDateLocalDate.isBefore(LocalDate.now()));
                break;
            default:
                System.out.println(RED_BOLD + "Please enter a valid number" + RESET);
                editTask();
        }
        System.out.println(GREEN_BOLD + "The modifications have been realized" + "\n" + RESET);
        menu.mainMenu();
    }
    public  void sortTasksMenu () {
        System.out.println(CYAN_BOLD + "How would you like to sort your tasks" + RESET + PURPLE_BOLD + "\nEnter a number to select." + RESET + BLACK_BOLD + "\n1. by Name" + RESET + YELLOW_BOLD + "\n2. by Due date" + RESET + BLUE_BOLD + "\n3. by Add date" + RESET + WHITE_BOLD + "\n4. by Completed date" + RESET + CYAN_BOLD + "\n5. go to main menu" + RESET);

        response = scanner.nextLine();
        if (response.equals("1")){
        sortTasks();
        }else if (response.equals("2")){

        }else if (response.equals("3")){

        }else if (response.equals("4")){

        }else{
            menu.mainMenu();
        }
    }
    public void sortTasks() {
//
//        for (NewTaskObjects sort : addToArrayList) {
//            sort(newTask.title);
//            Collections.sort(newTask);
//            System.out.println(Arrays.toString(new NewTaskObjects[]{sort}));
        }
    }
//}


