package dev.artsman.flyfoods.domain.cuisine;

import java.util.List;

public interface CuisineRepository {
	List<Cuisine> findAll();

	Cuisine findBy(Long Id);

	Cuisine save(Cuisine cuisine);

	void remove(Cuisine cuisine);
}
