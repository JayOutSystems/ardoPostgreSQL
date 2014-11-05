/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.executionservice;

import java.sql.*;
import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import java.math.BigDecimal;



/**
 *	Class with extension methods to IExecutionService.
 */
public class ExecutionServiceExtensions {
    public static final TypeInformation<ExecutionServiceExtensions> TypeInfo = TypeInformation.get(ExecutionServiceExtensions.class);
    
    /**
     *	Checks if a type is a date or time. .NET: Returns True if a type is a DateTime, Date, or Time.Java: Returns True if a type if a TIMESTAMP.
     *	@param	executionService	The execution service to use to check if a type is a date or time.
     *	@param	dbType	Type to be checked.
     *	@return	A boolean indicating if the type is a date or time.
     */
    public static boolean isDateType(IExecutionService executionService, int dbType)
    {
        return dbType == Types.TIMESTAMP;
    }
    
    
    /**
     *	Checks if a type is a unicode string. .NET: Returns True if a type is a String or StringFixedLength.Java: Returns True if a type is VARCHAR.
     *	@param	executionService	The execution service to use to check if a type is a unicode string.
     *	@param	dbType	Type to be checked.
     *	@return	A boolean indicating if the type is a unicode string.
     */
    public static boolean isUnicodeStringType(IExecutionService executionService, int dbType)
    {
        return dbType == Types.VARCHAR;
    }
    
}
