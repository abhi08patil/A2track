/**
 * 
 */
package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ashish.gupta
 *
 */
@Entity
@Table(name="TICKET_USER_MAPPING")
public class TicketUserMapping {

    private Integer id;
	 
    private User user;;
    
    private Integer countOfTicket;

    
	/**
	 * @param user
	 * @param countOfTicket
	 */
	public TicketUserMapping(User user, Integer countOfTicket) {
		super();
		this.user = user;
		this.countOfTicket = countOfTicket;
	}

	/**
	 * 
	 */
	public TicketUserMapping() {
		super();
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "COUNT_OF_TICKET", length = 40)
	public Integer getCountOfTicket() {
		return countOfTicket;
	}

	/**
	 * @param countOfTicket the countOfTicket to set
	 */
	public void setCountOfTicket(Integer countOfTicket) {
		this.countOfTicket = countOfTicket;
	}
    
}
