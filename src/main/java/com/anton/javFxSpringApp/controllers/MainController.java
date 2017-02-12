package com.anton.javFxSpringApp.controllers;

import com.anton.javFxSpringApp.dataSource.Repository;
import com.anton.javFxSpringApp.models.TaskItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {
    Repository repository;

    public void deleteTask(TaskItem item){
        repository.deleteTask(item);
    }

    public void showAllTasks(){
        repository.showAllTasks();
    }
    public void showActiveTasks(){
        repository.showActiveTasks();
    }
    public void showCompletedTasks(){
        repository.showCompletedTasks();
    }

    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }


}
