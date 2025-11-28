package com.todo.todolist.repository;

import com.todo.todolist.entiryModel.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    Task findById(long id);
}
