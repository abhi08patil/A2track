/**
 * 
 */
package com.service;


import java.util.List;

import com.dto.ReportDTO;
import com.model.TicketUserMapping;

/**
 * @author ashish.gupta
 *
 */
public interface TicketUserMappingService {

	public void saveCountOfTickets(ReportDTO reportDTO) throws Exception;

	//public List<TicketUserMapping> getUserAssignedTicketCount()throws Exception;


}
