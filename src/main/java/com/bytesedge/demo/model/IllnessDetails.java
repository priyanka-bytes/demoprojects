package com.bytesedge.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

@Entity
@Table(name="illness_details")
public class IllnessDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="patient_id")
	private User patient;
	
	@OneToMany(mappedBy="illnessDetails", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<IllnessDetailsComment> comments;
	
	@OneToMany(mappedBy="illnessDetails", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<IllnessHistory> history;
	
	@OneToMany(mappedBy="illnessDetails", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<SpiritualPracticeType> spiritualPracticeType;
	
	@OneToOne(mappedBy="illnessDetails", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private SpiritualPracticeDuration spiritualPracticeDuration;
	
	@Column(name="is_vegetarian")
	private Boolean isVegetarian;
	
	@Column(name="vegetarian_since_months")
	private Long vegetarianSinceMonths;	
	
	@Column(name="vegetarian_since_years")
	private Long  vegetarianSinceYears;
	
	
	@Column(name="anapansati_meditation_since_days")
	private Long  anapansatiMeditationSinceDays;
	
	@Column(name="anapansati_meditation_since_months")
	private Long anapansatiMeditationSinceMonths;
	
	@Column(name="anapansati_meditation_since_years")
	private Long anapansatiMeditationSinceYears;
	
	@OneToOne
	@JoinColumn(name="marital_status_id")
	private Lookup maritalStatus;
	
	@OneToOne
	@JoinColumn(name="family_type_id")
	private Lookup familyType;
	
	@OneToOne
	@JoinColumn(name="family_class_id")
	private Lookup familyClass;
	
	@OneToOne
	@JoinColumn(name="family_support_id")
	private Lookup familySupport;
	
	@Column(name="pulse")
	private Long pulse;
	
	@Column(name="blood_pressure")
	private Long bloodPressure;
	
	@Column(name="temparature")
	private BigDecimal temparature;
	
	@Column(name="respiratory_rate")
	private Long respiratoryRate;
	
	@Column(name="height")
	private BigDecimal height;
	
	@Column(name="weight")
	private BigDecimal weight;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Transient
	private Lookup stressType;
	
	@Transient 
	private Lookup treatmentType;
	
	@Transient
	private String stressComments;
	
	@Transient 
	private String treatmentComments;

	@Transient
	private String illnessHistoryJson;
	
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

	@Transient
	private String dummy;
	
	@Transient
	private String spiritualPracticeTypeStr;
	
	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public Boolean getIsVegetarian() {
		return isVegetarian;
	}

	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public Long getVegetarianSinceMonths() {
		return vegetarianSinceMonths;
	}

	public void setVegetarianSinceMonths(Long vegetarianSinceMonths) {
		this.vegetarianSinceMonths = vegetarianSinceMonths;
	}

	public Long getVegetarianSinceYears() {
		return vegetarianSinceYears;
	}

	public void setVegetarianSinceYears(Long vegetarianSinceYears) {
		this.vegetarianSinceYears = vegetarianSinceYears;
	}

	public Long getAnapansatiMeditationSinceDays() {
		return anapansatiMeditationSinceDays;
	}

	public void setAnapansatiMeditationSinceDays(Long anapansatiMeditationSinceDays) {
		this.anapansatiMeditationSinceDays = anapansatiMeditationSinceDays;
	}

	public Long getAnapansatiMeditationSinceMonths() {
		return anapansatiMeditationSinceMonths;
	}

	public void setAnapansatiMeditationSinceMonths(Long anapansatiMeditationSinceMonths) {
		this.anapansatiMeditationSinceMonths = anapansatiMeditationSinceMonths;
	}

	public Long getAnapansatiMeditationSinceYears() {
		return anapansatiMeditationSinceYears;
	}

	public void setAnapansatiMeditationSinceYears(Long anapansatiMeditationSinceYears) {
		this.anapansatiMeditationSinceYears = anapansatiMeditationSinceYears;
	}

	public Lookup getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Lookup maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Lookup getFamilyType() {
		return familyType;
	}

	public void setFamilyType(Lookup familyType) {
		this.familyType = familyType;
	}

	public Lookup getFamilyClass() {
		return familyClass;
	}

	public void setFamilyClass(Lookup familyClass) {
		this.familyClass = familyClass;
	}

	public Lookup getFamilySupport() {
		return familySupport;
	}

	public void setFamilySupport(Lookup familySupport) {
		this.familySupport = familySupport;
	}

	public Long getPulse() {
		return pulse;
	}

	public void setPulse(Long pulse) {
		this.pulse = pulse;
	}

	public Long getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(Long bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public BigDecimal getTemparature() {
		return temparature;
	}

	public void setTemparature(BigDecimal temparature) {
		this.temparature = temparature;
	}

	public Long getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Long respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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

	public List<IllnessDetailsComment> getComments() {
		return comments;
	}

	public void setComments(List<IllnessDetailsComment> comments) {
		this.comments = comments;
	}
	
	
	public String getStressComments() {
		return stressComments;
	}

	public void setStressComments(String stressComments) {
		this.stressComments = stressComments;
	}

	public String getTreatmentComments() {
		return treatmentComments;
	}

	public void setTreatmentComments(String treatmentComments) {
		this.treatmentComments = treatmentComments;
	}

	public Lookup getStressType() {
		return stressType;
	}

	public void setStressType(Lookup stressType) {
		this.stressType = stressType;
	}

	public Lookup getTreatmentType() {
		return treatmentType;
	}

	public void setTreatmentType(Lookup treatmentType) {
		this.treatmentType = treatmentType;
	}

	public List<SpiritualPracticeType> getSpiritualPracticeType() {
		return spiritualPracticeType;
	}

	public void setSpiritualPracticeType(List<SpiritualPracticeType> spiritualPracticeType) {
		this.spiritualPracticeType = spiritualPracticeType;
	}

	public SpiritualPracticeDuration getSpiritualPracticeDuration() {
		return spiritualPracticeDuration;
	}

	public void setSpiritualPracticeDuration(SpiritualPracticeDuration spiritualPracticeDuration) {
		this.spiritualPracticeDuration = spiritualPracticeDuration;
	}

	public String getSpiritualPracticeTypeStr() {
		return spiritualPracticeTypeStr;
	}

	public void setSpiritualPracticeTypeStr(String spiritualPracticeTypeStr) {
		this.spiritualPracticeTypeStr = spiritualPracticeTypeStr;
	}

	
	public String getIllnessHistoryJson() {
		return illnessHistoryJson;
	}

	public void setIllnessHistoryJson(String illnessHistoryJson) {
		this.illnessHistoryJson = illnessHistoryJson;
	}

	public List<IllnessHistory> getHistory() {
		return history;
	}

	public void setHistory(List<IllnessHistory> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "IllnessDetails [id=" + id + ", patient=" + patient + ", comments=" + comments + ", history=" + history
				+ ", spiritualPracticeType=" + spiritualPracticeType + ", spiritualPracticeDuration="
				+ spiritualPracticeDuration + ", isVegetarian=" + isVegetarian + ", vegetarianSinceMonths="
				+ vegetarianSinceMonths + ", vegetarianSinceYears=" + vegetarianSinceYears
				+ ", anapansatiMeditationSinceDays=" + anapansatiMeditationSinceDays
				+ ", anapansatiMeditationSinceMonths=" + anapansatiMeditationSinceMonths
				+ ", anapansatiMeditationSinceYears=" + anapansatiMeditationSinceYears + ", maritalStatus="
				+ maritalStatus + ", familyType=" + familyType + ", familyClass=" + familyClass + ", familySupport="
				+ familySupport + ", pulse=" + pulse + ", bloodPressure=" + bloodPressure + ", temparature="
				+ temparature + ", respiratoryRate=" + respiratoryRate + ", height=" + height + ", weight=" + weight
				+ ", isActive=" + isActive + ", stressType=" + stressType + ", treatmentType=" + treatmentType
				+ ", stressComments=" + stressComments + ", treatmentComments=" + treatmentComments
				+ ", illnessHistoryJson=" + illnessHistoryJson + ", dateCreated=" + dateCreated + ", lastUpdated="
				+ lastUpdated + ", createdById=" + createdById + ", lastUpdatedById=" + lastUpdatedById + ", dummy="
				+ dummy + ", spiritualPracticeTypeStr=" + spiritualPracticeTypeStr + "]";
	}

	
}
