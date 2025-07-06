package com.sanyam.todo.service;

import com.sanyam.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<Todo> getAll() {
        return todos.stream().filter(t -> !t.isDeleted()).collect(Collectors.toList());
    }

    public Todo create(String title) {
        Todo todo = new Todo(idCounter.getAndIncrement(), title);
        todos.add(todo);
        return todo;
    }

    public Todo getById(int id) {
        return todos.stream().filter(t -> t.getId() == id && !t.isDeleted()).findFirst().orElse(null);
    }

    public Todo update(int id, Todo updated) {
        Todo todo = getById(id);
        if (todo != null) {
            todo.setTitle(updated.getTitle());
            todo.setCompleted(updated.isCompleted());
        }
        return todo;
    }

    public boolean delete(int id) {
        Todo todo = getById(id);
        if (todo != null) {
            todo.setDeleted(true);
            return true;
        }
        return false;
    }
}

