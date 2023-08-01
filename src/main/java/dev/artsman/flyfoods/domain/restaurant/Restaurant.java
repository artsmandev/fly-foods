package dev.artsman.flyfoods.domain.restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class Restaurant {
	@Id
	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	private BigDecimal deliveryFee;
}
