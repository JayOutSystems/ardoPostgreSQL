/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.platform.introspectionservice;

import java.text.*;
import java.util.*;
import linqbridge.linq.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.databaseobjects.*;
import outsystems.hubedition.extensibility.data.platform.*;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import java.math.BigDecimal;
import linqbridge.linq.LinqMethods;
import outsystems.hubedition.extensibility.data.databaseobjects.ITableSourceInfo;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.IPlatformTableSourceInfo;
import outsystems.runtimecommon.CollectionsExtensions;


public class PlatformIntrospectionServiceExtensions {
    public static final TypeInformation<PlatformIntrospectionServiceExtensions> TypeInfo = TypeInformation.get(PlatformIntrospectionServiceExtensions.class);
    public static Iterable<IPlatformTableSourceColumnInfo> getPlatformTableSourceColumns(IPlatformIntrospectionService platformIntrospectionService, ITableSourceInfo tableSource) throws InvalidDatabaseObjectIdentifierException, java.sql.SQLException, outsystems.hubedition.extensibility.data.introspectionservice.IntrospectionServiceException {
        
        Map<ITableSourceInfo, IPlatformTableSourceInfo> result = platformIntrospectionService.getTableSourcesDetails(tableSource);
        return CollectionsExtensions.isEmpty(new MappedTypeInformation<Map.Entry<ITableSourceInfo, IPlatformTableSourceInfo>>(Map.Entry.class, 
	new Func.Func0<Map.Entry<ITableSourceInfo, IPlatformTableSourceInfo>>() {
    protected Map.Entry<ITableSourceInfo, IPlatformTableSourceInfo> executeImpl() {
	        return CollectionUtils.createMapEntry(TypeInformation.get(ITableSourceInfo.class), TypeInformation.get(IPlatformTableSourceInfo.class));
    }
    }, true), CollectionUtils.asCollection(result)) ? null : LinqMethods.first(new MappedTypeInformation<Map.Entry<ITableSourceInfo, IPlatformTableSourceInfo>>(Map.Entry.class, 
	new Func.Func0<Map.Entry<ITableSourceInfo, IPlatformTableSourceInfo>>() {
    protected Map.Entry<ITableSourceInfo, IPlatformTableSourceInfo> executeImpl() {
	        return CollectionUtils.createMapEntry(TypeInformation.get(ITableSourceInfo.class), TypeInformation.get(IPlatformTableSourceInfo.class));
    }
    }, true), CollectionUtils.asCollection(result)).getValue().getColumns();
    }
}