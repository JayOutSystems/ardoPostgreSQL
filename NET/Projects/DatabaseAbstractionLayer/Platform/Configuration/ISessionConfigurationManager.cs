/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

using System.Collections.Generic;
using OutSystems.RuntimeCommon;

namespace OutSystems.HubEdition.Extensibility.Data.Platform.Configuration {
    public interface ISessionConfigurationManager {

        /// <summary>
        /// This property will obtain all the statements necessary to recreate the session model.
        /// It has all the opportunities to do changes in templates that depend on configuration information.
        /// </summary>
        IEnumerable<string> SessionStatements {
            get;
        }

        /// <summary>
        /// Allows the plugin to run instructions before the create/upgrade is done.
        /// This operation requires an elevated user privilege.
        /// If plugin has ImplementsElevatedPrivilegesOperations=false, this method should not be implemented. (the caller wouldn’t have a proper config to pass anyway)
        /// This would allow logic such as - create the database if it doesn’t exist.
        /// </summary>
        void Pre_CreateOrUpgradeSession();

        /// <summary>
        /// Validates that the configuration for the user ‘User’ are valid and it can reach the db.
        /// It will return false if it cannot reach the db, and will have a non null errorMessage in that case.
        /// </summary>
        bool TestSessionConnection(out string friendlyMessage);
    }
}