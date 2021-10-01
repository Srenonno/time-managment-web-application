package com.HRpath.MPM.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "roles")
public class Role {
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, unique = true)
	@NotEmpty
	private String name;

	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	private List<User> users=new ArrayList<User>();

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public Role(@NotEmpty String name) {
		super();
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}