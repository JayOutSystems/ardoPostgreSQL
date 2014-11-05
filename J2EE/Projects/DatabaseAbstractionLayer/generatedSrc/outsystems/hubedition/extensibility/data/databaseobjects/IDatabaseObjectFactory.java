/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.databaseobjects;

import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.configurationservice.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import java.math.BigDecimal;



/**
 *	Creates introspection objects from qualified names, inspecting the database only if needed.
 */
public interface IDatabaseObjectFactory
{
    
    /**
	 *	Returns an object that contains information about the current database
	 *	@return	Database-specific object that implements the IDatabaseInfo interface
	 */
    public IDatabaseInfo createLocalDatabaseInfo();
    
    /**
	 *	Returns an object that contains information about a database, inferring it from a database identifier. If the databaseIdentifier does not contain all the required information, the remaining  should be inferred from the current IRuntimeDatabaseConfiguration.
	 *	@param	databaseIdentifier	Unique identifier of the database
	 *	@return	Database-specific object that implements the IDatabaseInfo interface
	 *	@throws	SQLException	if an error occurs while accessing the database
	 *	@throws	InvalidDatabaseObjectIdentifierException	if the databaseIdentifier is invalid
	 */
    public IDatabaseInfo createDatabaseInfo(String databaseIdentifier) throws InvalidDatabaseObjectIdentifierException, outsystems.hubedition.extensibility.data.introspectionservice.IntrospectionServiceException;
    
    /**
	 *	Returns an object that contains information about a table source (data source in tabular format), like a database table or view, inferring both the database and table source information from a qualifiedName. If the qualifiedName does not contain  all the required information, the remaining should be inferred from the current IRuntimeDatabaseConfiguration.
	 *	@param	qualifiedName	Qualified identifier of the table source, including the database information
	 *	@return	Database-specific object that implements the ITableSourceInfo interface
	 *	@throws	SQLException	if an error occurs while accessing the database
	 *	@throws	InvalidDatabaseObjectIdentifierException	if the qualifiedName is invalid
	 */
    public ITableSourceInfo createTableSourceInfo(String qualifiedName) throws InvalidDatabaseObjectIdentifierException, outsystems.hubedition.extensibility.data.introspectionservice.IntrospectionServiceException;
}
