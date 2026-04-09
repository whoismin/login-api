package com.fatec.login.repository;


import com.fatec.login.model.Login;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface LoginRepository extends MongoRepository<Login, String> {
}
