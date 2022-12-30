package com.ca.formation.formation_demo1.repositories;

import com.ca.formation.formation_demo1.models.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByUsername(String username);
}