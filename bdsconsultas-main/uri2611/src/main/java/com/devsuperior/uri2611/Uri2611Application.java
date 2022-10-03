package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieNameDTO;
import com.devsuperior.uri2611.projections.MovieNameProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieNameProjection> list = repository.search1("Action");
		List<MovieNameDTO> result1 = list.stream().map(x -> new MovieNameDTO(x)).collect(Collectors.toList());

		System.out.println("\n*** RESULTADO SQL RAIZ:");
		for (MovieNameDTO obj: result1){
			System.out.println(obj);
		}

		List<MovieNameDTO> result2 = repository.search2("Action");

		System.out.println("\n*** RESULTADO JPQL:");
		for (MovieNameDTO obj: result2){
			System.out.println(obj);
		}

	}
}
