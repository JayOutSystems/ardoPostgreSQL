/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package ardo.postgresql.introspection;

import ardo.postgresql.configuration.RuntimeDatabaseConfiguration;
import outsystems.hubedition.extensibility.data.IDatabaseServices;
import outsystems.hubedition.extensibility.data.databaseobjects.IDatabaseInfo;
import outsystems.hubedition.extensibility.data.databaseobjects.IDatabaseObjectFactory;
import outsystems.hubedition.extensibility.data.databaseobjects.ITableSourceInfo;
import outsystems.hubedition.util.StringUtils;
import outsystems.hubedition.util.TypeInformation;

/**
 *	Creates introspection objects from qualified names, inspecting the database only if needed.
 */
public class DatabaseObjectFactory implements IDatabaseObjectFactory {
    public static final TypeInformation<DatabaseObjectFactory> TypeInfo = TypeInformation.get(DatabaseObjectFactory.class);
    
    protected IDatabaseServices databaseServices;
    
    /**
	 *	Initializes a new instance of the DatabaseObjectFactory class.
	 *	@param	databaseServices	The database services.
	 */
    public DatabaseObjectFactory(IDatabaseServices databaseServices){
        this.databaseServices = databaseServices;
    }
    
    /**
	 *	Returns an object that contains information about the current database
	 *	@return	Database-specific object that implements the IDatabaseInfo interface
	 */
    public final IDatabaseInfo createLocalDatabaseInfo() {
        return new DatabaseInfo(databaseServices, ((RuntimeDatabaseConfiguration)databaseServices.getDatabaseConfiguration()).getDatabaseIdentifier());
    }
    
    /**
	 *	Returns an object that contains information about a database, inferring it from a database identifier. If the databaseIdentifier does not contain all the required information, the remaining should be inferred from the current T:OutSystems.HubEdition.Extensibility.Data.ConfigurationService.IRuntimeDatabaseConfiguration.
	 *	@param	databaseIdentifier	Unique identifier of the database
	 *	@return	Database-specific object that implements the IDatabaseInfo interface
	 */
    public final IDatabaseInfo createDatabaseInfo(String databaseIdentifier) {
    	if (databaseIdentifier.startsWith("\"")){
    		databaseIdentifier = databaseIdentifier.substring(1,  databaseIdentifier.length() - 1);
    	}
        return new DatabaseInfo(databaseServices, databaseIdentifier);
    }
    
    /**
	 *	Returns an object that contains information about a table source (data source in tabular format), like a database table or view, inferring both the database and table source information from a qualifiedName. If the qualifiedName does not contain all the required information, the remaining should be inferred from the current T:OutSystems.HubEdition.Extensibility.Data.ConfigurationService.IRuntimeDatabaseConfiguration.
	 *	@param	qualifiedName	Qualified identifier of the table source, including the database information
	 *	@return	Database-specific object that implements the ITableSourceInfo interface
	 */
    public final ITableSourceInfo createTableSourceInfo(String qualifiedName) {
        String[] parts = qualifiedName.split("\\.");
        
        switch (parts.length)
        {
        case 1:
        	return new TableSourceInfo(databaseServices, createDatabaseInfo(""), StringUtils.trim(parts[0], '"'));
        default:
        	return new TableSourceInfo(databaseServices, createDatabaseInfo(parts[0].trim()), StringUtils.trim(parts[1], '"'));
        }
        
    }
}