package com.katherine.taller_3.repository;

import com.katherine.taller_3.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona, Long> {

}
