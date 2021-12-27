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
@Table(name="illness_history_investigation_details")
public class IllnessHistoryInvestigationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = IllnessHistory.class, cascade = CascadeType.ALL)
	@JoinColumn(name="illness_history_id")
	private IllnessHistory illnessHistory;
	
	@OneToOne
	@JoinColumn(name="investigation_type_id")
	private Lookup investigationType;
	
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

	public IllnessHistory getIllnessHistory() {
		return illnessHistory;
	}

	public void setIllnessHistory(IllnessHistory illnessHistory) {
		this.illnessHistory = illnessHistory;
	}

	public Lookup getInvestigationType() {
		return investigationType;
	}

	public void setInvestigationType(Lookup investigationType) {
		this.investigationType = investigationType;
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

	@Override
	public String toString() {
		return "IllnessHistoryInvestigationDetails [id=" + id + ", illnessHistory=" + illnessHistory
				+ ", investigationType=" + investigationType + ", isActive=" + isActive + ", dateCreated=" + dateCreated
				+ ", lastUpdated=" + lastUpdated + ", createdById=" + createdById + ", lastUpdatedById="
				+ lastUpdatedById + "]";
	}
	
	
}
