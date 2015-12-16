/**
 * 
 */
package com.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.enums.StatusEnum;
import com.model.User;

/**
 * @author ashish.gupta
 *
 */
/**
 * @author ashish.gupta
 *
 */
public class ReportDTO {

	private Integer id;
     
    private String name;
    
    private String description;
    
    private MultipartFile file;
    
    private String priority;
    
    private Date date;
    
    private String environment;
    
    private String status;
    
    private String doneBy;
    
    private StatusEnum active;
    
    private String requestedBy; 
    
    private User userId; 
    
    private Integer countOfTickets; 
    
    private StatusEnum statusEdit;
    

    
    
	/**
	 * @param name
	 * @param description
	 * @param file
	 * @param priority
	 * @param date
	 * @param environment
	 * @param status
	 * @param doneBy
	 * @param active
	 * @param requestedBy
	 */
	public ReportDTO(String name, String description,
			MultipartFile file, String priority, Date date, String environment,
			String status, String doneBy,StatusEnum active,String requestedBy ) {
		super();
		this.name = name;
		this.description = description;
		this.file = file;
		this.priority = priority;
		this.date = date;
		this.environment = environment;
		this.status = status;
		this.doneBy = doneBy;
		this.active = active;
		this.requestedBy = requestedBy;
	}

	public ReportDTO() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the doneBy
	 */
	public String getDoneBy() {
		return doneBy;
	}

	/**
	 * @param doneBy the doneBy to set
	 */
	public void setDoneBy(String doneBy) {
		this.doneBy = doneBy;
	}

	/**
	 * @return the active
	 */
	public StatusEnum getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(StatusEnum active) {
		this.active = active;
	}

	/**
	 * @return the requestedBy
	 */
	public String getRequestedBy() {
		return requestedBy;
	}

	/**
	 * @param requestedBy the requestedBy to set
	 */
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	/**
	 * @return the userId
	 */
	public User getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}

	/**
	 * @return the countOfTickets
	 */
	public Integer getCountOfTickets() {
		return countOfTickets;
	}

	/**
	 * @param countOfTickets the countOfTickets to set
	 */
	public void setCountOfTickets(Integer countOfTickets) {
		this.countOfTickets = countOfTickets;
	}

	/**
	 * @return the statusEdit
	 */
	public StatusEnum getStatusEdit() {
		return statusEdit;
	}

	/**
	 * @param statusEdit the statusEdit to set
	 */
	public void setStatusEdit(StatusEnum statusEdit) {
		this.statusEdit = statusEdit;
	}

}
