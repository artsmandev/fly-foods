package dev.artsman.flyfoods.domain.payment;

import java.util.List;

public interface PaymentMethodRepository {
	List<PaymentMethod> findAll();

	PaymentMethod findBy(Long id);

	PaymentMethod save(PaymentMethod paymentMethod);

	void remove(PaymentMethod paymentMethod);
}
