package com.anton.javFxSpringApp.dataSource;

import com.anton.javFxSpringApp.models.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @autor slonikmak on 26.04.2017.
 */
public interface TaskItemDao extends JpaRepository<TaskItem, Long> {
    TaskItem save(TaskItem taskItem);

    void delete(TaskItem taskItem);

    List<TaskItem> findAll();
}
