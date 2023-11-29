package com.learn.Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.Spring.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    
}
