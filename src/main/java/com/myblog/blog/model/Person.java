package com.myblog.blog.model;

import org.springframework.stereotype.Component;

/**
 * ClassName:Person
 * Package:com.myblog.blog.model
 * Description:
 *
 * @Date:2020/12/13 22:28
 * @com.chuangmei
 */

@Component
public class Person {

	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	//move
	public void move() {
		System.out.println("人在走...");
	}

}
