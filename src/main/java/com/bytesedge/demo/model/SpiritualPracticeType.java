package com.bytesedge.demo.model;

import java.time.LocalDateTime;

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
import javax.persistence.Transient;

@Entity
@Table(name="spiritual_practice_types")
public class SpiritualPracticeType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne(targetEntity = IllnessDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name="illness_details_id")
	private IllnessDetails illnessDetails;
	
	@OneToOne
	@JoinColumn(name="practice_type_id")
	private Lookup practiceType;
	
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

	public IllnessDetails getIllnessDetails() {
		return illnessDetails;
	}

	public void setIllnessDetails(IllnessDetails illnessDetails) {
		this.illnessDetails = illnessDetails;
	}

	public Lookup getPracticeType() {
		return practiceType;
	}

	public void setPracticeType(Lookup practiceType) {
		this.practiceType = practiceType;
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
	
	
}
