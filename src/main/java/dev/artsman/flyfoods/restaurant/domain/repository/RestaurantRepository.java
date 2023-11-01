package dev.artsman.flyfoods.restaurant.domain.repository;

import dev.artsman.flyfoods.restaurant.domain.model.Restaurant;
import java.util.List;

public interface RestaurantRepository {
	List<Restaurant> findAll();

	Restaurant findBy(Long id);

	Restaurant save(Restaurant restaurant);

	void remove(Restaurant restaurant);
}
