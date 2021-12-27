package com.bytesedge.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name = "ticket_comments")
public class TicketComments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
//	@OneToOne
//	@JoinColumn(name = "ticket_id",referencedColumnName ="id")
//	private PatientTicketDetails ticketId;
	

     @Column(name = "ticket_id")
     private Long ticketId;
	
	public Long getTicketId() {
		return ticketId;
	}


	public void setTicketId(Long ticketId) {
		System.out.println(ticketId);
		this.ticketId = ticketId;
	}


	@Column(name = "user_id")
	private Long userId;
	
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


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


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


	@Column(name = "content")
	private String content;
	
	@Column(name="created_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date createdDate;
	
	
	@Column(name="created_user_id")
	private Long createdUserId;
	
	
	
}
