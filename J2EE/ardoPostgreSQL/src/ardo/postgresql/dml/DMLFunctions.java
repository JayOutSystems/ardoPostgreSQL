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
        return String.format("trunc(%s)", n);
    }
    
    /**
	 *	Returns a DML expression that searches an expression for another expression and returns its starting position if found. Returns -1 if the search expression is empty or cannot be found.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@param	search	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String index(String t, String search) {
        return String.format("(position(%s in %s)-1)",search,t);
    }
    
    /**
	 *	Returns a DML expression that computes the number of characters in a string.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String length(String t) {
        return String.format("length(%s)", t);
    }
    
    /**
	 *	Returns a DML expression that computes a substring beginning at start zero-based position and with length characters.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@param	start	A DML expression that evaluates to an Integer, containing the start index.
	 *	@param	length	A DML expression that evaluates to an Integer, containing the length of the text to return.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String substr(String t, String start, String length) {
        return String.format("substring(%s from (%s) + 1 for %s)", t, start, length);
    }
    
    /**
	 *	Returns a DML expression that removes all leading and trailing white spaces from a string.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String trim(String t) {
        return String.format("trim(%s)", t);
    }
    
    private String addDate(String dt, String n, String unit) {
    	return String.format("(%s::timestamp without time zone + ((%s) * interval '1 %s'))", dt, n, unit);
    }
    
    /**
	 *	Returns a DML expression that adds days to a DateTime and returns a valid DataTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to a Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addDays(String dt, String n) {
        return addDate(dt,  n, "day");
    }
    
    /**
	 *	Returns a DML expression that adds days to a DateTime and returns a valid DataTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to a Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addHours(String dt, String n) {
        return addDate(dt, n, "hour");
    }
    
    /**
	 *	Returns a DML expression that adds minutes to a DateTime and returns a valid DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addMinutes(String dt, String n) {
        return addDate(dt, n, "minute");
    }
    
    /**
	 *	Returns a DML expression that adds months to a DateTime and returns a valid DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addMonths(String dt, String n) {
        return addDate(dt, n, "month");
    }
    
    /**
	 *	Returns a DML expression that adds seconds to a DateTime and returns a valid DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addSeconds(String dt, String n) {
        return addDate(dt, n, "second");
    }
    
    /**
	 *	Returns a DML expression that adds years to a DateTime and returns a valid DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	n	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String addYears(String dt, String n) {
        return addDate(dt, n, "year");
    }
    
    /**
	 *	Returns a DML expression that creates a new DateTime given a Date and a Time.
	 *	@param	d	A DML expression that evaluates to a Date.
	 *	@param	t	A DML expression that evaluates to a Time.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String buildDateTime(String d, String t) {
        return String.format("(%s :: timestamp without time zone + (%s :: timestamp without time zone - timestamp '1900-01-01 00:00:00'))", d, t);
    }
    
    /**
	 *	Returns a DML expression that computes the day of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String day(String dt) {
        return String.format("cast(extract(day from %s :: timestamp without time zone) as int)", dt);
    }
    
    /**
	 *	Returns a DML expression that computes the week day of a DateTime, ranging from 0 (Sunday) to 6 (Saturday).
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String dayOfWeek(String dt) {
        return String.format("cast(extract(dow from %s :: timestamp without time zone) as int)", dt);
    }
    
    /**
	 *	Returns a DML expression that computes how many days have passed between two DateTimes. Returns zero if the two dates are the same, a positive integer if dt1 is smaller than dt2, and a negative number otherwise.
	 *	@param	dt1	First DML expression that evaluates to a DateTime.
	 *	@param	dt2	Second DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String diffDays(String dt1, String dt2) {
        return String.format("cast(date_part('day', %s ::timestamp without time zone - %s :: timestamp without time zone) as int)", dt2, dt1) ;
    }
    
    /**
	 *	Returns a DML expression that computes how many hours have passed between two DateTimes. Returns zero if the two dates and hours are the same, a positive integer if dt1 is smaller than dt2, and a negative number otherwise.
	 *	@param	dt1	First DML expression that evaluates to a DateTime.
	 *	@param	dt2	Second DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String diffHours(String dt1, String dt2) {
        return "cast((" + diffDays(dt1,dt2) + String.format(")*24 + date_part('hour', %s ::timestamp without time zone - %s ::timestamp without time zone ) as int)", dt2, dt1);
    }
    
    /**
	 *	Returns a DML expression that computes how many minutes have passed between two DateTimes. Returns zero if the two dates, hours and minutes are the same, a positive integer if dt1 is smaller than dt2, and a negative number otherwise.
	 *	@param	dt1	A DML expression that evaluates to a DateTime.
	 *	@param	dt2	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String diffMinutes(String dt1, String dt2) {
    	return "cast((" + diffHours(dt1, dt2) + String.format(")*60 + date_part('minute', %s ::timestamp without time zone - %s ::timestamp without time zone) as int)", dt2, dt1);
    }
    
    /**
	 *	Returns a DML expression that computes how many seconds have passed between two DateTimes. Returns zero if the two dates, hours, minutes, and seconds are the same, a positive integer if dt1 is smaller than dt2, and a negative number otherwise.
	 *	@param	dt1	A DML expression that evaluates to a DateTime.
	 *	@param	dt2	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String diffSeconds(String dt1, String dt2) {
    	return "cast((" + diffMinutes(dt1, dt2) + String.format(")*60 + date_part('seconds', %s ::timestamp without time zone - %s ::timestamp without time zone) as int)", dt2, dt1);
    }
    
    /**
	 *	Returns a DML expression that computes the hour part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String hour(String dt) {
        return String.format("cast(extract(hour from %s :: timestamp without time zone) as int)", dt);
    }
    
    /**
	 *	Returns a DML expression that computes the minute part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String minute(String dt) {
    	return String.format("cast(extract(minute from %s :: timestamp without time zone) as int)", dt);
    }
    
    /**
	 *	Returns a DML expression that computes the month part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String month(String dt) {
    	return String.format("cast(extract(month from %s :: timestamp without time zone) as int)", dt);
    }
    
    /**
	 *	Returns a DML expression that computes a new date from a year, month, and day.
	 *	@param	y	A DML expression that evaluates to an Integer.
	 *	@param	m	A DML expression that evaluates to an Integer.
	 *	@param	d	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a Date.
	 */
    public String newDate(String y, String m, String d) {
    	return String.format("to_date(concat(%s,'-',%s,'-',%s), 'YYYY-MM-DD')",y,m,d);
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
    	return String.format("(to_timestamp(concat(%s,'-',%s,'-',%s,' ',%s,':',%s,':',%s), 'YYYY-MM-DD HH24:MI:SS') :: timestamp without time zone)", y, mo, d, h, m, s);
    }
    
    /**
	 *	Returns a DML expression that computes a new Time from an hour, minute, and second.
	 *	@param	h	A DML expression that evaluates to an Integer.
	 *	@param	m	A DML expression that evaluates to an Integer.
	 *	@param	s	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to Time.
	 */
    public String newTime(String h, String m, String s) {
        return newDateTime("1900", "01", "01", h, m, s);
    }
    
    /**
	 *	Returns a DML expression that computes the seconds part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String second(String dt) {
        return String.format("cast(extract(second from %s :: timestamp without time zone) as int)", dt);
    }
    
    /**
	 *	Returns a DML expression that computes the year part of a DateTime.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String year(String dt) {
        return String.format("cast(extract(year from %s :: timestamp without time zone) as int)", dt);
    }
    
    /**
	 *	Returns a DML expression that converts a Boolean expression to an Integer. The expression evaluates into 1 if the boolean is True, or 0 if False.
	 *	@param	b	A DML expression that evaluates to a Boolean.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String booleanToInteger(String b) {
        return String.format("cast(%s as int)", b);
    }
    
    /**
	 *	Returns a DML expression that converts a Boolean in its textual representation: True or False.
	 *	@param	b	A DML expression that evaluates to Boolean.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String booleanToText(String b) {
        return String.format("(case %s when TRUE then 'True' ELSE 'False' end)", b);
    }
    
    /**
	 *	Returns a DML expression that converts a DateTime to a Date, by dropping the Time component.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to a Date.
	 */
    public String dateTimeToDate(String dt) {
        return String.format("cast(%s as date)", dt);
    }
    
    /**
	 *	Returns a DML expression that converts a DateTime to its textual representation, using a specified format.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@param	dateFormat	Date format used to serialize the date component of the text value (e.g. YYYY-MM-DD).
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String dateTimeToText(String dt, String dateFormat) {
        return String.format("to_char(%s :: timestamp without time zone, '%s HH24:MI:SS')", dt, dateFormat.toUpperCase());
    }
    
    /**
	 *	Returns a DML expression that converts a DateTime to a Time, by dropping the Date component.
	 *	@param	dt	A DML expression that evaluates to a DateTime.
	 *	@return	A DML expression that evaluates to a Time.
	 */
    public String dateTimeToTime(String dt) {
        return String.format("(timestamp '1900-01-01 00:00:00' + cast(%s as time))", dt);
    }
    
    /**
	 *	Returns a DML expression that converts a Date to its textual representation, using a specified format.
	 *	@param	d	A DML expression that evaluates to a Date.
	 *	@param	dateFormat	Date format used to serialize the date component of the text value (e.g. YYYY-MM-DD).
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String dateToText(String d, String dateFormat) {
        return String.format("to_char(%s :: timestamp without time zone, '%s')", d, dateFormat.toUpperCase());
    }
    
    /**
	 *	Returns an SQL expreession that converts a Decimal to a Boolean. A Decimal value of 0.0 is False, all other values are True.
	 *	@param	d	A DML expression that evaluates to a Decimal.
	 *	@return	A DML expression that evaluates to Boolean.
	 */
    public String decimalToBoolean(String d) {
        return String.format("(case %s when 0.0 then FALSE else TRUE end)", d);
    }
    
    /**
	 *	Returns a DML expression that converts a Decimal to an Integer.
	 *	@param	d	A DML expression that evaluates to a Decimal.
	 *	@return	A DML expression that evaluates to a Boolean.
	 */
    public String decimalToInteger(String d) {
        return String.format("cast(%s as int)", d);
    }
        
    /**
	 *	Returns a DML expression that converts a Decimal to its textual representation.
	 *	@param	d	A DML expression that evaluates to a Decimal.
	 *	@return	A DML expression that evaluates to a Decimal.
	 */
    public String decimalToText(String d) {
        return String.format("cast(%s as text)", d);
    }
    
    /**
	 *	Provides a DML expression that converts EntityReference 'er' to an Integer value.
	 *	@param	er	DML expression that evaluates to an integer value
	 *	@return	DML expression of type Integer
	 */
    public String entityRefIntegerToInteger(String er) {
        return er;
    }
    
    /**
	 *	Returns a DML expression that converts an EntityReference to its textual representation.
	 *	@param	er	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String entityRefTextToText(String er) {
        return er;
    }
    
    /**
	 *	Returns a DML expression that converts an Integer to a Boolean. A Decimal value of 0 is False, all other values are True.
	 *	@param	i	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a Boolean.
	 */
    public String integerToBoolean(String i) {
        return String.format("cast(%s as boolean)",i);
    }
    
    /**
	 *	Returns a DML expression that converts an Integer to a Decimal.
	 *	@param	i	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to a decimal.
	 */
    public String integerToDecimal(String i) {
        return String.format("cast(%s as decimal)", i);
    }
    
    /**
	 *	Returns a DML expression that converts an Integer to its textual representation.
	 *	@param	i	A DML expression that evaluates to an Integer.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String integerToText(String i) {
        return String.format("cast(%s as text)", i);
    }
    
    /**
	 *	Returns a DML expression that computes a Null Date (1900-01-01).
	 *	@return	A DML expression that evaluates to a Date.
	 */
    public String nullDate() {
        return "date '1900-01-01'";
    }
    
    /**
	 *	Returns a DML expression that converts Text to a Date.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@param	dateFormat	Date format used to serialize the date component of the text value (e.g. YYYY-MM-DD).
	 *	@return	A DML expression that evaluates to a Date.
	 */
    public String textToDate(String t, String dateFormat) {
        return String.format("to_date(%s,'%s')", t, dateFormat.toUpperCase());
    }
    
    /**
	 *	Provides a DML expression that converts Text 't' to a DateTime value.
	 *	@param	t	DML expression that evaluates to a text value
	 *	@param	dateFormat	date format used to serialize the date component of the text value (e.g. YYYY-MM-DD)
	 *	@return	DML expression of type DateTime
	 */
    public String textToDateTime(String t, String dateFormat) {
        return String.format("(to_timestamp(%s, '%s HH24:MI:SS')::timestamp without time zone)", t, dateFormat.toUpperCase());
    }
    
    /**
	 *	Returns a DML expression that converts Text to a DateTime.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to a DateTime.
	 */
    public String textToDecimal(String t) {
        return String.format("cast(%s as decimal)", t);
    }
    
    /**
	 *	Returns a DML expression that converts Text to an Integer.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to an Integer.
	 */
    public String textToInteger(String t) {
        return String.format("cast(%s as integer)", t);
    }
    
    /**
	 *	Returns a DML expression that converts Text to Time.
	 *	@param	t	A DML expression that evaluates to Text.
	 *	@return	A DML expression that evaluates to Time.
	 */
    public String textToTime(String t) {
        return String.format("(to_timestamp('1900-01-01 ' || %s, 'YYYY-MM-DD HH24:MI:SS')::timestamp without time zone)", t);
    }
    
    /**
	 *	Returns a DML expression that converts a Time to its text value in the format hh:mm:ss.
	 *	@param	t	A DML expression that evaluates to Time.
	 *	@return	A DML expression that evaluates to Text.
	 */
    public String timeToText(String t) {
        return String.format("to_char(%s :: timestamp without time zone,'HH24:MI:SS')", t);
    }
    
    public String timeToDateTime(String t) {
        return String.format("(%s :: timestamp without time zone)", t);
    }

    public String dateToDateTime(String d) {
        return String.format("(%s :: timestamp without time zone)", d);
    }

	@Override
	public String decimalToLongInteger(String d) {
		// TODO Auto-generated method stub
		return String.format("cast(%s as bigint)", d);
	}

	@Override
	public String identifierToInteger(String id) {
		return id;
	}

	@Override
	public String identifierToLongInteger(String id) {
		return id;
	}

	@Override
	public String identifierToText(String id) {
		return id;
	}

	@Override
	public String longIntegerToInteger(String b) {
		return String.format("cast(%s as int)", b);
	}

	@Override
	public String longIntegerToDecimal(String b) {
		return String.format("cast(%s as decimal)", b);
	}

	@Override
	public String integerToLongInteger(String b) {
		return String.format("cast(%s as bigint)", b);
	}

	@Override
	public String longIntegerToText(String b) {
		return String.format("cast(%s as text)", b);
	}

	@Override
	public String textToLongInteger(String t) {
		return String.format("cast(%s as bigint)", t);
	}
    
}
