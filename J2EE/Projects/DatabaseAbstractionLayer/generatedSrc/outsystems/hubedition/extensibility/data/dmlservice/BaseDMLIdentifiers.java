/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.dmlservice;

import java.nio.*;
import java.nio.charset.*;
import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import java.math.BigDecimal;
import java.util.Random;



/**
 *	Implementation of the IDMLIdentifiers interface that defines methods that help build DML Identifiers for columns, tables, and others.
 */
public abstract class BaseDMLIdentifiers implements IDMLIdentifiers {
    private IDMLService _dMLService;
    public static final TypeInformation<BaseDMLIdentifiers> TypeInfo = TypeInformation.get(BaseDMLIdentifiers.class);
    
    private static final Random randomNumber = new Random();
    
    protected BaseDMLIdentifiers(IDMLService dmlService){
        setDMLService( dmlService );
    }
    
    /**
	 *	This property represents the associated IDMLService.
	 */
    public final IDMLService getDMLService()
    {
        return _dMLService;
    }
    
    /**
	 *	This property represents the associated IDMLService.
	 */
    private final void setDMLService(IDMLService value)
    {
        _dMLService = value;
    }
    
    /**
	 *	Gets the maximum length of a simple (not compound) identifier. This value should be the minimum valid length for any kind of identifier (e.g. table name, parameter name)
	 */
    public abstract int getMaxLength();
    
    /**
	 *	Escapes a simple (not compound) identifier to prevent name clashing with reserved words. The base implementation escapes the identifier using quotation marks, if it isn't already escaped.
	 *	@param	identifierName	Name that identifies a database object.
	 *	@return	An escaped identifier.
	 */
    public String escapeIdentifier(String identifierName) {
        return StringUtils.isNullOrEmpty(identifierName) ? "" : (identifierName.startsWith("\"") ? "" : "\"") + "" + identifierName + "" + (identifierName.endsWith("\"") ? "" : "\"");
    }
    
    /**
	 *	Returns a name that can be used as a valid identifier (e.g. parameter name, constraint name). It should contain only valid characters and its length should not exceed the maximum defined in MaxLength. This implementation escapes the baseName to contain only alphanumeric and '_' characters. If the baseName exceeds the maximum length, the baseName is truncated and the last five characters are replaced by random numbers.
	 *	@param	baseName	An identifier name.
	 *	@param	truncateUsingRandomDigits	Indicates if the identifier should be truncated if its length exceeds the MaxLength. In this case,  random digitis should be used as a suffix to prevent name clashing.
	 *	@return	A string representing a valid identifier.
	 */
    public String getValidIdentifier(String baseName, boolean truncateUsingRandomDigits) {
        // We need to replace invalid characters to create a valid constraint name (#23805)
        int len = baseName.length();
        StringBuilder escapedBaseName = new StringBuilder(len);
        
        for( int i = 0; i < len; i++)
        {
            char identifier = baseName.charAt(i);
            // We assume the valid constrain names are letters, digits or _
            if (Character.isLetterOrDigit(identifier) || (identifier == '_'))
            {
                escapedBaseName.append(identifier);
            }
            else
            {
                escapedBaseName.append('_');
            }
        }
        
        if (!truncateUsingRandomDigits || escapedBaseName.length() <= getMaxLength())
        {
            return escapedBaseName.toString();
        }
        escapedBaseName.setLength( Math.max(0, getMaxLength() - 5) );
        return escapedBaseName.append(StringUtils.format("{0:00000}", new Object[] {Integer.valueOf(randomNumber.nextInt(99999))})).toString();
    }
}
