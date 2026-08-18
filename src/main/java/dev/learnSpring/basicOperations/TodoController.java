package dev.learnSpring.basicOperations;


import dev.learnSpring.basicOperations.Entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoServices todoServices;

    @PostMapping("/")
    ResponseEntity<Todo> createTodo(@RequestBody Todo data){
        return new ResponseEntity<>(todoServices.createTodo(data), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        
        Todo data = todoServices.getTodoById(id);

        if(data == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(todoServices.getAllTodos(), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Todo> deleteTodoById(@PathVariable Long id){
        Todo data = todoServices.deleteTodoById(id);
        if(data == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodo(@PathVariable Long id , @RequestBody Todo todo){

       Todo data = todoServices.updateTodo(id,todo);
       if(data == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(data, HttpStatus.OK);

    }


    @PatchMapping("/{id}")
    ResponseEntity<Todo> patchTodo(@PathVariable Long id , @RequestBody Todo data){

        Todo entry = todoServices.patchTodo(id,data);
        if(entry == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }



}


