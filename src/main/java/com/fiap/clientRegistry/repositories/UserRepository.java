package com.fiap.clientRegistry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.clientRegistry.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}
