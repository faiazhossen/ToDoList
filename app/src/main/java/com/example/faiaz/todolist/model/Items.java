package com.example.faiaz.todolist.model;

/**
 * Created by FAIAZ on 9/24/2017.
 */

public class Items {
    String taskName;
    String time;

    public Items(String taskName, String time) {
        this.taskName = taskName;
        this.time = time;
    }

    public Items() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
