package com.anton.javFxSpringApp.controllers;

import com.anton.javFxSpringApp.models.TaskItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Anton on 11.02.2017.
 */
@Component
@Scope("prototype")
public class ItemController {
    MainController mainController;

    private TaskItem item;
    @FXML
    private Label taskHeader;

    @FXML
    private Label taskStatus;

    @FXML
    private CheckBox complitedCheckBox;

    @FXML
    void deleteTask(ActionEvent event) {
        mainController.deleteTask(item);
    }

    public void setItem(TaskItem item) {
        this.item = item;
        taskHeader.setText(item.getName());
        complitedCheckBox.selectedProperty().bindBidirectional(item.completedProperty());
        item.completedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) taskStatus.setText("completed");
            else taskStatus.setText("active");
        });
    }

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
