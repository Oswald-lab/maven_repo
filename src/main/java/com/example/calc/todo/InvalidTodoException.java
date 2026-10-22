package com.example.calc.todo;

public class InvalidTodoException extends RuntimeException {

    public InvalidTodoException(String message) {
        super(message);
    }
}
