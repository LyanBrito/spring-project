package com.todo.todolist.repository;

import com.todo.todolist.entityModel.Status;
import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    Task findById(long id);
    public Task findByName(String name);
    public Task findByStatus(Status status);
    public Task findByUser(User user);
}
