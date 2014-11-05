/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.configurationservice;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.stream.*;
import javax.xml.transform.*;
import linqbridge.linq.*;
import linqbridge.xml.linq.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.configurationservice.metaconfiguration.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import java.math.BigDecimal;
import linqbridge.linq.LinqMethods;
import outsystems.hubedition.extensibility.data.configurationservice.metaconfiguration.IParameter;
import outsystems.hubedition.extensibility.data.configurationservice.metaconfiguration.MetaDatabaseConfiguration;



public class Serializers {
    public static final TypeInformation<Serializers> TypeInfo = TypeInformation.get(Serializers.class);
    
    public static IntegrationSerializer getForIntegration()
    {
        return new IntegrationSerializer();
    }
    
    
    public static Serializer<IRuntimeDatabaseConfiguration> getForRuntime()
    {
        Func.Func1<IRuntimeDatabaseConfiguration, Iterable<IParameter>> e = 
            new Func.Func1<IRuntimeDatabaseConfiguration, Iterable<IParameter>>() {
                protected Iterable<IParameter> executeImpl(IRuntimeDatabaseConfiguration c) throws Exception
                {
                    MetaDatabaseConfiguration meta = new MetaDatabaseConfiguration(c);
                    return LinqMethods.where(meta.getParameters(), 
                        new Func.Func1<IParameter, Boolean>() {
                            protected Boolean executeImpl(IParameter p) throws Exception
                            {
                                return p.isPersist();
                            }
                        });
                }
            };
        
        return new Serializer<IRuntimeDatabaseConfiguration>(TypeInformation.get(IRuntimeDatabaseConfiguration.class), "RuntimeDatabaseConfiguration", e);
    }
    
}
