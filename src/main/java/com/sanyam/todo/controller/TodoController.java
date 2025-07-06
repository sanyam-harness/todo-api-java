package com.sanyam.todo.controller;

import com.sanyam.todo.model.Todo;
import com.sanyam.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return todoService.create(todo.getTitle());
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable int id) {
        return todoService.getById(id);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable int id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return todoService.delete(id) ? "Deleted" : "Not found";
    }
}

