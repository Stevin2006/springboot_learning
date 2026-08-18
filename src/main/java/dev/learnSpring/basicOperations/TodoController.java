package dev.learnSpring.basicOperations;


import dev.learnSpring.basicOperations.Entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        System.out.println(data);
        if(data == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(data, HttpStatus.OK);
    }






}


