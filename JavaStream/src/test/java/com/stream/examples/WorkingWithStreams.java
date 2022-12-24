package com.stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class WorkingWithStreams {

	@Test
	void stream() {
		List<String> names = List.of("Thao Huynh", "Hoang Kiet", "Qli");
		Stream<String> stream = names.stream();

		Stream<String> namesStream = Stream.of("Thao Huynh", "Hoang Kiet");

//		long count = stream.limit(2).map(null).sorted().dropWhile(null).count();

		String[] namesArray = { "Thao Huynh" };
		Arrays.stream(namesArray).forEach(System.out::println);

	}
}
