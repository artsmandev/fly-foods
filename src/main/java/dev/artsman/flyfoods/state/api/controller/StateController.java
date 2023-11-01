package dev.artsman.flyfoods.state.api.controller;

import dev.artsman.flyfoods.state.domain.model.State;
import dev.artsman.flyfoods.state.domain.repository.StateRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
class StateController {
	private final StateRepository repository;

	@GetMapping
	List<State> findAll() {
		return repository.findAll();
	}
}
