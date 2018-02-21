package com.company;

public class CompletedObjects {

    private String completedAddDate;
    private String completedTitle;
    private String completedOrNot;
    private String completedDueDate;

    public CompletedObjects(String completedAddDate, String completedTitle, String completedOrNot, String completedDueDate) {
        this.completedAddDate = completedAddDate;
        this.completedTitle = completedTitle;
        this.completedOrNot = completedOrNot;
        this.completedDueDate = completedDueDate;
    }

    public String getCompletedAddDate() {
        return completedAddDate;
    }

    public void setCompletedAddDate(String completedAddDate) {
        this.completedAddDate = completedAddDate;
    }

    public String getCompletedTitle() {
        return completedTitle;
    }

    public void setCompletedTitle(String completedTitle) {
        this.completedTitle = completedTitle;
    }

    public String getCompletedOrNot() {
        return completedOrNot;
    }

    public void setCompletedOrNot(String completedOrNot) {
        this.completedOrNot = completedOrNot;
    }

    public String getCompletedDueDate() {
        return completedDueDate;
    }

    public void setCompletedDueDate(String completedDueDate) {
        this.completedDueDate = completedDueDate;
    }
}
