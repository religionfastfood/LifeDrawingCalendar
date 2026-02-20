package com.example.lifedrawingcalendar.repository;

import com.example.lifedrawingcalendar.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
