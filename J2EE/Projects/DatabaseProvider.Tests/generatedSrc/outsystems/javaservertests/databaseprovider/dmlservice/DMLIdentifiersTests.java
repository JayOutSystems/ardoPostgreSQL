/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.javaservertests.databaseprovider.dmlservice;

import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.dmlservice.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.servertests.databaseprovider.framework.*;
import java.math.BigDecimal;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLIdentifiers;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLService;
import outsystems.hubedition.extensibility.data.executionservice.IExecutionService;
import outsystems.hubedition.extensibility.data.IDatabaseServices;
import outsystems.junit.framework.DashboardTestFixture;
import outsystems.junit.framework.IterativeTestCase;
import outsystems.junit.framework.TestDetails;
import outsystems.servertests.databaseprovider.framework.BaseDatabaseProviderTest;
import outsystems.servertests.databaseprovider.framework.DashboardTest;
import outsystems.servertests.databaseprovider.framework.DatabaseProviderTestCase;



@org.junit.runner.RunWith(outsystems.junit.logic.DashboardTestRunner.class)
@DashboardTestFixture(testKind=DashboardTest.DashboardTestKind)
public class DMLIdentifiersTests extends DMLTest {
    public static final TypeInformation<DMLIdentifiersTests> TypeInfo = TypeInformation.get(DMLIdentifiersTests.class);
    
    @IterativeTestCase(iteratorType=DMLTestsConfiguration.class)
    public final void testEscapeIdentifier(DatabaseProviderTestCase tc) throws Exception {
        IDatabaseServices databaseServices = tc.getServices();
        SQLExecutor sqlExecutor = new SQLExecutor(databaseServices);
        IDMLIdentifiers dmlIdentifiers = databaseServices.getDMLService().getIdentifiers();
        
        String sql = "SELECT " + dmlIdentifiers.escapeIdentifier("DUMMY") + "." + dmlIdentifiers.escapeIdentifier("SELECT") + " FROM " + dmlIdentifiers.escapeIdentifier("DUMMY");
        int value = sqlExecutor.executeScalar(sql).runtimeValue(TypeInformation.Integer).intValue();
        assertEqual(Integer.valueOf(123), Integer.valueOf(value), "Escape function didn't work as expected. SQL: " + sql);
    }
    
    
    @IterativeTestCase(iteratorType=DMLTestsConfiguration.class)
    public final void testGetValidIdentifier(DatabaseProviderTestCase tc) throws Exception {
        IDatabaseServices databaseServices = tc.getServices();
        SQLExecutor sqlExecutor = new SQLExecutor(databaseServices);
        IDMLIdentifiers dmlIdentifiers = databaseServices.getDMLService().getIdentifiers();
        final RefParmHolder<String> paramPrefix = new RefParmHolder<String>(databaseServices.getExecutionService().getParameterPrefix());
        String param = "";
        for( int i = 0; i < dmlIdentifiers.getMaxLength() - 1; i++)
        {
            param += "m";
        }
        final RefParmHolder<String> paramName = new RefParmHolder<String>(dmlIdentifiers.getValidIdentifier("inparam" + param, true));
        String parameterForSQL = paramPrefix.getVal() + paramName.getVal();
        String sql = "SELECT " + parameterForSQL + " FROM DUMMY";
        
        int value = sqlExecutor.executeScalar(sql, 
            new Func.Func2<Integer, Class<?>, String>() {
                protected String executeImpl(Integer i, Class<?> t) throws Exception
                {
                    return paramPrefix.getVal() + paramName.getVal();
                }
            }, Integer.valueOf(1)).runtimeValue(TypeInformation.Integer).intValue();
        assertEqual(Integer.valueOf(1), Integer.valueOf(value), "GetValidIdentifier didn't work as expected. SQL: " + sql);
    }
    
}