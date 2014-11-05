/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.platform.configuration;

import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.platform.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import java.math.BigDecimal;


public interface IPlatformConfigurationManager
{
    
    /**
	 *	This property indicates if this database should recommend a Database backup. If the DB doesn\u2019t allow rollback of all statements and does implicit commits, it should have this property set to true. when set to true, indicates that its statements can do autocommit.
	 */
    public boolean isRecommendDatabaseBackup();
    
    /**
	 *	This method will obtain the version that is being installed.
	 *	@return	The version number to upgrade.
	 */
    public Version getUpgradeVersion() throws Exception;
    
    /**
	 *	This method will obtain all the statements necessary to upgrade from currentModelVersion to the version that is being installed. This method will process a well known source file upgrade script. It will do some pre-processing based in internal plugin configurations.
	 *	@param	currentModelVersion	this parameter indicates the version from which we need to upgrade
	 *	@return	Set of statements to execute. This includes tagged statements (--%TAG%)
	 */
    public Iterable<Block> platformStatements(Version currentModelVersion) throws Exception;
    
    /**
	 *	Allows the plugin to run instructions before the create/upgrade is done. This operation requires an elevated user privilege. If plugin has ImplementsElevatedPrivilegesOperations=false, this method should not be implemented. (the caller wouldn\u2019t have a proper config to pass anyway) This would allow logic such as - create the database if it doesn\u2019t exist.
	 */
    public void pre_CreateOrUpgradePlatform();
    
    /**
	 *	Validates that the configuration for the user \u2018User\u2019 are valid and it can reach the db. It will return false if it cannot reach the db, and will have a non null errorMessage in that case.
	 *	@param	source	Specifies the component that will use the configuration (e.g. service or application).
	 *	@param	friendlyMessage	Message with information regarding the result of the test.
	 *	@return	True if connection was sucessfully established
	 */
    public boolean testAdminConnection(RefParmHolder<String> friendlyMessage, Source source) throws java.sql.SQLException;
    
    /**
	 *	Validates that the configuration for the user \u2018User\u2019 are valid and it can reach the db. It will return false if it cannot reach the db, and will have a non null errorMessage in that case.
	 *	@param	source	Specifies the component that will use the configuration (e.g. service or application).
	 *	@param	friendlyMessage	Message with information regarding the result of the test.
	 *	@return	True if connection was sucessfully established
	 */
    public boolean testRuntimeConnection(RefParmHolder<String> friendlyMessage, Source source) throws java.sql.SQLException;
    
    /**
	 *	Validates that the configuration for the user \u2018User\u2019 are valid and it can reach the db. It will return false if it cannot reach the db, and will have a non null errorMessage in that case.
	 *	@param	source	Specifies the component that will use the configuration (e.g. service or application).
	 *	@param	friendlyMessage	Message with information regarding the result of the test.
	 *	@return	True if connection was sucessfully established
	 */
    public boolean testLogConnection(RefParmHolder<String> friendlyMessage, Source source) throws java.sql.SQLException;
}
