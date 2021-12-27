package com.bytesedge.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users") 
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@OneToOne
	@JoinColumn(name="gender_id")
	private Lookup gender;
	
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber = "";
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="user_name")
	private String userName = "";
	
	@Column(name="hash_code")
	private String hashCode = "";
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<LanguagesKnown> languagesKnown = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name="mother_tongue_type_id")
	private Lookup motherTongue;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private UserDisease disease ;
	
//	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private List<ticketDetails> ticketDetails = new ArrayList<ticketDetails>();
//	
//	public List<ticketDetails> getTicketDetails() {
//		return ticketDetails;
//	}
//
//	public void setTicketDetails(List<ticketDetails> ticketDetails) {
//		this.ticketDetails = ticketDetails;
//	}

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<UserAddress> addressess = new HashSet<>() ;
	
	@Transient
	private List<UserAddress> addressList = new ArrayList<UserAddress>();
//	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private List<UserAddress> addressList = new ArrayList<UserAddress>();
//	
	
	@Transient
	private String languages;
	
	@Transient
	private Set<String> languagesList;
	
	@Column(name="is_active")
	private boolean isActive;

	@Transient
	@Column(nullable = true)
	private LocalDateTime dateCreated;
	
	@Transient
	@Column(nullable = true)
	private LocalDateTime lastUpdated;
	
	@Transient
	private Integer createdById;
	
	@Transient
	private Integer lastUpdatedById;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Lookup getGender() {
		return gender;
	}

	public void setGender(Lookup gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public Set<LanguagesKnown> getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(Set<LanguagesKnown> languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	public Lookup getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(Lookup motherTongue) {
		this.motherTongue = motherTongue;
	}

	public UserDisease getDisease() {
		return disease;
	}

	public void setDisease(UserDisease disease) {
		this.disease = disease;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Integer createdById) {
		this.createdById = createdById;
	}

	public Integer getLastUpdatedById() {
		return lastUpdatedById;
	}

	public void setLastUpdatedById(Integer lastUpdatedById) {
		this.lastUpdatedById = lastUpdatedById;
	}
	
	

	public Set<String> getLanguagesList() {
		return languagesList;
	}

	public void setLanguagesList(Set<String> languagesList) {
		this.languagesList = languagesList;
	}

	public Set<UserAddress> getAddressess() {
		return addressess;
	}

	public void setAddressess(Set<UserAddress> addressess) {
		this.addressess = addressess;
	}
	
	public List<UserAddress> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<UserAddress> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", mobile=" + mobile + ", userName=" + userName + ", hashCode=" + hashCode
				+ ", languagesKnown=" + languagesKnown + ", motherTongue=" + motherTongue + ", disease=" + disease
				+ ", addressess=" + addressess + ", addressList=" + addressList + ", languages=" + languages
				+ ", languagesList=" + languagesList + ", isActive=" + isActive + ", dateCreated=" + dateCreated
				+ ", lastUpdated=" + lastUpdated + ", createdById=" + createdById + ", lastUpdatedById="
				+ lastUpdatedById + "]";
	}


	
}
