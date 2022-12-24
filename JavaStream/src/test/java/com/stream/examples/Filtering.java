package com.stream.examples;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.stream.beans.Cars;
import com.stream.mockdata.MockData;

public class Filtering {
	@Test
	void filter() throws IOException {
		List<Cars> cars = MockData.getCars();

		Predicate<Cars> carPredicate = car -> car.getPrice() < 20_000.00;
		Predicate<Cars> yellow = car -> car.getColor().equals("Yellow");

		List<Cars> carsLessThan20k = cars.stream().filter(carPredicate).filter(yellow).collect(Collectors.toList());
		carsLessThan20k.forEach(System.out::println);
	}

	@Test
	void dropWhile() {
		// TODO Auto-generated method stub
		Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
	}

	@Test
	void takeWhile() {
		Stream.of(2, 4, 6, 8, 9, 10, 12);
	}
}
