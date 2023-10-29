package dev.artsman.flyfoods.domain.state;

import java.util.List;

public interface StateRepository {
	List<State> findAll();

	State create(State state);

	State findById(Long id);

	void remove(State state);
}
