package com.crud.tasks.controller;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService dbService;
    private final TaskMapper taskMapper;



    @GetMapping
    public List<TaskDto> getTasks() {
        List<Task> tasks = dbService.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);

    }

    @GetMapping(value="{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) {
        return new TaskDto(1L,"test title", "test_content");
    }

    @DeleteMapping(value="{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
    }

    @PutMapping
    public TaskDto updateTask(TaskDto task) {
        return new TaskDto(1L, "Updated title", "Updated content");
    }

    @PostMapping
    public void createTask(TaskDto task) {
    }
}
