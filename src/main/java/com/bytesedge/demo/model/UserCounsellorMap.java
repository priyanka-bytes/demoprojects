package com.bytesedge.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;


@Entity
@Table(name = "user_counsellor_mappings")
public class UserCounsellorMap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
//	@OneToOne
//	@JoinColumn(name = "ticket_id",referencedColumnName ="id")
//	private PatientTicketDetails ticketId;
	

     @Column(name = "user_Id")
     private Long userId;
	
	

	@Column(name = "counsellor_Id")
	private Long counsellorId;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


//	public PatientTicketDetails getTicketId() {
//		return ticketId;
//	}
//
//
//	public void setTicketId(PatientTicketDetails ticketId) {
//		this.ticketId = ticketId;
//	}


	


	


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Long getCreatedUserId() {
		return createdUserId;
	}


	public void setCreatedUserId(Long createdUserId) {
		this.createdUserId = createdUserId;
	}



	
	@Column(name="created_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date createdDate;
	
	
	@Column(name="created_user_id")
	private Long createdUserId;
	
	@Column(name="updated_user_id")
	private Long updatedUserId;

	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getCounsellorId() {
		return counsellorId;
	}


	public void setCounsellorId(Long counsellorId) {
		this.counsellorId = counsellorId;
	}


	public Long getUpdatedUserId() {
		return updatedUserId;
	}


	public void setUpdatedUserId(Long updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

}
