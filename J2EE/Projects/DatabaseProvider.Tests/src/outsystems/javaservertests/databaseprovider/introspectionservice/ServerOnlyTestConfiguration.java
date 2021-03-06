/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.javaservertests.databaseprovider.introspectionservice;

import java.text.*;
import java.util.*;
import linqbridge.linq.*;
import org.junit.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.databaseobjects.*;
import outsystems.hubedition.extensibility.data.introspectionservice.*;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import outsystems.servertests.databaseprovider.framework.*;
import java.math.BigDecimal;


public class ServerOnlyTestConfiguration extends TestConfiguration {
    public static final TypeInformation<ServerOnlyTestConfiguration> TypeInfo = TypeInformation.get(ServerOnlyTestConfiguration.class);
    
    protected boolean isServerOnly()
    {
        return true;
    }
    
}
