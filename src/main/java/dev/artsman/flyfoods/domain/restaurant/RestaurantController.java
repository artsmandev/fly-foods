package dev.artsman.flyfoods.domain.restaurant;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
class RestaurantController {
	private final RestaurantRepository repository;

	@GetMapping
	List<Restaurant> findAll() {
		return repository.findAll();
	}
}
