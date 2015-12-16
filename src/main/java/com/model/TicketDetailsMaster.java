/**
 * 
 */
package com.model;


import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.enums.StatusEnum;

/**
 * @author ashish.gupta
 *
 */
/**
 * @author ashish.gupta
 *
 */
@Entity
@Table(name="TICKET_DETAILS")
public class TicketDetailsMaster {


	private Integer id;

	private String name;

	private String description;

	private String filename;

	private byte[] content;

	private String contentType;

	private Date created;

	private String priority;

	private String status;

	private User userId;

	private String environment;

	private StatusEnum active;

	private String requestedBy; 

	/**
	 * 
	 */
	 public TicketDetailsMaster() {
		super();
	}



	/**
	 * @param name
	 * @param description
	 * @param filename
	 * @param content
	 * @param contentType
	 * @param created
	 * @param priority
	 * @param status
	 * @param doneBy
	 * @param environment
	 * @param active
	 * @param requestedBy
	 */
	 public TicketDetailsMaster(String name, String description,
			 String filename, byte[] content, String contentType,
			 Date created, String priority, String status, User userId,
			 String environment, StatusEnum active, String requestedBy) {
		 super();
		 this.name = name;
		 this.description = description;
		 this.filename = filename;
		 this.content = content;
		 this.contentType = contentType;
		 this.created = created;
		 this.priority = priority;
		 this.status = status;
		 this.userId = userId;
		 this.environment = environment;
		 this.active = active;
		 this.requestedBy = requestedBy;
	 }

	 @Id
	 @GeneratedValue
	 @Column(name="ID" , length = 40)
	 public Integer getId() {
		 return id;
	 }

	 /**
	  * @param id the id to set
	  */
	 public void setId(Integer id) {
		 this.id = id;
	 }

	 @Column(name="NAME" , length = 200)
	 public String getName() {
		 return name;
	 }

	 /**
	  * @param name the name to set
	  */
	 public void setName(String name) {
		 this.name = name;
	 }

	 @Column(name="DESCRIPTION" , length = 200)
	 public String getDescription() {
		 return description;
	 }

	 /**
	  * @param description the description to set
	  */
	 public void setDescription(String description) {
		 this.description = description;
	 }

	 @Column(name="FILENAME" , length = 200)
	 public String getFilename() {
		 return filename;
	 }

	 /**
	  * @param filename the filename to set
	  */
	 public void setFilename(String filename) {
		 this.filename = filename;
	 }

	 @Column(name="CONTENT" , length = 400)
	 @Lob
	 public byte[] getContent() {
		 return content;
	 }

	 /**
	  * @param content the content to set
	  */
	 public void setContent(byte[] content) {
		 this.content = content;
	 }

	 @Column(name="CONTENT_TYPE" , length = 200)
	 public String getContentType() {
		 return contentType;
	 }

	 /**
	  * @param contentType the contentType to set
	  */
	 public void setContentType(String contentType) {
		 this.contentType = contentType;
	 }

	 @Column(name="CREATED" , length = 200)
	 public Date getCreated() {
		 return created;
	 }

	 /**
	  * @param created the created to set
	  */
	 public void setCreated(Date created) {
		 this.created = created;
	 }

	 @Column(name="PRIORITY")
	 public String getPriority() {
		 return priority;
	 }

	 /**
	  * @param string the priority to set
	  */
	 public void setPriority(String string) {
		 this.priority = string;
	 }

	 @Column(name="STATUS" , length = 50)
	 public String getStatus() {
		 return status;
	 }

	 /**
	  * @param status the status to set
	  */
	 public void setStatus(String status) {
		 this.status = status;
	 }

	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name="USER_ID")
	 public User getUserId() {
		 return userId;
	 }

	 /**
	  * @param userId the userId to set
	  */
	 public void setUserId(User userId) {
		 this.userId = userId;
	 }


	 @Column(name="ENVIRONMENT" , length = 50)
	 public String getEnvironment() {
		 return environment;
	 }

	 /**
	  * @param environment the environment to set
	  */
	 public void setEnvironment(String environment) {
		 this.environment = environment;
	 }

	 @Column(name = "ACTIVE", length = 50)
	 public StatusEnum getActive() {
		 return active;
	 }

	 /**
	  * @param active the active to set
	  */
	 public void setActive(StatusEnum active) {
		 this.active = active;
	 }

	 @Column(name = "REQUESTER", length = 50)
	 public String getRequestedBy() {
		 return requestedBy;
	 }

	 /**
	  * @param requestedBy the requestedBy to set
	  */
	 public void setRequestedBy(String requestedBy) {
		 this.requestedBy = requestedBy;
	 }



	 /* (non-Javadoc)
	  * @see java.lang.Object#hashCode()
	  */
	 @Override
	 public int hashCode() {
		 final int prime = 31;
		 int result = 1;
		 result = prime * result
				 + ((active == null) ? 0 : active.hashCode());
		 result = prime * result + Arrays.hashCode(content);
		 result = prime * result
				 + ((contentType == null) ? 0 : contentType.hashCode());
		 result = prime * result
				 + ((created == null) ? 0 : created.hashCode());
		 result = prime * result
				 + ((description == null) ? 0 : description.hashCode());
		 result = prime * result
				 + ((environment == null) ? 0 : environment.hashCode());
		 result = prime * result
				 + ((filename == null) ? 0 : filename.hashCode());
		 result = prime * result + ((id == null) ? 0 : id.hashCode());
		 result = prime * result + ((name == null) ? 0 : name.hashCode());
		 result = prime * result
				 + ((priority == null) ? 0 : priority.hashCode());
		 result = prime * result
				 + ((requestedBy == null) ? 0 : requestedBy.hashCode());
		 result = prime * result
				 + ((status == null) ? 0 : status.hashCode());
		 result = prime * result
				 + ((userId == null) ? 0 : userId.hashCode());
		 return result;
	 }



	 /* (non-Javadoc)
	  * @see java.lang.Object#equals(java.lang.Object)
	  */
	 @Override
	 public boolean equals(Object obj) {
		 if (this == obj)
			 return true;
		 if (obj == null)
			 return false;
		 if (getClass() != obj.getClass())
			 return false;
		 TicketDetailsMaster other = (TicketDetailsMaster) obj;
		 if (active != other.active)
			 return false;
		 if (!Arrays.equals(content, other.content))
			 return false;
		 if (contentType == null) {
			 if (other.contentType != null)
				 return false;
		 } else if (!contentType.equals(other.contentType))
			 return false;
		 if (created == null) {
			 if (other.created != null)
				 return false;
		 } else if (!created.equals(other.created))
			 return false;
		 if (description == null) {
			 if (other.description != null)
				 return false;
		 } else if (!description.equals(other.description))
			 return false;
		 if (environment == null) {
			 if (other.environment != null)
				 return false;
		 } else if (!environment.equals(other.environment))
			 return false;
		 if (filename == null) {
			 if (other.filename != null)
				 return false;
		 } else if (!filename.equals(other.filename))
			 return false;
		 if (id == null) {
			 if (other.id != null)
				 return false;
		 } else if (!id.equals(other.id))
			 return false;
		 if (name == null) {
			 if (other.name != null)
				 return false;
		 } else if (!name.equals(other.name))
			 return false;
		 if (priority == null) {
			 if (other.priority != null)
				 return false;
		 } else if (!priority.equals(other.priority))
			 return false;
		 if (requestedBy == null) {
			 if (other.requestedBy != null)
				 return false;
		 } else if (!requestedBy.equals(other.requestedBy))
			 return false;
		 if (status == null) {
			 if (other.status != null)
				 return false;
		 } else if (!status.equals(other.status))
			 return false;
		 if (userId == null) {
			 if (other.userId != null)
				 return false;
		 } else if (!userId.equals(other.userId))
			 return false;
		 return true;
	 }

	 /* (non-Javadoc)
	  * @see java.lang.Object#toString()
	  */
	 @Override
	 public String toString() {
		 return "TicketDetailsMaster [id=" + id + ", name=" + name
				 + ", description=" + description + ", filename=" + filename
				 + ", content=" + Arrays.toString(content)
				 + ", contentType=" + contentType + ", created=" + created
				 + ", priority=" + priority + ", status=" + status
				 + ", userId=" + userId + ", environment=" + environment
				 + ", active=" + active + ", requestedBy=" + requestedBy
				 + "]";
	 }	
}
