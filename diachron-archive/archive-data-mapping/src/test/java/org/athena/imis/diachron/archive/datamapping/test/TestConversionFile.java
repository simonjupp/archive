package org.athena.imis.diachron.archive.datamapping.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.athena.imis.diachron.archive.datamapping.MultidimensionalConverter;
import org.athena.imis.diachron.archive.datamapping.OntologyConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestConversionFile {

	private static final Logger logger = LoggerFactory.getLogger(TestConversionFile.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//String dir = "C:/Users/Marios/Documents/Projects/DIACHRON/EBI/v6/efo-last-15-owl/toConvert/";
		String dir = "C:/Users/Marios/Documents/Projects/DIACHRON/Datamarket/real datamarket/to test/";
		File[] files = new File(dir).listFiles();
		for(File file : files){
			
			System.out.println("Converting file " + file.getName());
			File inputFile = new File(dir+file.getName());
			FileInputStream fis = null;
			File outputFile = new File(dir+"_diachron_"+file.getName()+".rdf");
			
			try {
				fis = new FileInputStream(inputFile);
				FileOutputStream fos = new FileOutputStream(outputFile);
				//OntologyConverter converter = new OntologyConverter();
				MultidimensionalConverter converter = new MultidimensionalConverter();
				converter.convert(fis, fos, file.getName().substring(file.getName().lastIndexOf(".")+1));
				//converter.convert(fis, fos);
				fis.close();
				fos.close();
	 
			} catch (IOException e) {
				logger.error(e.getMessage(), e);			
			}
		}
		
		
		

	}
	
	
}