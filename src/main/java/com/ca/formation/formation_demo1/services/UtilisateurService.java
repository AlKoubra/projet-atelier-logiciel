package com.ca.formation.formation_demo1.services;

import com.ca.formation.formation_demo1.models.Utilisateur;

import javax.xml.bind.ValidationException;

public interface UtilisateurService {

    Utilisateur registration(Utilisateur utilisateurRequest) throws ValidationException;

    Utilisateur login(Utilisateur utilisateurRequest);

}
