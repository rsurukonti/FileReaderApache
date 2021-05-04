package com.log.analyze.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.swagger.client.ApiException;
import io.swagger.client.api.FilereadercontrollerApi;
import io.swagger.client.model.FileReaderBean;

public class WSTATDataService {
	
	public static void main(String args[]) {
	try{ 
		   FileInputStream fstream = new FileInputStream("I:\\apache.log");
		   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		   String strLine;
		   /* read log line by line */
		   while ((strLine = br.readLine()) != null)   {
			   
			Date dateTime =    findDate(strLine);
			String url=   findURL(strLine);
			   
			if(dateTime!=null && url!=null)
			SaveData(dateTime,url);
			  
		   //  System.out.println (strLine);
		   }
		   fstream.close();
		} catch (Exception e) {
		     System.err.println("Error: " + e.getMessage());
		}
	}

	private static void SaveData(Date dateTime, String url) throws ApiException {
		// TODO Auto-generated method stub
		FilereadercontrollerApi filereadercontrollerApi = new FilereadercontrollerApi();
		  FileReaderBean fileReaderBean = new FileReaderBean();
		  fileReaderBean.setUrl(url);
		  fileReaderBean.setDateTime(dateTime);
		  filereadercontrollerApi.postEmployeeUsingPOST(fileReaderBean);
	}

	private static String findURL(String strLine) {
		// TODO Auto-generated method stub
		 String regex = "\"([^\"]*)\"";
		   
		   Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		   Matcher matcher = pattern.matcher(strLine);
		   String res = "";
		   while (matcher.find())
		   {
		      // System.out.print("Start index: " + matcher.start());
		     //  System.out.print(" End index: " + matcher.end() + " ");
		       System.out.println(matcher.group().contains("https:")?matcher.group():"");
		       res = matcher.group().contains("https:")?matcher.group():"";
		       break;
		   }
		   
		   return res;
	}

	private static Date findDate(String strLine) throws ParseException {
		// TODO Auto-generated method stub
		String dateTime = strLine.substring(strLine.indexOf("[")+1, strLine.indexOf("]"));
		  
		   dateTime = dateTime.replace(" ", "");
		   System.out.println(dateTime);
		   SimpleDateFormat format1 = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ssZ",Locale.US);
		   SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.US);
		   Date date = format1.parse(dateTime);
		   String str = format2.format(date);
		   Date dt2 = format2.parse(str);
		   System.out.println(str);
		   
		   
		   return format2.parse(str);
		   
	}
}
