package com.example.lifedrawingcalendar.repository;

import com.example.lifedrawingcalendar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUserId(Long userId);

    User getByUserId(Long userId);
}
