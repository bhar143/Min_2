package com.ashok.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ashok.entity.Customers;
import com.ashok.repo.CustomerRepo;

@Component
public class DataInserter implements ApplicationRunner{
	@Autowired
	private CustomerRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
         Customers cust = new Customers();
         cust.setName("Raju");
         cust.setPlanName("");
         cust.setPlanStatus("Approved");
         cust.setGender("Male");
         cust.setNum(3455322233l);
         cust.setSsn(687755567443l);
         
         Customers cust1 = new Customers();
         cust1.setName("Revi");
         cust1.setPlanName("CCAP");
         cust1.setPlanStatus("Denied");
         cust1.setGender("Male");
         cust1.setNum(3455322233l);
         cust1.setSsn(687755544443l);
         
         Customers cust2 = new Customers();
         cust2.setName("Nigam");
         cust2.setPlanName("CCAP");
         cust2.setPlanStatus("Denied");
         cust2.setGender("Male");
         cust2.setNum(9895322233l);
         cust2.setSsn(68775558888l);
         
         Customers cust3 = new Customers();
         cust3.setName("Vasu");
         cust3.setPlanName("");
         cust3.setPlanStatus("Approved");
         cust3.setGender("Male");
         cust3.setNum(3455111233l);
         cust3.setSsn(68775556663l);
         
         List<Customers> list = Arrays.asList(cust, cust1, cust2, cust3);
         repo.saveAll(list);
	}

}
