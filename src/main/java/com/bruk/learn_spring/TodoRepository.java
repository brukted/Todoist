package com.bruk.learn_spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    @Query("SELECT t FROM Todo t WHERE t.isCompleted = true ORDER BY t.deadline")
    List<Todo> findCompleted();

    @Query("SELECT t FROM Todo t WHERE t.isCompleted = false AND t.deadline >= CURRENT_DATE ORDER BY t.deadline")
    List<Todo> findUpcoming();

    @Query("SELECT t FROM Todo t WHERE t.isCompleted = false AND t.deadline < CURRENT_DATE ORDER BY t.deadline")
    List<Todo> findMissing();
}