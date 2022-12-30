package com.ca.formation.formation_demo1.services;

import com.ca.formation.formation_demo1.exception.ResourceNotFoundException;
import com.ca.formation.formation_demo1.models.Personne;

import java.util.List;

public interface PersonneService {

    List<Personne> getPersonnes();

    Personne getPersonne(Long id) throws ResourceNotFoundException;

    Personne updatePersonne(Long id, Personne personne) throws ResourceNotFoundException ;

    Personne addPersonne(Personne personne);

    void deletePersonne(Long id);

    List<Personne> getPersonneParNom(String nom);
}
