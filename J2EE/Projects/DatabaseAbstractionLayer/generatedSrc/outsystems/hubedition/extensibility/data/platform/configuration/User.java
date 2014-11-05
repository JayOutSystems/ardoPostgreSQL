/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.platform.configuration;

import java.net.*;
import java.text.*;
import java.util.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.configurationservice.*;
import outsystems.hubedition.extensibility.data.platform.*;
import outsystems.hubedition.http.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import java.math.BigDecimal;
import java.util.Map;

public enum User implements IEnum {
    Admin,
    Runtime,
    Session,
    Log;
    
    public static final TypeInformation<User> TypeInfo = TypeInformation.get(User.class);
    public int getIntValue() {
        return ordinal();
    }
    
    public static String[] names() {
        return EnumUtils.getNames(values());
    }
    
    public static User getDefaultValue() {
        return Admin;
    }
    
    private static Map<Integer, User> intToEnum;
    private static Map<Integer, User> getIntToEnum() {
        if (intToEnum == null) {
            intToEnum = EnumUtils.getIntToEnumValueMap(values());
        }
        return intToEnum;
    }
    
    private static Map<String, User> lowerCaseNameToEnum;
    private static Map<String, User> getLowerCaseNameToEnum() {
        if (lowerCaseNameToEnum == null) {
            lowerCaseNameToEnum = EnumUtils.getNameToEnumValueMap(values(), /*lowerCase*/true);
        }
        return lowerCaseNameToEnum;
    }
    
    private static Map<String, User> nameToEnum;
    private static Map<String, User> getNameToEnum() {
        if (nameToEnum == null) {
            nameToEnum = EnumUtils.getNameToEnumValueMap(values(), /*lowerCase*/false);
        }
        return nameToEnum;
    }
    
    public static User valueOf(int value) {
        User result = getIntToEnum().get(value);
        if (result == null) {
            throw new IllegalArgumentException("No enum const class User with int value " + value);
        }
        return result;
    }
    
    
    public static User valueOf(String value, boolean ignoreCase) {
        if (!ignoreCase) {
            return valueOf(value);
        }
        User result = getLowerCaseNameToEnum().get(value.toLowerCase());
        if (result == null) {
            throw new IllegalArgumentException("No enum const class User." + value);
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
