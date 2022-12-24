package com.stream.examples;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.stream.beans.Cars;
import com.stream.beans.Person;
import com.stream.beans.PersonDTO;
import com.stream.mockdata.MockData;

public class TransformationsMapAndReduce {

	@Test
	void yourFirstTransformationWithMap() throws Exception {
		List<Person> people = MockData.getPeople();

//		Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(),
//				person.getFirstName(), person.getAge());
//		Function<Person, PersonDTO> mapper = PersonDTO::map;

		List<PersonDTO> dtos = people.stream().filter(person -> person.getAge() > 22).map(PersonDTO::map)
				.collect(Collectors.toList());

		// check both matches
//		assertThat(people.size()).isEqualTo(dtos.size()); actual people 1000 - dtos 762
//		System.out.println(dtos.size());
//		dtos.forEach(System.out::println);
	}

	@Test
	void mapToDoubleAndFindAverageCarPrice() throws Exception {
		List<Cars> cars = MockData.getCars();
		double average = cars.stream().mapToDouble(Cars::getPrice).average().orElse(0);
		System.out.println(average);
	}

	@Test
	public void reduce() {
		int[] integers = { 1, 2, 3, 4, 99, 100, 121, 1302, 199 };
		int sum = Arrays.stream(integers).reduce(0, Integer::sum);
		int sub = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
		System.out.println(sum);
		System.out.println(sub);
	}
}
