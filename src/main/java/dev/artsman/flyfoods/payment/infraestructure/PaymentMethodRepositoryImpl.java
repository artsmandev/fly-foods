package dev.artsman.flyfoods.payment.infraestructure;

import dev.artsman.flyfoods.payment.domain.model.PaymentMethod;
import dev.artsman.flyfoods.payment.domain.repository.PaymentMethodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {
	@PersistenceContext
	private final EntityManager entityManager;

	@Override
	public List<PaymentMethod> findAll() {
		return entityManager.createQuery("from PaymentMethod", PaymentMethod.class).getResultList();
	}

	@Override
	public PaymentMethod findBy(Long id) {
		return entityManager.find(PaymentMethod.class, id);
	}

	@Override
	@Transactional
	public PaymentMethod save(PaymentMethod paymentMethod) {
		return entityManager.merge(paymentMethod);
	}

	@Override
	@Transactional
	public void remove(PaymentMethod paymentMethod) {
		entityManager.remove(findBy(paymentMethod.getId()));
	}
}
