package dev.artsman.flyfoods.domain.kitchen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "\"KITCHEN\"")
@Entity
@NoArgsConstructor
@EqualsAndHashCode
class Kitchen {
	@Id
	@Column(name = "\"ID\"")
	private Long id;

	@Column(name = "\"NAME\"")
	@EqualsAndHashCode.Exclude
	private String name;
}
