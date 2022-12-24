package com.stream.beans;

public class PersonDTO {
	private Integer id;
	private String name;
	private Integer age;

	public PersonDTO(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public static PersonDTO map(Person person) {
		return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
