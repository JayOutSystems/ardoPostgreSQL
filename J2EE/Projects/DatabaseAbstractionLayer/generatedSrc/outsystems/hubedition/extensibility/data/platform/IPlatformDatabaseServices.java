/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.platform;

import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.*;
import outsystems.hubedition.extensibility.data.platform.ddlservice.*;
import outsystems.hubedition.extensibility.data.platform.dmlservice.*;
import outsystems.hubedition.extensibility.data.platform.executionservice.*;
import outsystems.hubedition.extensibility.data.platform.introspectionservice.*;
import outsystems.hubedition.extensibility.data.platform.session.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import java.math.BigDecimal;
import outsystems.hubedition.extensibility.data.IDatabaseServices;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.IPlatformDatabaseObjectFactory;
import outsystems.hubedition.extensibility.data.platform.ddlservice.IDDLService;
import outsystems.hubedition.extensibility.data.platform.dmlservice.IPlatformDMLService;
import outsystems.hubedition.extensibility.data.platform.executionservice.IPlatformExecutionService;
import outsystems.hubedition.extensibility.data.platform.introspectionservice.IPlatformIntrospectionService;
import outsystems.hubedition.extensibility.data.platform.session.IPlatformSessionService;



/**
 *	Represents the set of services that added with the ones specified in the IDatabaseServices object enable complete database usage.
 */
public interface IPlatformDatabaseServices extends IDatabaseServices
{
    
    /**
	 *	Returns a factory capable of creating platform introspection objects.
	 */
    public IPlatformDatabaseObjectFactory getObjectFactory();
    
    /**
	 *	Gets the IPlatformIntrospectionService associated with the platform database
	 */
    public IPlatformIntrospectionService getIntrospectionService();
    
    /**
	 *	Gets the IPlatformDMLServiceobject associated with the database. Represents a service that generates SQL statements.
	 */
    public IPlatformDMLService getDMLService();
    
    
    /**
	 *	Gets the IPlatformExecutionService associated with the platform database
	 */
    public IPlatformExecutionService getExecutionService();
    
    /**
	 *	Gets the IDDLService associated with the platform database
	 */
    public IDDLService getDDLService();
    
    /**
	 *	Gets the IPlatformSessionService associated with the platform database
	 */
    public IPlatformSessionService getSessionService();
}
