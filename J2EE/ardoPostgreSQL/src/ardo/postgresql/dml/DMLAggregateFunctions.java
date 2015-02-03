/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package ardo.postgresql.dml;

import outsystems.hubedition.extensibility.data.dmlservice.BaseDMLAggregateFunctions;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLService;
import outsystems.hubedition.util.TypeInformation;

/**
 *	Class for generating the DML aggregate functions required by the applications to perform DataSet queries.
 */
public class DMLAggregateFunctions extends BaseDMLAggregateFunctions {
    public static final TypeInformation<DMLAggregateFunctions> TypeInfo = TypeInformation.get(DMLAggregateFunctions.class);
    
    /**
	 *	Initializes a new instance of the DMLAggregateFunctions class.
	 *	@param	dmlService	The DML service.
	 */
    
    public DMLAggregateFunctions(IDMLService dmlService){
        super(dmlService);
    }
    
    /**
	 *	This property represents the associated DML service.
	 */
    public final DMLService getDMLService$DMLAggregateFunctions() {
        return (DMLService) super.getDMLService();
    }
}