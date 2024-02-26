package com.ferjava.tienda;

import com.ferjava.tienda.models.ERole;
import com.ferjava.tienda.models.RoleEntity;
import com.ferjava.tienda.models.UserEntity;
import com.ferjava.tienda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Set;

@EntityScan(basePackages = {"com.ferjava.tienda"})
@ComponentScan(basePackages = {"com.ferjava.tienda"})
@Configuration
@EnableAutoConfiguration
@SpringBootApplication()
public class TiendaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TiendaApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName+ "**********************************************");
		}
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;
	@Bean
	CommandLineRunner init(){
		return args -> {
			UserEntity userEntity = new UserEntity();
			userEntity.setNombre("Josefiano");
			userEntity.setEmail("jseas@gmail.com");
			userEntity.setApellido("poplo");
			userEntity.setUsername("josefa");
			userEntity.setTelefono("987654321");
			userEntity.setPassword(passwordEncoder.encode("123456"));
			userEntity.setRoles(Set.of(new RoleEntity(ERole.USER)));

			UserEntity userEntity2 = new UserEntity();
			userEntity2.setNombre("Masofiano");
			userEntity2.setEmail("Maso@gmail.com");
			userEntity2.setApellido("proloplo");
			userEntity2.setUsername("maso");
			userEntity2.setTelefono("987645691");
			userEntity2.setPassword(passwordEncoder.encode("123456"));
			userEntity2.setRoles(Set.of(new RoleEntity(ERole.ADMIN)));

			UserEntity userEntity3 = new UserEntity();
			userEntity3.setNombre("Jdesko");
			userEntity3.setEmail("descño@yahoo.com");
			userEntity3.setApellido("poplso");
			userEntity3.setUsername("desko");
			userEntity3.setTelefono("656954321");
			userEntity3.setPassword(passwordEncoder.encode("123456"));
			userEntity3.setRoles(Set.of(new RoleEntity(ERole.INVITED)));
			userRepository.save(userEntity);
			userRepository.save(userEntity2);
			userRepository.save(userEntity3);
		};
	}
}
