/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.javaservertests.databaseprovider.dmlservice;

import java.text.*;
import java.util.*;
import org.junit.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.servertests.databaseprovider.framework.*;
import java.math.BigDecimal;


public class ServerOnlyDMLTestsConfiguration extends DMLTestsConfiguration {
    public static final TypeInformation<ServerOnlyDMLTestsConfiguration> TypeInfo = TypeInformation.get(ServerOnlyDMLTestsConfiguration.class);
    
    protected boolean isServerOnly()
    {
        return true;
    }
}
