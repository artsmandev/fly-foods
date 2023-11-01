package dev.artsman.flyfoods.state.domain.repository;

import dev.artsman.flyfoods.state.domain.model.State;
import java.util.List;

public interface StateRepository {
	List<State> findAll();

	State create(State state);

	State findById(Long id);

	void remove(State state);
}
