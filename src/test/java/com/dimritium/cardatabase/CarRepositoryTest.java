package com.dimritium.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.dimritium.cardatabase.domain.Car;
import com.dimritium.cardatabase.domain.CarRepository;

@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CarRepository repository;
	
	@Test
	public void saveCar() {
		Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
		entityManager.persistAndFlush(car);
		assertThat(car.getId()).isNotNull();
	}
	
	@Test
	public void deleteCar() {
		entityManager.persistAndFlush(new Car("Tesla", "Model S", "Black", "ABC-12D34", 2017, 86000));
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}
}
