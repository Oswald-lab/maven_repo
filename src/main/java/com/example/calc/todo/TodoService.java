package com.example.calc.todo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final Map<Long, Todo> todos = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Todo> findAll() {
        List<Todo> result = new ArrayList<>(todos.values());
        result.sort(Comparator.comparing(Todo::id));
        return result;
    }

    public Todo findById(Long id) {
        Todo todo = todos.get(id);
        if (todo == null) {
            throw new TodoNotFoundException(id);
        }
        return todo;
    }

    public Todo create(TodoRequest request) {
        Todo todo = new Todo(nextId.getAndIncrement(), request.title(), Boolean.TRUE.equals(request.completed()));
        todos.put(todo.id(), todo);
        return todo;
    }

    public Todo update(Long id, TodoRequest request) {
        findById(id);
        Todo todo = new Todo(id, request.title(), Boolean.TRUE.equals(request.completed()));
        todos.put(id, todo);
        return todo;
    }

    public void delete(Long id) {
        if (todos.remove(id) == null) {
            throw new TodoNotFoundException(id);
        }
    }
}
