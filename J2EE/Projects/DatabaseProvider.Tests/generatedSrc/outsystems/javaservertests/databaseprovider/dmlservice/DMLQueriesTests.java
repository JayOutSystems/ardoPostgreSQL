/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.javaservertests.databaseprovider.dmlservice;

import java.sql.*;
import java.text.*;
import java.util.*;
import org.junit.*;
import outsystems.hubedition.extensibility.data.dmlservice.dmlplaceholders.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.servertests.databaseprovider.framework.*;
import java.math.BigDecimal;
import outsystems.hubedition.extensibility.data.dmlservice.dmlplaceholders.DMLPlaceholderExtensions;
import outsystems.hubedition.extensibility.data.dmlservice.dmlplaceholders.SelectPlaceholder;
import outsystems.hubedition.extensibility.data.dmlservice.dmlplaceholders.StatementPlaceholder;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLOperators;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLQueries;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLService;
import outsystems.hubedition.extensibility.data.IDatabaseServices;
import outsystems.junit.framework.DashboardTestFixture;
import outsystems.junit.framework.IterativeTestCase;
import outsystems.junit.framework.TestDetails;
import outsystems.servertests.databaseprovider.framework.BaseDatabaseProviderTest;
import outsystems.servertests.databaseprovider.framework.DashboardTest;
import outsystems.servertests.databaseprovider.framework.DatabaseProviderTestCase;



@org.junit.runner.RunWith(outsystems.junit.logic.DashboardTestRunner.class)
@DashboardTestFixture(testKind=DashboardTest.DashboardTestKind)
public class DMLQueriesTests extends DMLTest {
    public static final TypeInformation<DMLQueriesTests> TypeInfo = TypeInformation.get(DMLQueriesTests.class);
    
    private static final String ERROR_MESSAGE_FORMAT = "Error executing {0} query with SQL: {1}";
    
    @IterativeTestCase(iteratorType=DMLTestsConfiguration.class)
    public final void testMaxRecords(DatabaseProviderTestCase tc) throws Exception {
        IDatabaseServices databaseServices = tc.getServices();
        SQLExecutor sqlExecutor = new SQLExecutor(databaseServices);
        
        final RefParmHolderInteger maxRecordsValue = new RefParmHolderInteger(1);
        Map<SelectPlaceholder, String> maxRecordsPlaceholders = databaseServices.getDMLService().getQueries().sQLPlaceholderValuesForMaxRecords(Integer.toString(maxRecordsValue.getVal()));
        String beforeStatement = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.BeforeStatement);
        String afterSelect = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.AfterSelectKeyword);
        String beforeFrom = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.BeforeFromKeyword);
        String afterFrom = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.AfterFromKeyword);
        String beforeWhere = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.BeforeWhereKeyword);
        String afterWhere = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.AfterWhereKeyword);
        String beforeGroupBy = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.BeforeGroupByKeyword);
        String afterGroupBy = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.AfterGroupByKeyword);
        String beforeHaving = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.BeforeHavingKeyword);
        String afterHaving = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.AfterHavingKeyword);
        String beforeOrderBy = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.BeforeOrderByKeyword);
        String afterOrderBy = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.AfterOrderByKeyword);
        String afterStatement = DMLPlaceholderExtensions.getPlaceholderValueTrimEnd(SelectPlaceholder.TypeInfo, maxRecordsPlaceholders, SelectPlaceholder.AfterStatement);
        
        final RefParmHolder<String> sql = new RefParmHolder<String>(beforeStatement + 
            "SELECT " + 
            afterSelect + 
            "NAME " + 
            beforeFrom + 
            "FROM " + 
            afterFrom + 
            "PERSON " + 
            beforeWhere + 
            "WHERE " + 
            afterWhere + 
            databaseServices.getDMLService().getOperators().equal("1", "1") + 
            " " + 
            beforeGroupBy + 
            "GROUP BY " + 
            afterGroupBy + 
            "NAME " + 
            beforeHaving + 
            "HAVING " + 
            afterHaving + 
            databaseServices.getDMLService().getOperators().equal("1", "1") + 
            " " + 
            beforeOrderBy + 
            "ORDER BY " + 
            afterOrderBy + 
            "NAME " + 
            afterStatement);
        
        sqlExecutor.executeReader(sql.getVal(), 
            new Action.Action1<OSResultSet>() {
                protected void executeImpl(OSResultSet reader) throws Exception
                {
                    int count = 0;
                    while (reader.next())
                    {
                        count++;
                    }
                    assertEqual(Integer.valueOf(maxRecordsValue.getVal()), Integer.valueOf(count), StringUtils.format(ERROR_MESSAGE_FORMAT, new Object[] {"MaxRecords", sql.getVal()}));
                }
            });
    }
    
    
    @IterativeTestCase(iteratorType=DMLTestsConfiguration.class)
    public final void testCount(DatabaseProviderTestCase tc) throws Exception {
        IDatabaseServices databaseServices = tc.getServices();
        SQLExecutor sqlExecutor = new SQLExecutor(databaseServices);
        
        Map<StatementPlaceholder, String> countPlaceholders = databaseServices.getDMLService().getQueries().sQLPlaceholderValuesForCountQuery();
        String beforeStatement = DMLPlaceholderExtensions.getPlaceholderValueTrimStart(StatementPlaceholder.TypeInfo, countPlaceholders, StatementPlaceholder.BeforeStatement);
        String afterStatement = DMLPlaceholderExtensions.getPlaceholderValueTrimEnd(StatementPlaceholder.TypeInfo, countPlaceholders, StatementPlaceholder.AfterStatement);
        
        String sql = beforeStatement + "SELECT NAME FROM PERSON WHERE " + databaseServices.getDMLService().getOperators().equal("1", "1") + afterStatement;
        
        int count = sqlExecutor.executeScalar(sql).runtimeValue(TypeInformation.Integer).intValue();
        assertEqual(Integer.valueOf(3), Integer.valueOf(count), StringUtils.format(ERROR_MESSAGE_FORMAT, new Object[] {"Count", sql}));
    }
    
    
}
