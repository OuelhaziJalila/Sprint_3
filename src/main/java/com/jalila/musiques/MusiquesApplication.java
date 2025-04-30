package com.jalila.musiques;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jalila.musiques.entities.Musique;
import com.jalila.musiques.entities.Role;
import com.jalila.musiques.entities.User;
import com.jalila.musiques.entities.Genre;
import com.jalila.musiques.service.MusiqueService;
import com.jalila.musiques.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MusiquesApplication implements CommandLineRunner {

    @Autowired
    MusiqueService musiqueService;

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired 
    PasswordEncoder passwordEncoder;
	@Autowired 
    UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(MusiquesApplication.class, args);
    }
/*
    @PostConstruct
    void init_users() {
    //ajouter les rôles
    userService.addRole(new Role(null,"ADMIN"));
    userService.addRole(new Role(null,"AGENT"));
    userService.addRole(new Role(null,"USER"));
    //ajouter les users
    userService.saveUser(new User(null,"admin","123",true,null));
    userService.saveUser(new User(null,"jalila","123",true,null));
    userService.saveUser(new User(null,"user1","123",true,null));
    //ajouter les rôles aux users
    userService.addRoleToUser("admin", "ADMIN");
    userService.addRoleToUser("jalila", "USER");
    userService.addRoleToUser("jalila", "AGENT");
    userService.addRoleToUser("user1", "USER");
    }
*/
    
    @Override
    public void run(String... args) throws Exception {
    	//System.out.println("Password Encoded BCRYPT :******************** ");
    	 //System.out.println(passwordEncoder.encode("123")); 
		repositoryRestConfiguration.exposeIdsFor(Musique.class);

 } @Bean
    public ModelMapper modelMapper() {
     return new ModelMapper();
 }
    
    }
