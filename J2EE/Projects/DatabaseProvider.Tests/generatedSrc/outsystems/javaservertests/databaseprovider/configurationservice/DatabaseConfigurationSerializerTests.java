/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.javaservertests.databaseprovider.configurationservice;

import java.io.*;
import java.text.*;
import java.util.*;
import org.junit.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.configurationservice.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import outsystems.servertests.databaseprovider.framework.*;
import java.math.BigDecimal;
import java.util.Map;
import outsystems.hubedition.extensibility.data.BaseDatabaseProvider;
import outsystems.hubedition.extensibility.data.configurationservice.AdvancedConfiguration;
import outsystems.hubedition.extensibility.data.configurationservice.ConfigurationSerializationException;
import outsystems.hubedition.extensibility.data.configurationservice.Deserializers;
import outsystems.hubedition.extensibility.data.configurationservice.IIntegrationDatabaseConfiguration;
import outsystems.hubedition.extensibility.data.configurationservice.IntegrationDeserializer;
import outsystems.hubedition.extensibility.data.configurationservice.IntegrationSerializer;
import outsystems.hubedition.extensibility.data.configurationservice.IRuntimeDatabaseConfiguration;
import outsystems.hubedition.extensibility.data.configurationservice.Serializers;
import outsystems.hubedition.extensibility.data.IDatabaseProvider;
import outsystems.hubedition.extensibility.data.IDatabaseServices;
import outsystems.hubedition.extensibility.data.IProviderProperties;
import outsystems.junit.framework.DashboardTestFixture;
import outsystems.junit.framework.JUnitTestAdapter;
import outsystems.junit.framework.TestDetails;
import outsystems.runtimecommon.DatabaseProviderKey;
import outsystems.servertests.databaseprovider.framework.DashboardTest;
import outsystems.testscommon.AssertUtils;
import outsystems.testscommon.StringAssert;



@org.junit.runner.RunWith(outsystems.junit.logic.DashboardTestRunner.class)
@DashboardTestFixture(testKind=DashboardTest.DashboardTestKind)
public class DatabaseConfigurationSerializerTests extends DashboardTest {
    public static final TypeInformation<DatabaseConfigurationSerializerTests> TypeInfo = TypeInformation.get(DatabaseConfigurationSerializerTests.class);
    
    public static enum DirectionsEnum implements IEnum {
        Up,
        Down,
        Left,
        Right;
        
        public static final TypeInformation<DirectionsEnum> TypeInfo = TypeInformation.get(DirectionsEnum.class);
        public int getIntValue() {
            return ordinal();
        }
        
        public static String[] names() {
            return EnumUtils.getNames(values());
        }
        
        public static DirectionsEnum getDefaultValue() {
            return Up;
        }
        
        private static Map<Integer, DirectionsEnum> intToEnum;
        private static Map<Integer, DirectionsEnum> getIntToEnum() {
            if (intToEnum == null) {
                intToEnum = EnumUtils.getIntToEnumValueMap(values());
            }
            return intToEnum;
        }
        
        private static Map<String, DirectionsEnum> lowerCaseNameToEnum;
        private static Map<String, DirectionsEnum> getLowerCaseNameToEnum() {
            if (lowerCaseNameToEnum == null) {
                lowerCaseNameToEnum = EnumUtils.getNameToEnumValueMap(values(), /*lowerCase*/true);
            }
            return lowerCaseNameToEnum;
        }
        
        private static Map<String, DirectionsEnum> nameToEnum;
        private static Map<String, DirectionsEnum> getNameToEnum() {
            if (nameToEnum == null) {
                nameToEnum = EnumUtils.getNameToEnumValueMap(values(), /*lowerCase*/false);
            }
            return nameToEnum;
        }
        
        public static DirectionsEnum valueOf(int value) {
            DirectionsEnum result = getIntToEnum().get(value);
            if (result == null) {
                throw new IllegalArgumentException("No enum const class DirectionsEnum with int value " + value);
            }
            return result;
        }
        
        
        public static DirectionsEnum valueOf(String value, boolean ignoreCase) {
            if (!ignoreCase) {
                return valueOf(value);
            }
            DirectionsEnum result = getLowerCaseNameToEnum().get(value.toLowerCase());
            if (result == null) {
                throw new IllegalArgumentException("No enum const class DirectionsEnum." + value);
            }
            return result;
        }
        
        
        public static boolean isDefined(String value) {
            return getNameToEnum().containsKey(value);
        }
        
        public static boolean isDefined(int value) {
            return getIntToEnum().containsKey(value);
        }
    }
    
    private static class MockDatabaseProvider extends BaseDatabaseProvider {
        public static final TypeInformation<MockDatabaseProvider> TypeInfo = TypeInformation.get(MockDatabaseProvider.class);
        
        public IIntegrationDatabaseConfiguration createEmptyIntegrationDatabaseConfiguration() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        
        public IDatabaseServices getIntegrationDatabaseServices(IRuntimeDatabaseConfiguration databaseConfiguration) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        
        public DatabaseProviderKey getKey()
        {
            return DatabaseProviderKey.deserialize("Oracle");
        }
        
        public IProviderProperties getProperties() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }
    }
    
    public static class MockDatabaseConfiguration implements IIntegrationDatabaseConfiguration {
        private String _mockText;
        private String _mockText2;
        private int _mockInt;
        private boolean _mockBool;
        private DirectionsEnum _mockEnum;
        private String _connectionStringOverride;
        private String _databaseIdentifier;
        public static final TypeInformation<MockDatabaseConfiguration> TypeInfo = TypeInformation.get(MockDatabaseConfiguration.class);
        
        private static final String INVISIBLE_TEXT_VALUE = "Invisibile";
        
        @UserDefinedConfigurationParameter(label="MockText", region=ParameterRegion.DatabaseLocation, prompt="MockText_Prompt", order=0, isMandatory=false, isPassword=true, visibilityChecker="IsTextVisible")
        public final String getMockText()
        {
            return _mockText;
        }
        
        @UserDefinedConfigurationParameter(label="MockText", region=ParameterRegion.DatabaseLocation, prompt="MockText_Prompt", order=0, isMandatory=false, isPassword=true, visibilityChecker="IsTextVisible")
        public final void setMockText(String value)
        {
            _mockText = value;
        }
        
        @UserDefinedConfigurationParameter(label="MockText2", region=ParameterRegion.DatabaseLocation, prompt="MockText2_Prompt", order=1, isMandatory=true, isPassword=false)
        public final String getMockText2()
        {
            return _mockText2;
        }
        
        @UserDefinedConfigurationParameter(label="MockText2", region=ParameterRegion.DatabaseLocation, prompt="MockText2_Prompt", order=1, isMandatory=true, isPassword=false)
        public final void setMockText2(String value)
        {
            _mockText2 = value;
        }
        
        @UserDefinedConfigurationParameter(label="MockInt", region=ParameterRegion.UserSpecific, prompt="MockInt_Prompt", order=1, isMandatory=true, example="MockInt_Example")
        public final int getMockInt()
        {
            return _mockInt;
        }
        
        @UserDefinedConfigurationParameter(label="MockInt", region=ParameterRegion.UserSpecific, prompt="MockInt_Prompt", order=1, isMandatory=true, example="MockInt_Example")
        public final void setMockInt(int value)
        {
            _mockInt = value;
        }
        
        @UserDefinedConfigurationParameter(label="MockBool", region=ParameterRegion.UserAdminSpecific, prompt="MockBool_Prompt", order=2, example="MockBool_Example")
        public final boolean isMockBool()
        {
            return _mockBool;
        }
        
        @UserDefinedConfigurationParameter(label="MockBool", region=ParameterRegion.UserAdminSpecific, prompt="MockBool_Prompt", order=2, example="MockBool_Example")
        public final void setMockBool(boolean value)
        {
            _mockBool = value;
        }
        
        @UserDefinedConfigurationParameter(label="MockEnum", region=ParameterRegion.Advanced, prompt="MockEnum_Prompt", order=3, example="MockEnum_Example")
        public final DirectionsEnum getMockEnum()
        {
            return _mockEnum;
        }
        
        @UserDefinedConfigurationParameter(label="MockEnum", region=ParameterRegion.Advanced, prompt="MockEnum_Prompt", order=3, example="MockEnum_Example")
        public final void setMockEnum(DirectionsEnum value)
        {
            _mockEnum = value;
        }
        
        public final boolean isTextVisible() {
            return StringUtils.equals(getMockText(), null) || !getMockText().equals(INVISIBLE_TEXT_VALUE);
        }
        
        public final IDatabaseProvider getDatabaseProvider()
        {
            return new MockDatabaseProvider();
        }
        
        public final String getConnectionString()
        {
            return "iamaconnectionstring" + getAdvancedConfiguration().getAdvancedConnectionStringField();
        }
        
        @ConfigurationParameter
        public final String getConnectionStringOverride()
        {
            return _connectionStringOverride;
        }
        
        @ConfigurationParameter
        public final void setConnectionStringOverride(String value)
        {
            _connectionStringOverride = value;
        }
        
        public final String getDatabaseIdentifier()
        {
            return _databaseIdentifier;
        }
        
        public final void setDatabaseIdentifier(String value)
        {
            _databaseIdentifier = value;
        }
        
        private AdvancedConfiguration advancedConfiguration = new AdvancedConfiguration("", null, null);
        
        public final AdvancedConfiguration getAdvancedConfiguration()
        {
            return advancedConfiguration;
        }
        
        public final void setAdvancedConfiguration(AdvancedConfiguration value)
        {
            advancedConfiguration = value;
        }
        
        
        public final IRuntimeDatabaseConfiguration getRuntimeDatabaseConfiguration()
        {
            return null;
        }
    }
    
    @Test
    @TestDetails(Description="Checks that visible parameters are serialized", CreatedBy="rcn", Feature="Database Abstraction Layer", TestIssue="613292")
    public final void visibleParametersAreSerialized() throws ConfigurationSerializationException {
        
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        mockDB.setMockText2( "testing" );
        
        String serialized = Serializers.getForIntegration().serialize(mockDB);
        
        StringAssert.contains("MockText2>testing", serialized);
    }
    
    
    @Test
    @TestDetails(Description="Checks that extra parameters are serialized", CreatedBy="rcn", Feature="Database Abstraction Layer", TestIssue="613292")
    public final void nonUserDefinedParametersAreSerialized() throws ConfigurationSerializationException {
        
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        mockDB.getAdvancedConfiguration().setAdvancedConnectionStringField( "advancedconnectionstringvalue" );
        mockDB.setConnectionStringOverride( "override" );
        String serialized = Serializers.getForIntegration().serialize(mockDB);
        
        StringAssert.contains("ConnectionStringOverride>override", serialized);
        StringAssert.contains("AdvancedConnectionStringField>advancedconnectionstringvalue", serialized);
    }
    
    
    @Test
    @TestDetails(Description="Checks that null parameters are serialized as empty strings", CreatedBy="rcn", Feature="Database Abstraction Layer", TestIssue="613292")
    public final void nullParametersAreSerializedWithEmptyStringValue() throws ConfigurationSerializationException {
        
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        String serialized = Serializers.getForIntegration().serialize(mockDB);
        
        StringAssert.contains("<MockText2></MockText2>", serialized);
    }
    
    
    @Test
    @TestDetails(Description="Test that fields can be multiline - serialize", CreatedBy="lfl", Feature="Database Abstraction Layer", TestIssue="609920")
    public final void serializeMultiline() throws ConfigurationSerializationException, IOException {
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        mockDB.setMockText( "Multi\nLine\nText!" );
        String serialized = Serializers.getForIntegration().serialize(mockDB);
        
        // platform agnostic newline
        StringWriter writer = new StringWriter();
        StreamUtils.writeLine(writer, "MockText>Multi");
        StreamUtils.writeLine(writer, "Line");
        writer.write("Text!");
        
        StringAssert.contains(writer.toString(), serialized);
    }
    
    
    @Test
    @TestDetails(Description="Missing parameters don't set object values", CreatedBy="rcn", Feature="Database Abstraction Layer", TestIssue="613292")
    public final void missingParametersDontSetObjectValues() throws ConfigurationSerializationException {
        String serialized = "<DBConfiguration></DBConfiguration>";
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        Deserializers.getForIntegration().deserialize(serialized, mockDB);
        
        Assert.assertNull(mockDB.getMockText2());
    }
    
    
    @Test
    @TestDetails(Description="Check if we don't throw an exception when a serialization containning a non-existant parameter is given.", CreatedBy="rcn", Feature="Database Abstraction Layer", TestIssue="613292")
    public final void nonExistantParameterDontThrowException() throws ConfigurationSerializationException {
        String serialized = "<DBConfiguration>\r\n" +
            "  <NonExistantParameter>asdasdamsd</NonExistantParameter>\r\n" +
            "</DBConfiguration>";
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        Deserializers.getForIntegration().deserialize(serialized, mockDB);
    }
    
    
    @Test
    @TestDetails(Description="Checks if existing parameters are set after deserialization", CreatedBy="rcn", Feature="Database Abstraction Layer", TestIssue="613292")
    public final void checkIfExistingParameterIsSetAfterDeserialization() throws ConfigurationSerializationException {
        String serialized = "<DBConfiguration>\r\n" +
            "  <MockText>loasdasd</MockText>\r\n" +
            "</DBConfiguration>";
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        Deserializers.getForIntegration().deserialize(serialized, mockDB);
        
        Assert.assertEquals((Object) ("loasdasd"), (Object) (mockDB.getMockText()));
    }
    
    
    @Test(expected=ConfigurationSerializationException.class)
    @TestDetails(Description="Sanity Check, invalid configuration will fail with correct Exception", CreatedBy="lfl", Feature="Database Abstraction Layer", TestIssue="609920")
    public final void checkInvalidConfigurationGivesError() throws ConfigurationSerializationException {
        String serialized = "invalidConfig";
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        Deserializers.getForIntegration().deserialize(serialized, mockDB);
    }
    
    
    @Test
    @TestDetails(Description="Test that fields can be multiline - deserialize", CreatedBy="lfl", Feature="Database Abstraction Layer", TestIssue="609920")
    public final void deserializeMultiline() throws ConfigurationSerializationException {
        String serialized = "<DBConfiguration>\r\n" +
            "  <MockText>I'm a multiline\r\n" +
            "value\r\n" +
            "with 3 lines!!!</MockText>\r\n" +
            "</DBConfiguration>";
        MockDatabaseConfiguration mockDB = new MockDatabaseConfiguration();
        Deserializers.getForIntegration().deserialize(serialized, mockDB);
        
        Assert.assertEquals((Object) ("I'm a multiline\nvalue\nwith 3 lines!!!"), (Object) (mockDB.getMockText()));
    }
    
    
}
