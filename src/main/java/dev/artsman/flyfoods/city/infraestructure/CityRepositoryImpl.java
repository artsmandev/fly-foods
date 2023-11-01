package dev.artsman.flyfoods.city.infraestructure;

import dev.artsman.flyfoods.city.domain.repository.CityRepository;
import dev.artsman.flyfoods.city.domain.model.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CityRepositoryImpl implements CityRepository {
	@PersistenceContext
	private final EntityManager entityManager;

	@Override
	public List<City> findAll() {
		return entityManager.createQuery("from City", City.class).getResultList();
	}

	@Override
	public City findById(Long id) {
		return entityManager.find(City.class, id);
	}

	@Override
	@Transactional
	public City create(City city) {
		return entityManager.merge(city);
	}

	@Override
	@Transactional
	public void remove(City city) {
		entityManager.remove(findById(city.getId()));
	}
}
