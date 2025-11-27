package com.todo.todolist.services;

import com.todo.todolist.dto.TaskResponseDTO;
import com.todo.todolist.dto.UserRequestDTO;
import com.todo.todolist.entiryModel.Task;
import com.todo.todolist.repository.TaskRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public TaskResponseDTO saveTask(@Valid UserRequestDTO req) {
        Task task = new Task(req);
        taskRepo.save(task);
        return new TaskResponseDTO(task);
    }

    public List<TaskResponseDTO> findAll() {
        List<Task> tasks = taskRepo.findAll();
        List<TaskResponseDTO> taskResponseDTO = new ArrayList<>();

        for (Task task : tasks) {
            taskResponseDTO.add(new TaskResponseDTO(task));
        }
        return taskResponseDTO;
    }
    public String updateById(Long id, Task task) {
        Optional<Task> isTask = taskRepo.findById(id);

        if (isTask.isPresent()) {
            Task t = isTask.get();
            t.setName(task.getName());
            t.setDescription(task.getDescription());
            t.setCreatedDate(task.getCreatedDate());
            taskRepo.save(t);
            return t.toString();
        } else {
            return "Task bnot found";
        }
    }
    public Optional<Task> getById(long id) {
        return Optional.ofNullable(taskRepo.findById(id));
    }

    public String deleteById(long id) {
        taskRepo.deleteById(id);
        if (!taskRepo.existsById(id)) {
            return "Deletado com sucesso!";
        } else {
            return "User não deletado";
        }
    }
}
