package com.CrudSpring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CrudSpring.model.Usuario;
import com.CrudSpring.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @RequestMapping(value = "/usuario/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvarUsuario(@PathVariable String nome) {
		Usuario u1 = new Usuario();
		
		u1.setNome(nome);
		
		
		usuarioRepository.save(u1);
    	return "Salvo";
    	
    }
    
    @RequestMapping(value = "usuario/listar", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarTodosUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        usuarioRepository.findAll().forEach(usuarios::add);

        return usuarios;
    }

    @RequestMapping(value = "usuario/deletar/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String deletarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);

        return "<h3>Usuario deletado. </h3>";
    }
}
