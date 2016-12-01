/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.configurationservice;

import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import java.math.BigDecimal;

public class AdvancedConfiguration {
    private String _advancedConnectionStringField;
    public static final TypeInformation<AdvancedConfiguration> TypeInfo = TypeInformation.get(AdvancedConfiguration.class);
    
    private String advancedConnectionStringFieldHelp;
    private String advancedConnectionStringFieldLabel = "Connection String Parameters";
    private String connectionStringTemplateExpression;
    
    public AdvancedConfiguration(String advancedConnectionStringFieldHelp, String advancedConnectionStringFieldLabel, String connectionStringTemplateExpression){
        this.advancedConnectionStringFieldHelp = advancedConnectionStringFieldHelp;
        if (!StringUtils.equals(advancedConnectionStringFieldLabel, null))
        {
            this.advancedConnectionStringFieldLabel = advancedConnectionStringFieldLabel;
        }
        this.connectionStringTemplateExpression = connectionStringTemplateExpression;
    }
    
    /**
	 *	Returns true if connection string advanced parameters are set.
	 *	@return	True if the advanced parameters are set, False otherwise.
	 */
    public final boolean isSet() {
        return !StringUtils.equals(getAdvancedConnectionStringField(), null);
    }
    
    /**
	 *	This property represents the field that will store connection string advanced parameters. This field is displayed when defining an advanced database connection.
	 *	@return	The advanced connection string.
	 */
    public final String getAdvancedConnectionStringField()
    {
        return _advancedConnectionStringField;
    }
    
    /**
	 *	This property represents the field that will store connection string advanced parameters. This field is displayed when defining an advanced database connection.
	 *	@param	value	The advanced connection string.
	 */
    public final void setAdvancedConnectionStringField(String value)
    {
        _advancedConnectionStringField = value;
    }
    
    /**
	 *	Help text that is displayed next to the advanced connection string parameters field in the user interface. This text should provide information regarding the format of the configuration parameters and examples on how to define them.
	 *	@return	A help message to display in the user interface.
	 */
    public final String getAdvancedConnectionStringFieldHelp()
    {
        return advancedConnectionStringFieldHelp;
    }
    
    /**
	 *	Gets the label text to display in the user interface for the connection string advanced parameters field.
	 *	@return	The label to display in the user interface.
	 */
    public final String getAdvancedConnectionStringFieldLabel()
    {
        return advancedConnectionStringFieldLabel;
    }
    
    /**
	 *	Gets an expression that assists on creating a preview of the resulting connection string in the user interface. This expression should be a string that contains tokens that match the name of the AdvancedConnectionStringField property as well as additional configuration parameters that belong to the &#39;UserSpecific&#39; region. A typical use for this expression is to hide sensitive information like passwords. In the following example, the value for the &#39;Username&#39; and the &#39;AdvancedConnectionStringField&#39; parameters, set by the user, will replace the corresponding tokens. This allows the user interface to be updated with these values without disclosing the value of the password field showing an hard-coded value, in this case &#39;&lt;hidden&gt;&#39;. Example: [user id=$Username;password=&lt;hidden&gt;;]$AdvancedConnectionStringField&quot;
	 *	@return	An expression that creates a preview of the resulting connection string.
	 */
    public final String getConnectionStringTemplateExpression()
    {
        return connectionStringTemplateExpression;
    }
    
}