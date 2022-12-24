package com.stream.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.stream.beans.Person;
import com.stream.mockdata.MockData;

public class GettingStarted {
//	don't do that
	@Test
	public void imperativeApproach() throws IOException {
		// TODO Auto-generated method stub
		// 1. Find people aged less or equal 18
		// 2. Then change implementation to find first 10 people
		List<Person> people = MockData.getPeople();
		List<Person> youngPeople = new ArrayList<Person>();
		int limit = 10, counter = 0;
		for (Person person : people) {
			if (person.getAge() <= 18) {
				youngPeople.add(person);
				counter++;
				if (counter == limit) {
					break;
				}
			}
		}
//		 youngPeople.forEach(System.out::println);
		// 12 rows
	}

	@Test
	public void declarativeApproachUsingStreams() throws IOException {
		// TODO Auto-generated method stub
		List<Person> people = MockData.getPeople();
		List<Person> youngPeople = people.stream().filter(p -> p.getAge() <= 18).limit(10).collect(Collectors.toList());
		youngPeople.forEach(System.out::println);
		// 3 rows
	}
}
