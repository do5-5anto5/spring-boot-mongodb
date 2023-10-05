package com.do55anto5.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.do55anto5.workshopmongo.domain.Post;
import com.do55anto5.workshopmongo.domain.User;
import com.do55anto5.workshopmongo.dto.AuthorDTO;
import com.do55anto5.workshopmongo.dto.CommentDTO;
import com.do55anto5.workshopmongo.repository.PostRepository;
import com.do55anto5.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Gray", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, formatter.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, formatter.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		var comment1 = new CommentDTO("Boa viagem mano!", formatter.parse("21/03/2018"), new AuthorDTO(alex));
		var comment2 = new CommentDTO("Aproveite", formatter.parse("22/03/2018"), new AuthorDTO(bob));
		var comment3 = new CommentDTO("Tenha um ótimo dia!", formatter.parse("23/03/2018"), new AuthorDTO(alex));
		
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().add(comment3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
