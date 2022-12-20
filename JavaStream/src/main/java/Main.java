import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Person> people = getPeople();

//	imperative approach X

		List<Person> females = new ArrayList<>();

		for (Person person : people) {
			if (person.getGender().equals(Gender.FEMALE)) {
				females.add(person);
			}
		}
		females.forEach(System.out::println);

//	declarative approach V

//	filter
		System.out.println("----------------filter---------------");
		List<Person> filter = people.stream().filter(person -> person.getGender().equals(Gender.FEMALE))
				.collect(Collectors.toList());
		filter.forEach(System.out::println);

//	sort
		System.out.println("----------------sort---------------");
		List<Person> sort = people.stream()
				.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
				.collect(Collectors.toList());
		sort.forEach(System.out::println);

//	all match
		System.out.println("----------------all match---------------");
		boolean allMatch = people.stream().allMatch(person -> person.getAge() > 12);
		System.out.println(allMatch);

//	any match
		System.out.println("----------------any match---------------");
		boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 12);
		System.out.println(anyMatch);

//	none match
		System.out.println("----------------none match---------------");
		boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Hoang Kiet"));
		System.out.println(noneMatch);

//	max
		System.out.println("----------------max---------------");
		people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
//	min
		System.out.println("----------------min---------------");
		people.stream().min(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
//	group
		System.out.println("----------------group---------------");
		Map<Gender, List<Person>> groupByGender = people.stream().collect(Collectors.groupingBy(Person::getGender));

		groupByGender.forEach((gender, people1) -> {
			System.out.println(gender);
			people1.forEach(System.out::println);
			System.out.println();
		});
		System.out.println("-------------------------------");
		Optional<String> oldestFemaleAge = people.stream().filter(person -> person.getGender().equals(Gender.FEMALE))
				.max(Comparator.comparing(Person::getAge)).map(Person::getName);
		oldestFemaleAge.ifPresent(System.out::println);
	}

	private static List<Person> getPeople() {
		return List.of(new Person("Hoang Kiet", 22, Gender.MALE), new Person("Chu Van An", 10, Gender.MALE),
				new Person("Jamse Bond", 20, Gender.MALE), new Person("Alina Smith", 33, Gender.FEMALE),
				new Person("Alex Boz", 14, Gender.FEMALE), new Person("Anna Cook", 7, Gender.FEMALE),
				new Person("Donal Trump", 82, Gender.MALE));
	}
}
