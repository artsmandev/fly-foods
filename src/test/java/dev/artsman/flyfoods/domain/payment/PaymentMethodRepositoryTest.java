package dev.artsman.flyfoods.domain.payment;

import dev.artsman.flyfoods.FlyFoodsApiApplication;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

class PaymentMethodRepositoryTest {
	static PaymentMethodRepository repository;

	@BeforeAll
	static void initAll() {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(FlyFoodsApiApplication.class).web(WebApplicationType.NONE).run();
		repository = context.getBean(PaymentMethodRepository.class);
	}

	@Test
	void shouldFindAll() {
		List<PaymentMethod> paymentMethods = repository.findAll();
		Assertions.assertEquals(2, paymentMethods.size());
	}

	@Test
	void shouldFindById() {
		PaymentMethod payPal = repository.findBy(1L);
		Assertions.assertNotNull(payPal);
	}

	@Test
	void shouldCreate() {
		PaymentMethod debit = new PaymentMethod(null, "Debit");
		debit = repository.save(debit);
		Assertions.assertEquals(3L, debit.getId());
	}

	@Test
	void shouldUpdate() {
		PaymentMethod payPal = repository.findBy(1L);
		Assertions.assertNotNull(payPal);

		PaymentMethod debit = new PaymentMethod(1L, "Debit");
		repository.save(debit);

		payPal = repository.findBy(1L);

		Assertions.assertEquals(1, payPal.getId());
		Assertions.assertEquals("Debit", payPal.getName());
	}

	@Test
	void remove() {
		PaymentMethod payPal = repository.findBy(1L);
		Assertions.assertNotNull(payPal);

		repository.remove(payPal);

		Assertions.assertNull(repository.findBy(1L));
	}
}
