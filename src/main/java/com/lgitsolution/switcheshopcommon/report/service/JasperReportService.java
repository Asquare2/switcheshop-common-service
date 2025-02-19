package com.lgitsolution.switcheshopcommon.report.service;

import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class JasperReportService {
	/**
	   * 
	   * @param templateName
	   * @param parameters
	   * @param dataSource
	   * @return
	   */
	  public JasperPrint fillReport(String templateName, Map<String, Object> parameters,
	          JRBeanCollectionDataSource dataSource) {
	    JasperPrint jasperPrint = null;
	    try {
	    	InputStream companyDetailsStream = getClass().getClassLoader().getResourceAsStream("report_template/" + templateName + "/CompanyDetails.jasper");
	    	JasperReport companyDetailsSubReport = (JasperReport) JRLoader.loadObject(companyDetailsStream);

	    	InputStream addressStream = getClass().getClassLoader().getResourceAsStream("report_template/" + templateName + "/Address.jasper");
	    	JasperReport addressSubReport = (JasperReport) JRLoader.loadObject(addressStream);

	    	InputStream invoiceMainStream = getClass().getClassLoader().getResourceAsStream("report_template/" + templateName + "/InvoiceMainTable.jasper");
	    	JasperReport invoiceMainSubReport = (JasperReport) JRLoader.loadObject(invoiceMainStream);
	    	
	    	InputStream invoicetableStream = getClass().getClassLoader().getResourceAsStream("report_template/" + templateName + "/InvoiceTable1.jasper");
	    	JasperReport invoiceTableSubReport = (JasperReport) JRLoader.loadObject(invoicetableStream);
	    	InputStream descriptionStream = getClass().getClassLoader().getResourceAsStream("report_template/" + templateName + "/Description.jasper");
	    	JasperReport descriptionReport = (JasperReport) JRLoader.loadObject(descriptionStream);
	    	
	    	parameters.put("SUBREPORT_COMPANY_DETAILS", companyDetailsSubReport);
	    	parameters.put("SUBREPORT_ADDRESS_DETAILS", addressSubReport);
	    	parameters.put("SUBREPORT_INVOICE_MAIN_DETAILS", invoiceMainSubReport);
	    	parameters.put("SUBREPORT_INVOICE1_DETAILS", invoiceTableSubReport);
	    	parameters.put("SUBREPORT_DESCRIPTION_DETAILS", descriptionReport);

	      jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream(
	              "report_template/" + templateName + "/MasterTemplate.jasper"), parameters,
	              dataSource);
	    } catch (JRException ex) {
	    	ex.printStackTrace();
	    }
	    return jasperPrint;
}
}
