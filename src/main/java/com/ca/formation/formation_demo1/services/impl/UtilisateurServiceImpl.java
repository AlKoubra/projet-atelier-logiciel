package com.ca.formation.formation_demo1.services.impl;

import com.ca.formation.formation_demo1.models.Role;
import com.ca.formation.formation_demo1.models.Utilisateur;
import com.ca.formation.formation_demo1.repositories.UtilisateurRepository;
import com.ca.formation.formation_demo1.services.UtilisateurService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.Set;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder,
                                  AuthenticationManager authenticationManager) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Utilisateur registration(Utilisateur utilisateurRequest) throws ValidationException {

        if(utilisateurRepository.findByUsername(utilisateurRequest.getUsername()).isPresent()){
            throw new ValidationException("Utilisateur existe deja");
        }

        if(utilisateurRequest.getAuthority() == null){
            utilisateurRequest.setAuthoritie(Set.of(new Role(Role.READ)));
        }

        Utilisateur utilisateur = utilisateurRequest;

        utilisateur.setPassword(passwordEncoder.encode(utilisateurRequest.getPassword()));

        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur login(Utilisateur utilisateurRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(utilisateurRequest.getUsername(), utilisateurRequest.getPassword()));

        Utilisateur utilisateur = (Utilisateur) authentication.getPrincipal();

        return utilisateur;
    }
}
