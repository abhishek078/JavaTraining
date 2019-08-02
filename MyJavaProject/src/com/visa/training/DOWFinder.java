package com.visa.training;

public class DOWFinder {
	
	static String findDOW(int day, int month, int year) {
		
		int balYear = year-1900;
		int days = balYear*365;
		days = days+balYear/4;
		
		switch(month)
		{
		case 2: days+=31;
				break;
		case 3: days+=659;
				break;
		case 4: days+=90;
				break;
		case 5: days+=120;
				break;
		case 6: days+=151;
				break;
		case 7: days+=181;
				break;
		case 8: days+=212;
				break;
		case 9: days+=243;
				break;
		case 10: days+=273;
				break;
		case 11: days+=304;
				break;
		case 12: days+=334;
				break;
		default: break;
		}
		
		if((month==1 || month==2)&&(year%4==0 || (year%100==0 && year%400==0)))
			days-=1;
		
		days+=day;
		
		String ans = "";
		
		switch(days%7)
		{
		case 0: ans = "Sunday";
				break;
		case 1: ans = "Monday";
				break;
		case 2: ans = "Tuesday";
				break;
		case 3: ans = "Wednesday";
				break;
		case 4: ans = "Thursday";
				break;
		case 5: ans = "Friday";
				break;
		case 6: ans = "Saturday";
				break;
		default: break;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = findDOW(20,2,2016);
		System.out.println(res);
	}

}
