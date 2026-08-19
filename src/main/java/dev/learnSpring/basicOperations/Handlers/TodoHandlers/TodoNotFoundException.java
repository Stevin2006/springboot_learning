package dev.learnSpring.basicOperations.Handlers.TodoHandlers;


public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(String message){
        super(message);
    }



}
