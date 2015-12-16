/**
 * 
 */
package com.common;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.TicketDetailsMaster;


/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author ashish.gupta
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	/* (non-Javadoc)
	 * @see com.common.AbstractITextPdfView#buildPdfDocument(java.util.Map, com.itextpdf.text.Document, com.itextpdf.text.pdf.PdfWriter, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		// get data model which is passed by the Spring container
		List<TicketDetailsMaster> ticketDetailsMastersList = (List<TicketDetailsMaster>) model.get("ticketDetailsMasters");

		doc.add(new Paragraph("List of the Opened tickets:"));

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {1.5f,3.0f, 3.0f, 2.0f, 3.0f,3.0f,3.0f});
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(BaseColor.WHITE);
		font.setSize(13);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.GRAY);
		cell.setPadding(7);

		// write table header
		cell.setPhrase(new Phrase("S.No", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Environment", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Status", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Assigned To", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Created Date", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Attached FileName", font));
		table.addCell(cell);

		
		// write table row data
		for (TicketDetailsMaster ticketDetailsMaster : ticketDetailsMastersList) {
			table.addCell(String.valueOf(ticketDetailsMaster.getId()));
			table.addCell(ticketDetailsMaster.getName());
			table.addCell(ticketDetailsMaster.getEnvironment());
			table.addCell(ticketDetailsMaster.getStatus());
			table.addCell(ticketDetailsMaster.getUserId().getName());
			table.addCell(ticketDetailsMaster.getCreated().toGMTString());
			table.addCell(ticketDetailsMaster.getFilename());
		}
		doc.add(table);
	}
}
