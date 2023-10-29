package dev.artsman.flyfoods.domain.state.infraestructure;

import dev.artsman.flyfoods.domain.state.State;
import dev.artsman.flyfoods.domain.state.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StateRepositoryImpl implements StateRepository {
	@PersistenceContext
	private final EntityManager entityManager;

	@Override
	public List<State> findAll() {
		return entityManager.createQuery("from State", State.class).getResultList();
	}

	@Override
	public State findById(Long id) {
		return entityManager.find(State.class, id);
	}

	@Override
	@Transactional
	public State create(State state) {
		return entityManager.merge(state);
	}

	@Override
	@Transactional
	public void remove(State state) {
		entityManager.remove(findById(state.getId()));
	}
}
