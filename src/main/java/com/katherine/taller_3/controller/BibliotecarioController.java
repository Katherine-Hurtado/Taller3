package com.katherine.taller_3.controller;

import com.katherine.taller_3.model.Bibliotecario;
import com.katherine.taller_3.service.BibliotecarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bibliotecarios")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService bibliotecarioService;

    // Crear un Bibliotecario
    @Operation(summary = "Este POST crea un nuevo bibliotecario.", description = "")
    @PostMapping
    public Bibliotecario createLibrarian(Bibliotecario bibliotecario) {
        return bibliotecarioService.createLibrarian(bibliotecario);
    }

    // Obtener todos los bibliotecarios
    @Operation(summary = "Este GET muestra todos los bibliotecarios.", description = "")
    @GetMapping
    public List<Bibliotecario> getAllLibrarians() {
        return bibliotecarioService.getAllLibrarians();
    }

    // Obtener bibliotecario por ID
    @Operation(summary = "Este GET muestra un bibliotecario por Id.", description = "")
    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> getLibrarianById(@PathVariable Long id) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioService.getLibrarianById(id);
        return bibliotecario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un Bibliotecario
    @Operation(summary = "Este PUT actualiza un bibliotecario mediante su Id.", description = "")
    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> updateLibrarian(@PathVariable Long id, @RequestBody Bibliotecario bibliotecarioDetails) {
        return ResponseEntity.ok(bibliotecarioService.updateLibrarian(id, bibliotecarioDetails));
    }

    //Eliminar un bibliotecario.
    @Operation(summary = "Este DELETE elimina un bibliotecario mediante su Id.", description = "")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletelibrarian(@PathVariable Long id) {
        bibliotecarioService.deleteLibrarian(id);
        return ResponseEntity.noContent().build();
    }
}
