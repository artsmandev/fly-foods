package dev.artsman.flyfoods.payment.domain.repository;

import dev.artsman.flyfoods.payment.domain.model.PaymentMethod;
import java.util.List;

public interface PaymentMethodRepository {
	List<PaymentMethod> findAll();

	PaymentMethod findBy(Long id);

	PaymentMethod save(PaymentMethod paymentMethod);

	void remove(PaymentMethod paymentMethod);
}
