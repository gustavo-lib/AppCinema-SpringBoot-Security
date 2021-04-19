package com.gortiz.AppCinema.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gortiz.AppCinema.Entity.Rol;
import com.gortiz.AppCinema.Entity.Usuario;
import com.gortiz.AppCinema.Enum.RolNombre;
import com.gortiz.AppCinema.Serivices.RolService;
import com.gortiz.AppCinema.Serivices.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@Service
public class NuevoAdmi implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
       /*Usuario usuario = new Usuario();
        String passwordEncoded = passwordEncoder.encode("admin");
        usuario.setNombreUsuario("admin");
        usuario.setPassword(passwordEncoded);
        Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolAdmin);
        roles.add(rolUser);
        usuario.setRoles(roles);
        usuarioService.save(usuario);   /**/
    }
}