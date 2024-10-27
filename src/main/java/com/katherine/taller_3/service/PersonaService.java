package com.katherine.taller_3.service;

import com.katherine.taller_3.model.Persona;
import com.katherine.taller_3.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    //Crear una persona.
    public Persona createPerson(Persona persona) {
        return personaRepository.save(persona);
    }

    //Obtener todas las personas.
    public List<Persona> getAllPeople() {
        return personaRepository.findAll();
    }

    //Obtener persona por Id.
    public Optional<Persona> getPersonById(Long id) {
        return personaRepository.findById(id);
    }

    //Actualizar una persona.
    public Persona updatePersonFromTDO(Long id, Persona personaDetails) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setNombre(personaDetails.getNombre());
        persona.setApellido(personaDetails.getApellido());
        persona.setTipo(personaDetails.getTipo());
        return personaRepository.save(persona);
    }

    //Eliminar una persona.
    public void deletePerson(Long id) {
        personaRepository.deleteById(id);
    }
}
