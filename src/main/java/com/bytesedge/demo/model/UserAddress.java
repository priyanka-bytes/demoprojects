package com.bytesedge.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_addresses")
public class UserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name="contact_id")
	private User user; 
	
	@OneToOne
	@JoinColumn(name="address_type_id")
	private Lookup addressType;
	
	@Column(name="flat_plot_no")
	private String flatPlotNo;
	
	@Column(name="building_name")
	private String buildingName;
	
	@Column(name="street_name")
	private String streetName;
	
	@Column(name="area")
	private String area;
	
	@OneToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToOne
	@JoinColumn(name="state_id")
	private State state;
	
	@OneToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	@Column(name="zip_code")
	private String zipCode;

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

	public Lookup getAddressType() {
		return addressType;
	}

	public void setAddressType(Lookup addressType) {
		this.addressType = addressType;
	}

	public String getFlatPlotNo() {
		return flatPlotNo;
	}

	public void setFlatPlotNo(String flatPlotNo) {
		this.flatPlotNo = flatPlotNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", addressType=" + addressType +", flatPlotNo="
				+ flatPlotNo + ", buildingName=" + buildingName + ", streetName=" + streetName + ", area=" + area
				 + ", zipCode=" + zipCode + "]";
	}

	
}
