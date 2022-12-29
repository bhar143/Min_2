package com.ashok.service;


import java.awt.Color;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashok.entity.Customers;
import com.ashok.entity.SearchRequest;
import com.ashok.repo.CustomerRepo;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;



@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private CustomerRepo cust;

	@Override
	public List<String> getPlaneName() {
		return cust.getPlanName();
	}

	@Override
	public List<String> getPlaneStatuses() {
		return cust.getPlanStatues();
	}

	@Override
	public List<Customers> getCustomers(SearchRequest request) {
		Customers plan = new Customers();
		if(request.getPlanName()!= null && !request.getPlanName().equals("")) {
			plan.setPlanName(request.getPlanName());
		}
		if(request.getPlanStatus()!=null && !request.getPlanStatus().equals("")) {
			plan.setPlanStatus(request.getPlanStatus());
		}
		if(request.getGender()!=null && !request.getGender().equals("")) {
			plan.setGender(request.getGender());
		}
		Example<Customers> exam = Example.of(plan);
		List<Customers> records = cust.findAll(exam);
		return records;
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws Exception {
		List<Customers> records = cust.findAll();
		HSSFWorkbook book = new HSSFWorkbook();
		HSSFSheet sheet = book.createSheet("Customers Info");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("SSN");
		row.createCell(3).setCellValue("Gender");
		row.createCell(4).setCellValue("plan Name");
		row.createCell(5).setCellValue("plan Status");
		
		int dataRowIndex = 1;
		for(Customers record : records) {
			HSSFRow Row = sheet.createRow(dataRowIndex);
			Row.createCell(0).setCellValue(record.getId());
			Row.createCell(1).setCellValue(record.getName());
			Row.createCell(2).setCellValue(record.getSsn());
			Row.createCell(3).setCellValue(record.getGender());
			Row.createCell(4).setCellValue(record.getPlanName());
			Row.createCell(5).setCellValue(record.getPlanStatus());
			
			dataRowIndex++;
		}
		ServletOutputStream ops = response.getOutputStream();
		book.write(ops);
		book.close();
		ops.close();
	}
	
	
	public void exportPdf(HttpServletResponse response) throws Exception{
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font f = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		f.setSize(20);
		f.setColor(Color.WHITE);
		Paragraph p = new Paragraph("List Of Customers", f);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3, 3, 3, 3, 3 });
		table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		cell.setPhrase(new Phrase("ID", f));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Name", f));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("SSN", f));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Gender", f));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("PlaneName", f));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("PlanStatus", f));
		table.addCell(cell);
		
		List<Customers> records = cust.findAll();
		
		for(Customers record : records) {
			table.addCell(String.valueOf(record.getId()));
			table.addCell(record.getName());
			table.addCell(String.valueOf(record.getSsn()));
			table.addCell(record.getGender());
			table.addCell(record.getPlanName());
			table.addCell(record.getPlanStatus());
		}
		
		document.add(table);
		document.close();

}
}