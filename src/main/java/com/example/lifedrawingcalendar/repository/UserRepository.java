package com.example.lifedrawingcalendar.repository;

import com.example.lifedrawingcalendar.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUserId(Long id);

    User updateUser(Long id, User userDetails);
}
