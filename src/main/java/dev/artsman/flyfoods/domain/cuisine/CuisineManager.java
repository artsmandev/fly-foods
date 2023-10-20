package dev.artsman.flyfoods.domain.cuisine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class CuisineManager {
	@PersistenceContext
	private final EntityManager entityManager;

	public Set<Cuisine> findAll() {
		List<Cuisine> cuisines = entityManager.createQuery("from Cuisine", Cuisine.class)
																					.getResultList();
		return new HashSet<>(cuisines);
	}

	@Transactional
	public Cuisine create(Cuisine cuisine) {
		return entityManager.merge(cuisine);
	}

	public Cuisine findBy(Long id) {
		return entityManager.find(Cuisine.class, id);
	}
}