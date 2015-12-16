/**
 * 
 */
package com.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author ashish.gupta
 *
 */
public class StringUtils {

	public static String splitComma(String stringValue) {
		if(stringValue==null)
			return null;
		else{
			String temp[] = stringValue.split(",");
			String firstPart = temp[0];
			return firstPart.trim();
		}
	}

	/**
	 * This method check if inputed string is empty and blank
	 * @author vipul.khatke
	 * @param stringValue
	 * @return
	 */
	public static boolean emptyAndNullCheckString(String stringValue){
		boolean emptyAndNullCheck=false;

		if(stringValue!=null && !stringValue.trim().equals("")){
			emptyAndNullCheck=true; 
		}
		return emptyAndNullCheck;
	}

	public static String trimmedString(String stringValue) {
		if(stringValue==null)
			return null;
		else
			return stringValue.trim();
	}

	/**
	 * This method get value from the properties file
	 * @author ashish.gupta
	 * @param String key
	 * @return
	 */
	public static String getValues(String key){
		ResourceBundle res_Bundle = ResourceBundle.getBundle("ApplicationResources");

		if(res_Bundle != null){
			return res_Bundle.getString(key);
		}
		return null;
	}


	/**
	 * @param password
	 * @return
	 */
	public static String getHashPaswordValues(String password){

		if(password != null){
			String generatedPassword = null;
			try {
				// Create MessageDigest instance for MD5
				MessageDigest md = MessageDigest.getInstance("MD5");
				//Add password bytes to digest
				md.update(password.getBytes());
				//Get the hash's bytes 
				byte[] bytes = md.digest();
				//This bytes[] has bytes in decimal format;
				//Convert it to hexadecimal format
				StringBuilder sb = new StringBuilder();
				for(int i=0; i< bytes.length ;i++)
				{
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}
				//Get complete hashed password in hex format
				generatedPassword = sb.toString();
			} 
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			}

			return generatedPassword;
		}
		return null;
	}

	/**
	 * This method returns value from bundle along with values inserted
	 * @param key
	 * @param params
	 * @return
	 */
	public static String getString(String key, Object... params  ) {
		ResourceBundle res_Bundle = ResourceBundle.getBundle("ApplicationResources");
		try {
			return MessageFormat.format(res_Bundle.getString(key), params);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}


	/**
	 * @return
	 */
	public static String getDateFormat() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, 0); //anything 0 - 23
		java.util.Date d1 = calendar.getTime();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(Constants.DATE_FORMAT); 
		String dateOfBirth = DATE_FORMAT.format(d1);
		return dateOfBirth;
	}

}
