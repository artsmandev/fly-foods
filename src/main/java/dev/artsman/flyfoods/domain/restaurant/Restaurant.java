package dev.artsman.flyfoods.domain.restaurant;

import dev.artsman.flyfoods.domain.cuisine.Cuisine;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	private BigDecimal deliveryFee;
	@ManyToOne
	private Cuisine cuisine;
}
