package com.stream.mockdata;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.stream.beans.Cars;
import com.stream.beans.Person;

public class MockData {

	public static List<Person> getPeople() throws IOException {
		InputStream inputStream = Resources.getResource("people.json").openStream();
		String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
		Type listType = new TypeToken<ArrayList<Person>>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 8477418149639141043L;
		}.getType();
		return new Gson().fromJson(json, listType);
	}

	public static List<Cars> getCars() throws IOException {
		InputStream inputStream = Resources.getResource("cars.json").openStream();
		String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
		Type listType = new TypeToken<ArrayList<Cars>>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 6373727264049444456L;
		}.getType();
		return new Gson().fromJson(json, listType);
	}
}
