package dev.artsman.flyfoods.cuisine.domain.repository;

import dev.artsman.flyfoods.cuisine.domain.model.Cuisine;
import java.util.List;

public interface CuisineRepository {
	List<Cuisine> findAll();

	Cuisine findBy(Long Id);

	Cuisine save(Cuisine cuisine);

	void remove(Cuisine cuisine);
}
