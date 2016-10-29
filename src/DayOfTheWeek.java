import java.util.Scanner;

public class DayOfTheWeek {
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;

	public static void main(String[] args) {
		try 
		{
			Scanner inputScanner = new Scanner(System.in);

			System.out.print("Please enter the day as an integer: ");		
			int day = inputScanner.nextInt();

			System.out.print("Please enter the month as an integer: ");
			int month = inputScanner.nextInt();
	
			System.out.print("Please enter the year as an integer: ");
			int year = inputScanner.nextInt();
		
			if (validDate(day,month,year))
			{
				String datePostfix = numberEnding(day);
				String theMonth = monthName(month);
				String theDay = dayOfTheWeek(day,month,year);
			
				System.out.println(theDay + ", " + day + datePostfix + " " + theMonth + " " + year);
			}
			else
			{
				System.out.println(day + "/" + month + "/" + year + " is not a valid date.");
			}
		}
		catch (NullPointerException exception)
		{
		}
		
		catch (java.util.NoSuchElementException exception)
		{
			System.out.print("No number entered.");
		}
	}
	
	public static boolean validDate(int day, int month, int year) {
		
		if (year >= 0)
		{
			if (month >= 1 && month <= NUMBER_OF_MONTHS)
			{
				int noOfDays = daysInMonth(year, month);
				if (day >= 1 && day <= noOfDays)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static int daysInMonth(int year, int month) {
		int days_in_month = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			days_in_month = isLeapYear( year ) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
				                                       DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days_in_month = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			days_in_month = DAYS_IN_MOST_MONTHS;
			break;
		}
		return days_in_month;
	}

	public static boolean isLeapYear( int year )
	{
		return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
	}
	
	public static String numberEnding(int day) {
		String datePostfix;
		
		if (((day%100)/10) == 1)
		{
			datePostfix = "th";
		}
		else
		{
			switch (day%10)
			{
			case 1:
				datePostfix = "st";
				break;
			case 2:
				datePostfix = "nd";
				break;
			case 3:
				datePostfix = "rd";
				break;
			default:
				datePostfix = "th";
				break;
			}
		}
		return datePostfix;
	}

	public static String monthName(int month) {
		String the_month_name = "";
		
		switch (month)
		{
		case 1:
			the_month_name = "January";
			break;
		case 2:
			the_month_name = "February";
			break;
		case 3:
			the_month_name = "March";
			break;
		case 4:
			the_month_name = "April";
			break;
		case 5:
			the_month_name = "May";
			break;
		case 6:
			the_month_name = "June";
			break;
		case 7:
			the_month_name = "July";
			break;
		case 8:
			the_month_name = "August";
			break;
		case 9:
			the_month_name = "September";
			break;
		case 10:
			the_month_name = "October";
			break;
		case 11:
			the_month_name = "November";
			break;
		case 12:
			the_month_name = "December";
			break;
		}
		return the_month_name;		
	}

	public static String dayOfTheWeek(int day, int month, int year) {
		String the_day = "";
		
		int lastTwoDigitsOfYear = year%100;
		int firstTwoDigitsOfYear = year/100;

		int dayOfWeek = (int) Math.abs((day + Math.floor(2.6*(((month + 9) % 12) + 1) - 0.2) + lastTwoDigitsOfYear + Math.floor(lastTwoDigitsOfYear/4) + Math.floor(firstTwoDigitsOfYear/4) - 2*firstTwoDigitsOfYear))%7;

		switch (dayOfWeek)
		{
		case 0:
			the_day = "Sunday";
			break;
		case 1:
			the_day = "Monday";
			break;
		case 2:
			the_day = "Tuesday";
			break;
		case 3:
			the_day = "Wednesday";
			break;
		case 4:
			the_day = "Thursday";
			break;
		case 5:
			the_day = "Friday";
			break;
		case 6:
			the_day = "Saturday";
			break;
		}
		return the_day;
	}
}
