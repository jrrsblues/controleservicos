package com.controleservicos.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class AcionamentoService {
   
	private Date dataDeInscricao;
	
	public Date retornadataatual() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR_OF_DAY, -2);
		dataDeInscricao = c.getTime(); 
		return dataDeInscricao ;
	}
	
	public Date retornadataatual(Date datado) {
		Calendar cal = Calendar. getInstance();
		cal.setTime(datado);
		cal.add(Calendar.HOUR_OF_DAY, -2);
		dataDeInscricao = cal.getTime();
		return dataDeInscricao ;
	}
	
	public Date retornadataatualretorno(Date datado) {
		Calendar cal = Calendar. getInstance();
		cal.setTime(datado);
		cal.add(Calendar.HOUR_OF_DAY, 2);
		dataDeInscricao = cal.getTime();
		return dataDeInscricao ;
	}
	
}
