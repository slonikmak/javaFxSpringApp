package com.anton.javFxSpringApp.models;

import javafx.beans.property.SimpleBooleanProperty;

import javax.persistence.*;

/**
 * Created by Anton on 11.02.2017.
 */
@Entity
public class TaskItem {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private SimpleBooleanProperty completed = new SimpleBooleanProperty(false);

    public TaskItem() {

    }

    public TaskItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Access(AccessType.PROPERTY)
    public boolean getCompleted() {
        return completed.get();
    }

    public void setCompleted(boolean completed) {
        this.completed.set(completed);
    }

    public SimpleBooleanProperty completedProperty() {
        return completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
