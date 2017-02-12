package com.anton.javFxSpringApp.controllers;

import com.anton.javFxSpringApp.dataSource.Repository;
import com.anton.javFxSpringApp.models.TaskItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Anton on 12.02.2017.
 */
@Component
public class HeaderController {


    private Repository repository;

    @FXML
    private TextField taskNameInput;

    @FXML
    void addTask(ActionEvent event) {
        repository.addTask(new TaskItem(taskNameInput.getText()));
    }

    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
