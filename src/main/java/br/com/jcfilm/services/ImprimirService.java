package br.com.jcfilm.services;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class ImprimirService {

	private JasperReport jReport;
	private JRDataSource jrData;
		
	public void ImpressaoDeRelatorio(String relatorio) {
		try {
			
			InputStream employeeReportStream
			  = getClass().getResourceAsStream("/GarantiaCliente.jrxml");
			//jReport = JasperCompileManager.compileReport("/OrcadoRealizado.jrxml");
			jrData = new JREmptyDataSource();
			jReport = JasperCompileManager.compileReport(employeeReportStream);			
			Map<String,Object> parametros = new HashMap<>();			
			JasperPrint arquivo = JasperFillManager.fillReport(jReport, parametros, jrData);			
			JasperPrintManager.printReport(arquivo, true);
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
