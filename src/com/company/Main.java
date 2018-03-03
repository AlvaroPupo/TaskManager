package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException{
/*
        Objectives
        1. User should be able to create new tasks.
        2. User should be able to see a list of all tasks (Completed and Uncompleted).
        3. User should be able to see a list of only uncompleted tasks.
        4. User should be able to see a list of only completed tasks.
        5. User should be able to mark a task complete.
        6. User should be able to delete a task.
        7. User should be able to edit a task.
        8. User should be able to select a task and view its details.
        9. User should be able to exit the program.
        10. The program should display menu(s) listing all possible actions the user can take.
        11. The program should include error handling to account for incorrect user input.
                Each task should have:
        Title
        Due date
        Details of task
        Date task was completed (if Complete) */

        mainMenu menu = new mainMenu();
        menu.mainMenu();
    }


}
