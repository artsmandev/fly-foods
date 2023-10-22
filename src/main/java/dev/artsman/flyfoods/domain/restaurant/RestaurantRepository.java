package dev.artsman.flyfoods.domain.restaurant;

import java.util.List;

public interface RestaurantRepository {
	List<Restaurant> findAll();

	Restaurant findBy(Long id);

	Restaurant save(Restaurant restaurant);

	void remove(Restaurant restaurant);
}
