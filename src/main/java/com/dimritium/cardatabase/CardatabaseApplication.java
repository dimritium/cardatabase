package com.dimritium.cardatabase;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dimritium.cardatabase.domain.Car;
import com.dimritium.cardatabase.domain.CarRepository;
import com.dimritium.cardatabase.domain.Owner;
import com.dimritium.cardatabase.domain.OwnerRepository;
import com.dimritium.cardatabase.domain.User;
import com.dimritium.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private UserRepository urepository;

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("App start");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John", "Johnson");
			orepository.save(owner1);

			List<Car> cars = new ArrayList<Car>() {
				private static final long serialVersionUID = -8025361302130074062L;

				{
					add(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 5900, owner1));
					add(new Car("Demo", "Must", "Black", "ADF-11e21", 2019, 5900, owner1));
					add(new Car("Ferrari", "Mest", "White", "ADF-1E1e21", 2012, 5900, owner1));

				}
			};
			carRepository.saveAll(cars);
			// username: user password: user
			urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			// username: admin password: admin
			urepository
					.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));

		};
	}

}
