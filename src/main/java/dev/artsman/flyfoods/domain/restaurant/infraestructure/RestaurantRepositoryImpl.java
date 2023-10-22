package dev.artsman.flyfoods.domain.restaurant.infraestructure;

import dev.artsman.flyfoods.domain.restaurant.Restaurant;
import dev.artsman.flyfoods.domain.restaurant.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {
	@PersistenceContext
	private final EntityManager entityManager;

	@Override
	public List<Restaurant> findAll() {
		return entityManager.createQuery("from Restaurant", Restaurant.class).getResultList();
	}

	@Override
	public Restaurant findBy(Long id) {
		return entityManager.find(Restaurant.class, id);
	}

	@Override
	@Transactional
	public Restaurant save(Restaurant restaurant) {
		return entityManager.merge(restaurant);
	}

	@Override
	@Transactional
	public void remove(Restaurant restaurant) {
		entityManager.remove(findBy(restaurant.getId()));
	}
}
