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
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo deleteTodoById(Long id){
        Todo data = todoRepository.findById(id).orElse(null);
        if(data == null){
            return null;
        }
        todoRepository.delete(data);
        return data;
    }



    public Todo updateTodo(Long id ,Todo data){

        Todo oData = todoRepository.findById(id).orElse(null);
        if(oData == null){
            return null;
        }
        oData.setTitle(data.getTitle());
        oData.setDescription(data.getDescription());
        oData.setStatus(data.getStatus());
        return todoRepository.save(oData);
    }

    public Todo patchTodo(Long id , Todo data){
        Todo oData = todoRepository.findById(id).orElse(null);
        if(oData == null){
            return null;
        }

        if(data.getTitle() != null){
            oData.setTitle(data.getTitle());
        }if(data.getDescription() != null){
            oData.setDescription(data.getDescription());
        }if(data.getStatus() != null){
            oData.setStatus(data.getStatus());
        }

        return todoRepository.save(oData);
    }




}
