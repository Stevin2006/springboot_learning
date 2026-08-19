package dev.learnSpring.basicOperations.Controllers;


import dev.learnSpring.basicOperations.Entities.Todo;
import dev.learnSpring.basicOperations.Services.TodoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    ResponseEntity<Todo> createTodo(@Valid @RequestBody Todo data){
        return new ResponseEntity<>(todoServices.createTodo(data), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        
        Todo data = todoServices.getTodoById(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(todoServices.getAllTodos(), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Todo> deleteTodoById(@PathVariable Long id){
        todoServices.deleteTodoById(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodo(@PathVariable Long id , @RequestBody Todo todo){

       Todo data = todoServices.updateTodo(id,todo);
       return new ResponseEntity<>(data, HttpStatus.OK);

    }


    @PatchMapping("/{id}")
    ResponseEntity<Todo> patchTodo(@PathVariable Long id , @RequestBody Todo data){

        Todo entry = todoServices.patchTodo(id,data);
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getAllTodos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return new ResponseEntity<>(todoServices.getAllTodos(page,size), HttpStatus.OK);
    }



}


