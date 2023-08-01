package dev.artsman.flyfoods.domain.kitchen;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class Kitchen {
	@Id
	@EqualsAndHashCode.Include
	private Long id;
	private String name;
}
