package dev.learnSpring.basicOperations.Services;


import dev.learnSpring.basicOperations.Entities.Todo;
import dev.learnSpring.basicOperations.Handlers.TodoHandlers.TodoNotFoundException;
import dev.learnSpring.basicOperations.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Todo with id " + id + " not found"));
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo deleteTodoById(Long id){
        Todo data = todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Todo with id " + id + " not found"));
        todoRepository.delete(data);
        return data;
    }



    public Todo updateTodo(Long id ,Todo data){

        Todo oData = todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Todo with id " + id + " not found"));

        oData.setTitle(data.getTitle());
        oData.setDescription(data.getDescription());
        oData.setStatus(data.getStatus());
        return todoRepository.save(oData);
    }

    public Todo patchTodo(Long id , Todo data){
        Todo oData = todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Todo with id " + id + " not found"));
        if(data.getTitle() != null){
            oData.setTitle(data.getTitle());
        }if(data.getDescription() != null){
            oData.setDescription(data.getDescription());
        }if(data.getStatus() != null){
            oData.setStatus(data.getStatus());
        }

        return todoRepository.save(oData);
    }

    public Page<Todo> getAllTodos(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return todoRepository.findAll(pageable);
    }




}
