package com.v1RestApi.RestApi2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi2Controller {

	List<Person> data;

	public RestApi2Controller() {
		data = new ArrayList<>();
//		//first way of adding a person
//		Person p = new Person(1, "Sam", "B");
//		data.add(p);

		// second way of adding a person
		data.add(new Person(1, "Chester", "G"));
		data.add(new Person(2, "Sam", "B"));
		data.add(new Person(3, "Claudia", "S"));
		data.add(new Person(4, "Pawan", "M"));
		data.add(new Person(5, "John", "S"));
	}

	@GetMapping("/users")
	public List<Person> getAllUsers() {
		return data;
	}

	@GetMapping("/users/{id}")
	public Person getUser(@PathVariable(value = "id") Integer id) {
		for (Person p : data) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	@PostMapping("/users")
	public String addNewUser(@RequestBody Person newPerson) {
		//System.out.println(newPerson);
		for (Person p : data) {
			if (p.getId() == newPerson.getId()) {
		
			}
		}
		data.add(newPerson);
		return "User added successfully";
	}

	@PutMapping("/users")
	public String updateUser(@RequestBody Person newPerson) {
		//System.out.println(newPerson);
		for (Person p : data) {
			if (p.getId() == newPerson.getId()) {
				p.setfName(newPerson.getfName());
				p.setlName(newPerson.getlName());
				return "Updated name successfully";
			}

		}
		return "Person not found";
	}
	
	@DeleteMapping("/users")
	public String deleteUser(@RequestParam(value = "id") Integer id) {
		Iterator<Person> iter = data.iterator();
		while (iter.hasNext()) {
			Person tmp = iter.next();
			if (tmp.getId() == id) {
				iter.remove();
				return "User removed";
			}
		}
		
		return "User not found";
	}
}
