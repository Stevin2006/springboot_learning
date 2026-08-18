package dev.learnSpring.basicOperations;


import dev.learnSpring.basicOperations.Entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo data){

        return todoRepository.save(data);
    }

    public Todo getTodoById(Long id){
        return todoRepository.getReferenceById(id);
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo deleteTodoById(Long id){
        Todo data = todoRepository.getReferenceById(id);
        todoRepository.delete(data);
        return data;
    }




}
