/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.executionservice;

public enum SqlTypes {     
	BIT(java.sql.Types.BIT),
	TINYINT(java.sql.Types.TINYINT),
	SMALLINT(java.sql.Types.SMALLINT),
	INTEGER(java.sql.Types.INTEGER),
	BIGINT(java.sql.Types.BIGINT),
	FLOAT(java.sql.Types.FLOAT),
	REAL(java.sql.Types.REAL),
	DOUBLE(java.sql.Types.DOUBLE),
	DECIMAL(java.sql.Types.DECIMAL),
	NUMERIC(java.sql.Types.NUMERIC),
	CHAR(java.sql.Types.CHAR),
	VARCHAR(java.sql.Types.VARCHAR),
	LONGVARCHAR(java.sql.Types.LONGVARCHAR),
	DATE(java.sql.Types.DATE),
	TIME(java.sql.Types.TIME),
	TIMESTAMP(java.sql.Types.TIMESTAMP),
	BINARY(java.sql.Types.BINARY),
	VARBINARY(java.sql.Types.VARBINARY),
	LONGVARBINARY(java.sql.Types.LONGVARBINARY),
	NULL(java.sql.Types.NULL),
	OTHER(java.sql.Types.OTHER),
	JAVA_OBJECT(java.sql.Types.JAVA_OBJECT),
	DISTINCT(java.sql.Types.DISTINCT),
	STRUCT(java.sql.Types.STRUCT),
	ARRAY(java.sql.Types.ARRAY),
	BLOB(java.sql.Types.BLOB),
	CLOB(java.sql.Types.CLOB),
	REF(java.sql.Types.REF),
	DATALINK(java.sql.Types.DATALINK),
	BOOLEAN(java.sql.Types.BOOLEAN),
	ROWID(java.sql.Types.ROWID),
	NCHAR(java.sql.Types.NCHAR),
	NVARCHAR(java.sql.Types.NVARCHAR),
	LONGNVARCHAR(java.sql.Types.LONGNVARCHAR),
	NCLOB(java.sql.Types.NCLOB),
	SQLXML(java.sql.Types.SQLXML);

	private final int value;

	private SqlTypes(int value) {
	    this.value = value;
	}
	
	public int getValue() {
	    return value;
	}
}