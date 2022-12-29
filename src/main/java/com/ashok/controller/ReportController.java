package com.ashok.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.entity.Customers;
import com.ashok.entity.SearchRequest;
import com.ashok.service.ReportService;


@RestController
public class ReportController {
	@Autowired
	private ReportService service;
	
	@GetMapping("/plannames")
	public ResponseEntity<List<String>> getPlanName(){
		List<String> planName = service.getPlaneName();
		return new ResponseEntity<>(planName, HttpStatus.OK);
	}

	@GetMapping("/planstatuses")
	public ResponseEntity<List<String>> getPlanStatues(){
		List<String> planStatues = service.getPlaneStatuses();
		return new ResponseEntity<>(planStatues, HttpStatus.OK);
	}
	@PostMapping("/search")
	public ResponseEntity<List<Customers>> search(@RequestBody SearchRequest request){
		List<Customers> customer = service.getCustomers(request);
		return new ResponseEntity<>(customer,HttpStatus.OK);
		
	}
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		
		String key = "Content-Disposition";
		String value = "attachment;file=citizens.xmls";
		
		response.setHeader(key, value);
		service.exportExcel(response);
		response.flushBuffer();
	}
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		
		String key = "Content-Dispoition";
		String value = "attachment;plans.pdf";
		
		response.setHeader(key, value);
		service.exportPdf(response);
		response.flushBuffer();
		}
}
