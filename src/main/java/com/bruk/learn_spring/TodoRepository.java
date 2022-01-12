package com.bruk.learn_spring;

import java.util.List;

import com.bruk.learn_spring.security.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    @Query("SELECT t FROM Todo t WHERE t.user = :user AND t.isCompleted = true ORDER BY t.deadline")
    List<Todo> findCompleted(User user);

    @Query("SELECT t FROM Todo t WHERE t.user = :user AND t.isCompleted = false AND t.deadline >= CURRENT_DATE ORDER BY t.deadline")
    List<Todo> findUpcoming(User user);

    @Query("SELECT t FROM Todo t WHERE t.user = :user AND t.isCompleted = false AND t.deadline < CURRENT_DATE ORDER BY t.deadline")
    List<Todo> findMissing(User user);
}