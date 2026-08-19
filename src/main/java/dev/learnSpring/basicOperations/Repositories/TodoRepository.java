package dev.learnSpring.basicOperations.Repositories;

import dev.learnSpring.basicOperations.Entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


//CRUD - Create, Read, Update, Delete, Patch

@Component
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
