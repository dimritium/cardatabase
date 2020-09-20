package com.dimritium.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends CrudRepository<Car, Long> {
		List<Car> findByBrand(@Param("brand") String brand);
		List<Car> findByColor(@Param("color") String color);
		List<Car> findByYear(int year);
		
		List<Car> findByBrandAndModel(String brand, String model);
		List<Car> findByBrandOrColor(String brand, String color);
		
		List<Car> findByBrandOrderByYearAsc(String brand);
		
		@Query("Select c from Car c where c.brand like %?1")
		List<Car> findByBrandEndsWith(String brand);
}

