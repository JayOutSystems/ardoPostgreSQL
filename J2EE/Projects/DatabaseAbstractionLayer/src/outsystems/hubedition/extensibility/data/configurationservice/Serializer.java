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
import linqbridge.xml.linq.XAttribute;
import linqbridge.xml.linq.XElement;
import outsystems.hubedition.extensibility.data.configurationservice.metaconfiguration.IParameter;
import outsystems.runtimecommon.CollectionsExtensions;


public final class Serializer<TConfiguration> implements IGenericObject {
    private Func.Func1_Lambda<String, String> _valueEncrypter;
    
    public final Func.Func1_Lambda<String, String> getValueEncrypter()
    {
        return _valueEncrypter;
    }
    
    public final void setValueEncrypter(Func.Func1_Lambda<String, String> value)
    {
        _valueEncrypter = value;
    }
    
    private String tag;
    private Func.Func1_Lambda<TConfiguration, Iterable<IParameter>> parameterExtractor;
    
    public Serializer(final TypeInformation<TConfiguration> classTypeArg_TConfiguration, String tag, Func.Func1_Lambda<TConfiguration, Iterable<IParameter>> parameterExtractor){
        staticInitSerializer(classTypeArg_TConfiguration);
        instanceInitSerializer(classTypeArg_TConfiguration);
        this.tag = tag;
        this.parameterExtractor = parameterExtractor;
        this.setValueEncrypter( null );
    }
    
    public final XElement serialize(TConfiguration conf) {
        final XElement res = new XElement(XName.op_Implicit(tag));
        CollectionsExtensions.apply(TypeInformation.get(XElement.class), LinqMethods.select(parameterExtractor.execute(conf),
            (IParameter p) -> {
                boolean encrypt = getValueEncrypter() != null && p.isEncrypt();
                if (encrypt)
                {
                    return new XElement(XName.op_Implicit(p.getName()),
                        getValueEncrypter().execute(p.get()),
                        new XAttribute(XName.op_Implicit("encrypted"), "true"));
                }
                else
                {
                    return new XElement(XName.op_Implicit(p.getName()),
                        p.get(),
                        new XAttribute(XName.op_Implicit("encrypted"), "false"));
                }
            }),
            
                new Action.Action1<XElement>() {
                    protected void executeImpl(XElement obj) throws Exception {
                        res.add(obj);
                    }
                });
        return res;
    }
    
    public TypeInformation<?> getTypeInformation() {
        return TypeInformation.<Serializer<TConfiguration>>get(Serializer.class, classTypeArg_TConfiguration);
    }
    
    private final void instanceInitSerializer(final TypeInformation<TConfiguration> classTypeArg_TConfiguration) {
        this.classTypeArg_TConfiguration = classTypeArg_TConfiguration;
    }
    protected static <TConfiguration> void staticInitSerializer(final TypeInformation<TConfiguration> classTypeArg_TConfiguration) {
    }
    protected TypeInformation<TConfiguration> classTypeArg_TConfiguration;
}
