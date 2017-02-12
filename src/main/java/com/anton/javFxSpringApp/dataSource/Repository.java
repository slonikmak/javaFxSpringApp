package com.anton.javFxSpringApp.dataSource;

import com.anton.javFxSpringApp.models.TaskItem;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.springframework.stereotype.Component;

/**
 * Created by Anton on 11.02.2017.
 */
@Component
public class Repository {
    //Контейнер для хранения всех задач.
    //В параметре метода observableArrayList указываем поле объекта TaskItem, изменение которого будем отслеживать
    //Слушатели, подписанные на коллекцию, будут срабатывать как на добавление/удаление элементов,
    //так и на изменение поля active каждого элемента
    private ObservableList<TaskItem> allTasks = FXCollections.observableArrayList(item -> new Observable[]{item.completedProperty()});

    //В это списке хранятся завершённые задачи
    private FilteredList<TaskItem> completedTasks = new FilteredList<TaskItem>(allTasks, TaskItem::isCompleted);

    //В этом списке храняться не завершённые задачи
    private FilteredList<TaskItem> activeTasks = new FilteredList<TaskItem>(allTasks, taskItem -> !taskItem.isCompleted());

    //Этот список служит для связывания с отображением ListView
    private ListProperty<TaskItem> tasksProperty = new SimpleListProperty<>(allTasks);

    public ObservableList<TaskItem> tasksProperty(){
        return tasksProperty;
    }

    public ObservableList<TaskItem> allTasksProperty(){
        return allTasks;
    }

    public ObservableList<TaskItem> activeTasksProperty(){
        return activeTasks;
    }

    public ObservableList<TaskItem> completedTasksProperty(){
        return completedTasks;
    }

    public void showAllTasks(){
        tasksProperty.set(allTasks);
    }

    public void showCompletedTasks(){
        tasksProperty.set(completedTasks);
    }

    public void showActiveTasks(){
        tasksProperty.set(activeTasks);
    }

    public void addTask(TaskItem taskItem){
        allTasks.add(taskItem);
    }

    public void deleteTask(TaskItem taskItem){
        allTasks.remove(taskItem);
    }



}
