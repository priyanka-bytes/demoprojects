package com.bytesedge.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="illness_history")
public class IllnessHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = IllnessDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name="illness_details_id")
	private IllnessDetails illnessDetails;
	
	@OneToMany(mappedBy="illnessHistory", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<IllnessHistoryInvestigationDetails> illnessHistoryInvestigationDetails;
	
	@OneToOne
	@JoinColumn(name="illness_type_id")
	private Lookup illnessType;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="months")
	private String months;
	
	@Column(name="years")
	private String years;
	
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

	public Lookup getIllnessType() {
		return illnessType;
	}

	public void setIllnessType(Lookup illnessType) {
		this.illnessType = illnessType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
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

	public List<IllnessHistoryInvestigationDetails> getIllnessHistoryInvestigationDetails() {
		return illnessHistoryInvestigationDetails;
	}

	public void setIllnessHistoryInvestigationDetails(
			List<IllnessHistoryInvestigationDetails> illnessHistoryInvestigationDetails) {
		this.illnessHistoryInvestigationDetails = illnessHistoryInvestigationDetails;
	}

	@Override
	public String toString() {
		return "IllnessHistory [id=" + id + ", illnessDetails=" + illnessDetails
				+ ", illnessHistoryInvestigationDetails=" + illnessHistoryInvestigationDetails + ", illnessType="
				+ illnessType + ", comments=" + comments + ", months=" + months + ", years=" + years + ", isActive="
				+ isActive + ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated + ", createdById="
				+ createdById + ", lastUpdatedById=" + lastUpdatedById + "]";
	}

	
	
}
