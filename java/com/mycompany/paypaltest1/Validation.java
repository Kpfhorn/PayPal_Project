package com.mycompany.paypaltest1;


import java.util.regex.*;

public class Validation {

	public Validation() {

	}

	public boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean isValidSSN(String ssn) {
		String ssnRegex = "^[0-8][0-9]{2}-[0-9]{2}-[0-9]{4}$";

		Pattern pat = Pattern.compile(ssnRegex);
		if (ssn == null)
			return false;
		return pat.matcher(ssn).matches();
	}

	public boolean isValidPhone(String phone) {
		String phoneRegex = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$";
		Pattern pat = Pattern.compile(phoneRegex);
		if (phone == null)
			return false;
		return pat.matcher(phone).matches();
	}

	public boolean isValidBday(String bday) {
		String bdayRegex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
		Pattern pat = Pattern.compile(bdayRegex);
		if (bday == null)
			return false;
		return pat.matcher(bday).matches();
	}

	public boolean isValidLicNum(String ln) {
		String lnRegex = "^[0-9]{8}$";
		Pattern pat = Pattern.compile(lnRegex);
		if (ln == null)
			return false;
		return pat.matcher(ln).matches();
	}

}
