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
import outsystems.runtimecommon.*;
import java.math.BigDecimal;


public interface ISessionConfigurationManager
{
    
    /**
	 *	This property will obtain all the statements necessary to recreate the session model. It has all the opportunities to do changes in templates that depend on configuration information.
	 *	@return	Statements to recreate the session model.
	 *	@throws	Exception	If an error occurs while obtain all the statements.
	 */
    public Iterable<String> getSessionStatements() throws Exception;
    
    /**
	 *	Validates if elevated privileges are actually required If plugin has ImplementsElevatedPrivilegesOperations=false, this method should return false. This ensures pre create or upgrade logic can be ran by hand to avoid elevated privileges during setup  Elevated privileges operations still need to run for setup to be complete
	 *	@return	Elevated privileges operations still need to run for setup to be complete
	 */
    public boolean requiresElevatedPrivileges();
    
    /**
	 *	Generates a setup script containing operations that require elevated privileges  Setup script with elevated privileges operations
	 *	@return	Setup script with elevated privileges operations
	 */
    public String generateSetupScript();
    
    
    /**
	 *	Allows the plugin to run instructions before the create/upgrade is done. This operation requires an elevated user privilege. If plugin has ImplementsElevatedPrivilegesOperations=false, this method should not be implemented. (the caller wouldn\u2019t have a proper config to pass anyway) This would allow logic such as - create the database if it doesn\u2019t exist.
	 */
    public void pre_CreateOrUpgradeSession();
    
    /**
	 *	Validates that the configuration for the user \u2018User\u2019 are valid and it can reach the db. It will return false if it cannot reach the db, and will have a non null errorMessage in that case.
	 *	@param	friendlyMessage	The friendly message to be show as output.
	 *	@return	Returns True if the connection to the database was successfully. Otherwise it returns False.
	 *	@throws	java.sql.SQLException	If an error occurs while accessing the database.
	 */
    public boolean testSessionConnection(RefParmHolder<String> friendlyMessage) throws java.sql.SQLException;
}
