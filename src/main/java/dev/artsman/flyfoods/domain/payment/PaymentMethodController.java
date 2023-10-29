package dev.artsman.flyfoods.domain.payment;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
class PaymentMethodController {
	private final PaymentMethodRepository repository;

	@GetMapping
	List<PaymentMethod> findAll() {
		return repository.findAll();
	}
}
