package dev.artsman.flyfoods.city.api.controller;

import dev.artsman.flyfoods.city.domain.model.City;
import dev.artsman.flyfoods.city.domain.repository.CityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
class CityController {
	private final CityRepository repository;

	@GetMapping
	List<City> findAll() {
		return repository.findAll();
	}
}
