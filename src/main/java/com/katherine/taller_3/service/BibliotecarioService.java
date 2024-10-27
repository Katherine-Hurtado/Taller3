package com.katherine.taller_3.service;

import com.katherine.taller_3.model.Bibliotecario;
import com.katherine.taller_3.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;


   // Crear un Bibliotecario
   public Bibliotecario createLibrarian(Bibliotecario bibliotecario) {
       return bibliotecarioRepository.save(bibliotecario);
   }

   // Obtener todos los bibliotecarios
   public List<Bibliotecario> getAllLibrarians() {
       return bibliotecarioRepository.findAll();
   }

   // Obtener bibliotecario por ID
   public Optional<Bibliotecario> getLibrarianById(Long id) {
       return bibliotecarioRepository.findById(id);
   }

   // Actualizar un Bibliotecario
   public Bibliotecario updateLibrarian(Long id, Bibliotecario bibliotecarioDetails) {
       Bibliotecario bibliotecario = bibliotecarioRepository.findById(id).orElseThrow();
       return bibliotecarioRepository.save(bibliotecario);
   }

    //Eliminar un bibliotecario.
    public void deleteLibrarian(Long id) {
        bibliotecarioRepository.deleteById(id);
    }
}