/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.platform.executionservice;

import java.sql.*;
import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.executionservice.*;
import outsystems.hubedition.extensibility.data.platform.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import java.math.BigDecimal;
import outsystems.hubedition.databaseabstractionlayer.adoadapters.ADOCommand;
import outsystems.hubedition.extensibility.data.executionservice.IExecutionService;


/**
 *	Platform Database service that handles the execution of statements made while connected to a database.
 */
public interface IPlatformExecutionService extends IExecutionService
{
    
    /**
	 *	Executes a stored procedure using a command. That store procedure should return a cursor.
	 *	@param	cmd	The stored procedure command.
	 *	@param	readerParamName	Name of the output parameter, without the prefix, to associate the reader with, if the procedure returns one (e.g. a cursor)
	 *	@return	A reader with the results of the stored procedure.
	 */
    public OSResultSet executeStoredProcedureWithResultSet(ADOCommand cmd, String readerParamName) throws SQLException;
}
