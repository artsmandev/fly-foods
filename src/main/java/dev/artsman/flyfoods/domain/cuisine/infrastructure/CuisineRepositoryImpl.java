package dev.artsman.flyfoods.domain.cuisine.infrastructure;

import dev.artsman.flyfoods.domain.cuisine.Cuisine;
import dev.artsman.flyfoods.domain.cuisine.CuisineRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
class CuisineRepositoryImpl implements CuisineRepository {
	@PersistenceContext
	private final EntityManager entityManager;

	@Override
	public List<Cuisine> findAll() {
		return entityManager.createQuery("from Cuisine", Cuisine.class).getResultList();
	}

	@Override
	public Cuisine findBy(Long id) {
		return entityManager.find(Cuisine.class, id);
	}

	@Override
	@Transactional
	public Cuisine save(Cuisine cuisine) {
		return entityManager.merge(cuisine);
	}

	@Override
	@Transactional
	public void remove(Cuisine cuisine) {
		entityManager.remove(findBy(cuisine.getId()));
	}
}
