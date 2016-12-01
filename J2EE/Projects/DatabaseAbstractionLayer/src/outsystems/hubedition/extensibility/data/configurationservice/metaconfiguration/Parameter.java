/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.configurationservice.metaconfiguration;

import java.lang.reflect.*;
import java.net.*;
import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.configurationservice.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Map;


/**
 *	Class that represents a parameter inside a database configuration.
 */
public class Parameter implements IParameter {
    public static final TypeInformation<Parameter> TypeInfo = TypeInformation.get(Parameter.class);
    
    private static class Converter {
        public static final TypeInformation<Converter> TypeInfo = TypeInformation.get(Converter.class);
        
        private Class<?> t;
        
        public Converter(Class<?> t){
            this.t = t;
        }
        
        public final String toString(Object value) {
            if (value instanceof Boolean)
            {
                return value.toString().toLowerCase(java.util.Locale.ROOT);
            }
            else if (value.getClass().isEnum())
            {
                String enumWithUnderscores = value.toString();
                return enumWithUnderscores.replace('_', ' ');
            }
            return value.toString();
        }
        
        public final Object fromString(String value) {
            if (t.isEnum())
            {
                if (StringUtils.equals(value, ""))
                {
                    return EnumUtils.getValues(t)[0];
                }
                else
                {
                    return EnumUtils.parse(TypeInformation.get(t), value.replace(' ', '_'));
                }
            }
            if (ClassUtils.areSameClass(t, boolean.class))
            {
                return Boolean.valueOf(!StringUtils.equals(value, "") && Boolean.valueOf(value).booleanValue());
            }
            if (ClassUtils.areSameClass(t, String.class))
            {
                return value;
            }
            if (ClassUtils.areSameClass(t, int.class))
            {
                return Integer.valueOf(StringUtils.equals(value, "") ? 0 : ConvertUtils.toInt(value));
            }
            throw new IllegalStateException("Unsuported convertion for type " + t);
        }
    }
    
    private String name;
    private Method getter;
    private Method setter;
    private Converter converter;
    
    private Object config;
    private boolean encrypt;
    private boolean persist;
    
    /**
	 *	Creates a new Parameter.
	 *	@param	name	The parameter&#39;s name.
	 *	@param	getter	Method to get the value of the parameter.
	 *	@param	setter	Method to set the value of the parameter.
	 *	@param	encrypt	Indicates if the parameter is encrypted.
	 *	@param	persist	Indicates if the parameter should be persisted.
	 *	@param	config	The database configuration.
	 */
    public Parameter(String name, Method getter, Method setter, boolean encrypt, boolean persist, Object config){
        this.name = name;
        this.getter = getter;
        this.setter = setter;
        this.config = config;
        this.encrypt = encrypt;
        this.persist = persist;
        converter = new Converter(getter.getReturnType());
    }
    
    /**
	 *	Gets the parameter&#39;s type.
	 *	@return	The parameter&#39;s type.
	 */
    public final Class<?> getType()
    {
        return getter.getReturnType();
    }
    
    /**
	 *	Gets the parameter&#39;s name.
	 *	@return	The parameter&#39;s name.
	 */
    public final String getName()
    {
        return name;
    }
    
    /**
	 *	Sets the parameter with a given value.
	 *	@param	stringifiedValue	The value as a string to be set as a parameter&#39;s value.
	 *	@throws	ConfigurationReflectionException	Thrown when a reflection error related to configuration code occurs.
	 */
    public final void set(String stringifiedValue) {
        try {
            Object value = converter.fromString(stringifiedValue);
            setter.invoke(config, new Object[] { value });
        }catch (Exception exceptionToHandle) {
            exceptionToHandle = WrappedException.unwrapExceptionIfNeeded(exceptionToHandle);
            
            {
                Exception e = (Exception)exceptionToHandle;
                throw new ConfigurationReflectionException(e);
            }
        }
    }
    
    
    /**
	 *	Gets the parameter&#39;s value.
	 *	@return	A string representing the value. An empty string is returned if the parameter&#39;s value is null.
	 *	@throws	ConfigurationReflectionException	Thrown when a reflection error related to configuration code occurs.
	 */
    public final String get() {
        try {
            Object value = getter.invoke(config, (Object[]) null);
            return converter.toString((value != null? value : ""));
        }catch (Exception exceptionToHandle) {
            exceptionToHandle = WrappedException.unwrapExceptionIfNeeded(exceptionToHandle);
            
            {
                Exception e = (Exception)exceptionToHandle;
                throw new ConfigurationReflectionException(e);
            }
        }
    }
    
    
    
    /**
	 *	This property indicates whether this object is read-only.
	 *	@return	True if this object is read-only, false if not.
	 */
    public final boolean isReadOnly()
    {
        return setter == null;
    }
    
    
    public final boolean isEncrypt()
    {
        return encrypt;
    }
    
    public final boolean isPersist()
    {
        return persist;
    }
}