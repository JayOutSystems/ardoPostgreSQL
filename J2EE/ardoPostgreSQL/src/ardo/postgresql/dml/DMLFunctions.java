/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package ardo.postgresql.dml;

import outsystems.hubedition.extensibility.data.dmlservice.BaseDMLFunctions;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLService;
import outsystems.hubedition.util.TypeInformation;

/**
 *	Class for generating the DML functions required by the applications to perform simple queries
 */
public class DMLFunctions extends BaseDMLFunctions {
    public static final TypeInformation<DMLFunctions> TypeInfo = TypeInformation.get(DMLFunctions.class);
    
    /**
	 *	Initializes a new instance of the DMLFunctions class.
	 *	@param	dmlService	The DML service.
	 */
    public DMLFunctions(IDMLService dmlService){
        super(dmlService);
    }
    
    /**
	 *	This property represents the associated DML service.
	 */
    public final DMLService getDMLService$DMLFunctions() {
        return (DMLService) super.getDMLService();
    }
    
    /**
	 *	Returns a DML expression that computes the decimal number 'n' truncated to integer removing the decimal part of 'n'.
	 *	@param	n	DML expression of type Decimal that evaluates to the decimal number to truncate
	 *	@return	A DML expression that evaluates to a Decimal.
	 */
    public String trunc(String n) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that searches an expression for another expression and returns its starting position if found. Returns -1 if the search expression is empty or cannot be found.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@param	search	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String index(String t, String search) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes the number of characters in a string.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String length(String t) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes a substring beginning at start zero-based position and with length characters.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@param	start	A DML expression that evaluates to an Integer, containing the start index.
	 *	@param	length	A DML expression that evaluates to an Integer, containing the length of the text to return.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String substr(String t, String start, String length) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that removes all leading and trailing white spaces from a string.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String trim(String t) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that adds days to a DateTime and returns a valid DataTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to a Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addDays(String dt, String n) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that adds days to a DateTime and returns a valid DataTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to a Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addHours(String dt, String n) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that adds minutes to a DateTime and returns a valid DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addMinutes(String dt, String n) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that adds months to a DateTime and returns a valid DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addMonths(String dt, String n) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that adds seconds to a DateTime and returns a valid DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addSeconds(String dt, String n) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that adds years to a DateTime and returns a valid DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addYears(String dt, String n) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that creates a new DateTime given a Date and a Time.
	 *	@param	d	A DML expression that evaluates to a Date.
	 *	@param	t	A DML expression that evaluates to a Time.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String buildDateTime(String d, String t) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes the day of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String day(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes the week day of a DateTime, ranging from 0 (Sunday) to 6 (Saturday).
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String dayOfWeek(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes how many days have passed between two DateTimes. Returns zero if the two dates are the same, a positive integer if dt1 is smaller than dt2, and a negative number otherwise.
	 *	@param	dt1	First DML expression that evaluates to a DateTime.
	 *	@param	dt2	Second DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String diffDays(String dt1, String dt2) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes how many hours have passed between two DateTimes. Returns zero if the two dates and hours are the same, a positive integer if dt1 is smaller than dt2, and a negative number otherwise.
	 *	@param	dt1	First DML expression that evaluates to a DateTime.
	 *	@param	dt2	Second DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String diffHours(String dt1, String dt2) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes how many minutes have passed between two DateTimes. Returns zero if the two dates, hours and minutes are the same, a positive integer if dt1 is smaller than dt2, and a negative number otherwise.
	 *	@param	dt1	A DML expression that evaluates to a DateTime.
	 *	@param	dt2	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String diffMinutes(String dt1, String dt2) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes how many seconds have passed between two DateTimes. Returns zero if the two dates, hours, minutes, and seconds are the same, a positive integer if dt1 is smaller than dt2, and a negative number otherwise.
	 *	@param	dt1	A DML expression that evaluates to a DateTime.
	 *	@param	dt2	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String diffSeconds(String dt1, String dt2) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes the hour part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String hour(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes the minute part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String minute(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes the month part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String month(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes a new date from a year, month, and day.
	 *	@param	y	A DML expression that evaluates to an Integer.
	 *	@param	m	A DML expression that evaluates to an Integer.
	 *	@param	d	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a Date.
	 */
    public String newDate(String y, String m, String d) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes a new DateTime from a year, month, day, hour, minute, and second.
	 *	@param	y	A DML expression that evaluates to an Integer.
	 *	@param	mo	A DML expression that evaluates to an Integer.
	 *	@param	d	A DML expression that evaluates to an Integer.
	 *	@param	h	A DML expression that evaluates to an Integer.
	 *	@param	m	A DML expression that evaluates to an Integer.
	 *	@param	s	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to DateTime.
	 */
    public String newDateTime(String y, String mo, String d, String h, String m, String s) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes a new Time from an hour, minute, and second.
	 *	@param	h	A DML expression that evaluates to an Integer.
	 *	@param	m	A DML expression that evaluates to an Integer.
	 *	@param	s	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to Time.
	 */
    public String newTime(String h, String m, String s) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes the seconds part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String second(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes the year part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String year(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts a Boolean expression to an Integer. The expression evaluates into 1 if the boolean is True, or 0 if False.
	 *	@param	b	A DML expression that evaluates to a Boolean.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String booleanToInteger(String b) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that convers a Boolean in its textual representation: True or False.
	 *	@param	b	A DML expression that evaluates to Boolean.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String booleanToText(String b) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts a DateTime to a Date, by dropping the Time component.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to a Date.
	 */
    public String dateTimeToDate(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts a DateTime to its textual representation, using a specified format.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	dateFormat	Date format used to serialize the date component of the text value (e.g. YYYY-MM-DD).
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String dateTimeToText(String dt, String dateFormat) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts a DateTime to a Time, by dropping the Date component.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to a Time.
	 */
    public String dateTimeToTime(String dt) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts a Date to its textual representation, using a specified format.
	 *	@param	d	A DML expression that evaluates to a Date.
	 *	@param	dateFormat	Date format used to serialize the date component of the text value (e.g. YYYY-MM-DD).
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String dateToText(String d, String dateFormat) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns an SQL expreession that converts a Decimal to a Boolean. A Decimal value of 0.0 is False, all other values are True.
	 *	@param	d	A DML expression that evaluates to a Decimal.
	 *	@return	A DML expression that evaluates to Boolean.
	 */
    public String decimalToBoolean(String d) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts a Decimal to an Integer.
	 *	@param	d	A DML expression that evaluates to a Decimal.
	 *	@return	A DML expression that evaluates to a Boolean.
	 */
    public String decimalToInteger(String d) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts a Decimal to its textual representation.
	 *	@param	d	A DML expression that evaluates to a Decimal.
	 *	@return	A DML expression that evaluates to a Decimal.
	 */
    public String decimalToText(String d) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Provides a DML expression that converts EntityReference 'er' to an Integer value.
	 *	@param	er	DML expression that evaluates to an integer value
	 *	@return	DML expression of type Integer
	 */
    public String entityRefIntegerToInteger(String er) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts an EntityReference to its textual representation.
	 *	@param	er	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String entityRefTextToText(String er) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts an Integer to a Boolean. A Decimal value of 0 is False, all other values are True.
	 *	@param	i	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a Boolean.
	 */
    public String integerToBoolean(String i) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts an Integer to a Decimal.
	 *	@param	i	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a decimal.
	 */
    public String integerToDecimal(String i) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts an Integer to its textual representation.
	 *	@param	i	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String integerToText(String i) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that computes a Null Date (1900-01-01).
	 *	@return	A DML expression that evaluates to a Date.
	 */
    public String nullDate() {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts Text to a Date.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@param	dateFormat	Date format used to serialize the date component of the text value (e.g. YYYY-MM-DD).
	 *	@return	A DML expression that evaluates to a Date.
	 */
    public String textToDate(String t, String dateFormat) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Provides a DML expression that converts Text 't' to a DateTime value.
	 *	@param	t	DML expression that evaluates to a text value
	 *	@param	dateFormat	date format used to serialize the date component of the text value (e.g. YYYY-MM-DD)
	 *	@return	DML expression of type DateTime
	 */
    public String textToDateTime(String t, String dateFormat) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts Text to a DateTime.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String textToDecimal(String t) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts Text to an Integer.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String textToInteger(String t) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts Text to Time.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to Time.
	 */
    public String textToTime(String t) {
        throw new UnsupportedOperationException();
    }
    
    /**
	 *	Returns a DML expression that converts a Time to its text value in the format hh:mm:ss.
	 *	@param	t	A DML expression that evaluates to Time.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String timeToText(String t) {
        throw new UnsupportedOperationException();
    }
}
