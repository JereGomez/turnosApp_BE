package com.example.turnosApp.repository;


import com.example.turnosApp.models.entity.Token;
import com.example.turnosApp.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, User> {

    List<Token> findAllValidIsFalseOrRevokedIsFalseByUser(User user);

    Token findByToken(String jwt);
}
