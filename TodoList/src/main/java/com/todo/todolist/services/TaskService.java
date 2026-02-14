package com.todo.todolist.services;

import com.todo.todolist.dto.TaskRequestDTO;
import com.todo.todolist.dto.TaskResponseDTO;
import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;
import com.todo.todolist.repository.TaskRepo;
import com.todo.todolist.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepository;
    private final UserRepo userRepository;

    public TaskService(TaskRepo taskRepository, UserRepo userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskResponseDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskResponseDTO::new).toList();
    }
    public TaskResponseDTO getTasksByUser(long user_id) {
        User user = userRepository.findById(user_id);
        return new TaskResponseDTO(taskRepository.findByUser(user));
    }

    public TaskResponseDTO addTask(TaskRequestDTO taskRequestDTO, long userId) {
        User user = userRepository.findById(userId);
        Task task = new Task(taskRequestDTO);
        task.setUser(user);
        taskRepository.save(task);
        return new TaskResponseDTO(task);
    }

    public String updateName(long id, Task taskRequestDTO) {
        Task task = taskRepository.getById(id);
        if (task == null) {
            return "tarefa não encontrada";
        } else {
            task.setName(taskRequestDTO.getName());
            taskRepository.save(task);
            return "tarefa atualizado com sucesso";
        }
    }
    public String deleteTask(long id) {
        Task task = taskRepository.getById(id);
        if (task == null) {
            return "tarefa não encontrada";
        } else  {
            taskRepository.delete(task);
            return "tarefa deletado com sucesso";
        }
    }
}