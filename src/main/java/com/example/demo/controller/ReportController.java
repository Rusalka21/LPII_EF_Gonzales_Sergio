package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Libro;
import com.example.demo.service.LibroService;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private LibroService libroService;	
	
	@GetMapping("/report")
	public void report(HttpServletResponse response) throws JRException, IOException {
		
		// 1. Acceder al reporte
		
		InputStream jasperStream = this.getClass().getResourceAsStream("/reports/LPII_RF_Gonzales_Sergio.jasper");
		
		// 2. Preparar los datos		
				
		Map<String, Object> params = new HashMap<>();
		params.put("usuario", "Sergio Gonzales");
		
		// Cálculo de los seis meses
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -6);
		
		Date haceSeisMeses = new Date(calendar.getTimeInMillis());
		
		
		List<Libro> listLibros = libroService.getLibrosByFechaRegistroGreaterThanEqual(haceSeisMeses);
				
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listLibros);
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		
		// 3. Configuración de reporte
		
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "filename=reporte_ef.pdf");
		
		// 4. Exportar reporte
		final OutputStream outputStream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);			
		
	}

}
