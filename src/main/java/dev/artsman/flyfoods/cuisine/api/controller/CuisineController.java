package dev.artsman.flyfoods.cuisine.api.controller;

import dev.artsman.flyfoods.cuisine.domain.model.Cuisine;
import dev.artsman.flyfoods.cuisine.domain.repository.CuisineRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuisines")
@RequiredArgsConstructor
class CuisineController {
	private final CuisineRepository repository;

	@GetMapping
	List<Cuisine> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	Cuisine findById(@PathVariable Long id) {
		return repository.findBy(id);
	}
}
