package com.anton.javFxSpringApp.controllers;

import com.anton.javFxSpringApp.dataSource.Repository;
import com.anton.javFxSpringApp.loaderProvider.FXMLLoaderProvider;
import com.anton.javFxSpringApp.models.TaskItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Anton on 11.02.2017.
 */
@Component
public class TasksController implements Initializable {
    private Repository repository;
    private FXMLLoaderProvider loaderProvider;
    private String pathToTaskFxml = "/task.fxml";
    private Map<TaskItem, Node> taskNodeCache = new HashMap<>();

    @FXML
    ListView<TaskItem> tasksList;


    public void initialize(URL location, ResourceBundle resources) {
        tasksList.setItems(repository.tasksProperty());

        tasksList.setCellFactory(new Callback<ListView<TaskItem>, ListCell<TaskItem>>() {
            @Override
            public ListCell<TaskItem> call(ListView<TaskItem> param) {
                return new ListCell<TaskItem>(){
                    @Override
                    protected void updateItem(TaskItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty){
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(null);

                            if (!taskNodeCache.containsKey(item)) {
                                final Node parent = loadTaskFxml(item);
                                taskNodeCache.put(item, parent);
                            }

                            final Node node = taskNodeCache.get(item);

                            Node currentNode = getGraphic();
                            if (currentNode == null || !currentNode.equals(node)) {
                                setGraphic(node);
                            }
                        }
                    }
                };
            }
        });
    }

    private Node loadTaskFxml(TaskItem item){
        FXMLLoader loader = loaderProvider.getLoader(pathToTaskFxml);

        try {
            Node node = loader.load();
            ItemController itemController = (ItemController) loader.getController();
            itemController.setItem(item);

            return node;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setLoaderProvider(FXMLLoaderProvider loaderProvider) {
        this.loaderProvider = loaderProvider;
    }
}
