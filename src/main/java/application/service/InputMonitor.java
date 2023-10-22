package application.service;

public class InputMonitor {
	public boolean isEmpty(String str) {
		if(str.length() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
}
