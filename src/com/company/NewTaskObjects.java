package com.company;

public class NewTaskObjects {

    public String addDate;
    public String title;
    public String completedOrNot;
    public String dueDate;

    public NewTaskObjects(String addDate, String title, String dueDate, String completedOrNot) {
        this.addDate = addDate;
        this.title = title;
        this.completedOrNot = completedOrNot;
        this.dueDate = dueDate;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getCompletedOrNot() {
        return completedOrNot;
    }

    public void setCompletedOrNot(String completedOrNot){
        this.completedOrNot = completedOrNot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return dueDate;
    }
}
