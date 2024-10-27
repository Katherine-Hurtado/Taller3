package com.katherine.taller_3.service;

import com.katherine.taller_3.model.Libro;
import com.katherine.taller_3.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;


    // Crear un libro
    public Libro createBook(Libro libro) {
        return libroRepository.save(libro);
    }

    //Obtener todos los libros.
    public List<Libro> getAllBooks() {
        return libroRepository.findAll();
    }

    //Obtener libro por Id.
    public Optional<Libro> getBookById(Long id) {
        return libroRepository.findById(id);
    }

    //Actualizar un libro.
    public Libro updateBook(Long id, Libro libroDetails) {
        Libro libro = libroRepository.findById(id).orElseThrow();
        libro.setAutor(libroDetails.getAutor());
        libro.setTitulo(libroDetails.getTitulo());
        libro.setIsbn(libroDetails.getIsbn());
        return libroRepository.save(libro);
    }

    //Eliminar un libro.
    public void deleteBook(Long id) {
        libroRepository.deleteById(id);
    }

}