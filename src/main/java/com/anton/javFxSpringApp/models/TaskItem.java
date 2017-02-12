package com.anton.javFxSpringApp.models;

import javafx.beans.property.SimpleBooleanProperty;

/**
 * Created by Anton on 11.02.2017.
 */
public class TaskItem {
    private String name;
    private SimpleBooleanProperty complited = new SimpleBooleanProperty(false);

    public TaskItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return complited.get();
    }

    public SimpleBooleanProperty completedProperty() {
        return complited;
    }
}
