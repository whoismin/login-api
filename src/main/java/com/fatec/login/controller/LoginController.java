package com.fatec.login.controller;

import com.fatec.login.model.Login;
import com.fatec.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apilogin")
public class LoginController {
    @Autowired
    private LoginService service;

    @GetMapping("/login")
    public String realizarLogin() {
        return "login";
    }

   //Cria e salva um novo login no banco de dados
    @PostMapping("/accounts")
    public ResponseEntity<Login> criar(@RequestBody Login login) {
        Login salvo = service.salvar(login);
        return ResponseEntity.ok(salvo);
    }
    //atualiza um login que existe na porta 8085
    @PutMapping("/accounts/{id}")
    public ResponseEntity<Login> atualizar(@PathVariable String id, @RequestBody Login login) {
        Login atualizado = service.atualizar(id, login);
        if (atualizado == null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
    //remove um login do banco de dados
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Object> deletar(@PathVariable String id) {
        service.detelar(id);
        return ResponseEntity.noContent().build();
    }
   //lista todos os logins cadastrados
    @GetMapping("/accounts")
    public ResponseEntity<List<Login>> listar() {
        return ResponseEntity.ok(service.listar());
    }

}
