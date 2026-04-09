package com.fatec.login.service;


import com.fatec.login.model.Login;
import com.fatec.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    //post para salvar um novo usuário no mongo
    public Login salvar(Login login){
        return repository.save(login);
    }

    //put para atualizar os dados no banco
    public Login atualizar(String id, Login loginAtualizado){
        Optional<Login> loginExistente = repository.findById(id);
        if (loginExistente.isPresent()){
            Login login = loginExistente.get();
            login.setUsername(loginAtualizado.getUsername());
            login.setPassword(loginAtualizado.getPassword());
            login.setEmail(loginAtualizado.getEmail());
            login.setRoles(loginAtualizado.getRoles());
            return repository.save(login);
        }

        return null;
    }
    //deletar um usuário pelo o ID
    public void detelar(String id){
        repository.deleteById(id);
    }
     //lista todos os usuários castrados
    public List<Login> listar (){
        return repository.findAll();
    }
}
