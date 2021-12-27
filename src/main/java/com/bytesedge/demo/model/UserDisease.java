package com.bytesedge.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_diseases")
public class UserDisease {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="disease_type_id")
	private Lookup disease;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Lookup getDisease() {
		return disease;
	}

	public void setDisease(Lookup disease) {
		this.disease = disease;
	}

	/*@Override
	public String toString() {
		return "UserDisease [id=" + id + ", user=" + user + ", disease=" + disease + "]";
	}*/



	
}
