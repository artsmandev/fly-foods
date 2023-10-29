package dev.artsman.flyfoods.domain.cuisine;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
}
