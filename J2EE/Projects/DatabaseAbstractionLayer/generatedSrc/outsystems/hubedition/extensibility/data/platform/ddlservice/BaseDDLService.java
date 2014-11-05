/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.platform.ddlservice;

import java.nio.*;
import java.nio.charset.*;
import java.text.*;
import java.util.*;
import linqbridge.linq.*;
import outsystems.hubedition.extensibility.data.*;
import outsystems.hubedition.extensibility.data.databaseobjects.*;
import outsystems.hubedition.extensibility.data.dmlservice.*;
import outsystems.hubedition.extensibility.data.platform.*;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.*;
import outsystems.hubedition.extensibility.data.platform.dmlservice.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.runtimecommon.*;
import java.math.BigDecimal;
import linqbridge.linq.LinqMethods;
import outsystems.hubedition.extensibility.data.databaseobjects.IDatabaseInfo;
import outsystems.hubedition.extensibility.data.databaseobjects.ITableSourceColumnInfo;
import outsystems.hubedition.extensibility.data.databaseobjects.ITableSourceForeignKeyInfo;
import outsystems.hubedition.extensibility.data.databaseobjects.ITableSourceInfo;
import outsystems.hubedition.extensibility.data.DBDataType;
import outsystems.hubedition.extensibility.data.DBDataTypeExtensions;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLDefaultValues;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLFunctions;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLOperators;
import outsystems.hubedition.extensibility.data.dmlservice.IDMLService;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.IPlatformDatabaseObjectFactory;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.IPlatformDataTypeInfo;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.IPlatformTableSourceColumnInfo;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.IPlatformTableSourceEventTriggerInfo;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.IPlatformTableSourceIndexInfo;
import outsystems.hubedition.extensibility.data.platform.databaseobjects.PlatformDatabaseObjectFactoryExtensions;
import outsystems.hubedition.extensibility.data.platform.dmlservice.IPlatformDMLIdentifiers;
import outsystems.hubedition.extensibility.data.platform.dmlservice.IPlatformDMLService;
import outsystems.hubedition.extensibility.data.platform.IPlatformDatabaseServices;
import outsystems.runtimecommon.CollectionsExtensions;
import outsystems.runtimecommon.StringUtilities;


public abstract class BaseDDLService implements IDDLService {
    private IPlatformDatabaseServices _databaseServices;
    public static final TypeInformation<BaseDDLService> TypeInfo = TypeInformation.get(BaseDDLService.class);
    private Map<String, String> generatedPrimaryKeyConstraintNames = new HashMap<String, String>();
    
    protected final IPlatformDMLIdentifiers getIdentifiers()
    {
        return getDatabaseServices().getDMLService().getIdentifiers();
    }
    protected final IPlatformDatabaseObjectFactory getObjectFactory()
    {
        return getDatabaseServices().getObjectFactory();
    }
    
    public final IPlatformDatabaseServices getDatabaseServices()
    {
        return _databaseServices;
    }
    
    private final void setDatabaseServices(IPlatformDatabaseServices value)
    {
        _databaseServices = value;
    }
    
    protected BaseDDLService(IPlatformDatabaseServices databaseServices){
        setDatabaseServices( databaseServices );
    }
    
    public abstract boolean canAlterColumn(IPlatformTableSourceColumnInfo existingColumn, IPlatformTableSourceColumnInfo newColumn, RefParmHolder<String> errorMessage) throws java.sql.SQLException;
    
    /**
	 *	This method returns the SQL for the column definition to be used inside the create table and create column statements.  This implementation returns "escapedColumnName columnSQLDataType DEFAULT defaultValue NOT NULL"
	 *	@param	column	The column information for the column to create.
	 *	@param	defaultValue	The default value for the column to create.
	 *	@return	SQL for the column definition.
	 */
    protected String getColumnDefinition(IPlatformTableSourceColumnInfo column, String defaultValue) {
        return getIdentifiers().escapeIdentifier(column.getName()) + " " + column.getDataType().getSqlDataType() + 
            (useDefaultValue(column, defaultValue) ? " DEFAULT " + defaultValue : "") + 
            (getFinalMandatoryValue(column, defaultValue, column.isMandatory()) ? " NOT" : "") + 
            " NULL";
    }
    
    /**
	 *	Returns true if we can use the default value passed as argument in the column definition.
	 *	@param	column	
	 *	@param	defaultValue	The default value for the column that we want to change to (tentatively).
	 *	@return	True if we can use the default value, false otherwise.
	 */
    protected boolean useDefaultValue(IPlatformTableSourceColumnInfo column, String defaultValue) {
        return !column.isPrimaryKey() && (!StringUtils.equals(defaultValue, null));
    }
    
    /**
	 *	Returns the final mandatory value to use for the column definition. This can change depending on the column,  and depending on the default value.
	 *	@param	column	The column information.
	 *	@param	defaultValue	The default value for the column.
	 *	@param	mandatory	The mandatory value that we want to change to (tentatively).
	 *	@return	The final mandatory value that we want to change.
	 */
    protected boolean getFinalMandatoryValue(IPlatformTableSourceColumnInfo column, String defaultValue, boolean mandatory) {
        if (useDefaultValue(column, defaultValue) && (StringUtils.equals(defaultValue, getDatabaseServices().getDMLService().getDefaultValues().getNull())))
        {
            return false;
            // Make sure we don't ask "DEFAULT NULL NOT NULL"
        }
        return mandatory;
    }
    
    /**
	 *	This method returns the SQL for the primary key table constraint to be used inside the create table and create column statements. This implementation returns "CONSTRAINT escapedConstraintName PRIMARY KEY (escapedColumnNames)"
	 *	@param	constraintName	Name of the primary key constrain
	 *	@param	column	The primary key column
	 *	@return	SQL for the primary key table constraint.
	 */
    protected String getPrimaryKeyTableConstraint(String constraintName, IPlatformTableSourceColumnInfo column) {
        return "CONSTRAINT " + getIdentifiers().escapeIdentifier(constraintName) + " PRIMARY KEY (" + getIdentifiers().escapeIdentifier(column.getName()) + ")";
    }
    
    /**
	 *	This method returns the previously generated primary key constraint for a table.
	 *	@param	tableSource	Info about the table to which we want to return the previously generated primary key constraint name.
	 *	@return	The primary key constraint name previously generated.
	 */
    protected final String getGeneratedPrimaryKeyConstraintNameForTable(ITableSourceInfo tableSource) {
        return CollectionUtils.getValueFromMap(generatedPrimaryKeyConstraintNames,tableSource.getName());
    }
    
    /**
	 *	Returns the Tenant_Id column from the list of columns
	 *	@param	columns	columns to search for
	 *	@return	The Tenant_Id column
	 */
    protected final ITableSourceColumnInfo getTenantFilterField(Iterable<IPlatformTableSourceColumnInfo> columns) {
        return LinqMethods.firstOrDefault(TypeInformation.get(IPlatformTableSourceColumnInfo.class), columns, 
    new Func.Func1<IPlatformTableSourceColumnInfo, Boolean>() {
        protected Boolean executeImpl(IPlatformTableSourceColumnInfo col) throws Exception
        {
            return StringUtilities.equalsIgnoreCase(col.getName(), "Tenant_Id");
        }
    });
    }
    
    /**
	 *	Returns a name that can be used as a primary key identifier name.
	 *	@param	tableName	Name of the table for which we want to create a primary key
	 *	@return	A name that can be used as a sql identifier name
	 */
    protected final String getNewPrimaryKeyName(String tableName) {
        String primaryKeyName = PlatformDatabaseObjectFactoryExtensions.getNewPrimaryKeyName(getObjectFactory(), getDatabaseServices(), tableName);
        generatedPrimaryKeyConstraintNames.put(tableName, primaryKeyName);
        return primaryKeyName;
    }
    
    /**
	 *	This method generates the query that will be used in the event trigger.  This assumes that the underlying database has the NULLIF and COALESCE functions.
	 *	@param	sql	StringBuilder that will receive the query SQL.
	 *	@param	triggerTablePrimaryKeyColumn	Primary key column of the table associated with the trigger.
	 *	@param	triggerTableEventColumns	Columns of the table associated with the trigger that fire events.
	 *	@param	triggerTableForeignKeys	Foreign keys of the table associated with the trigger.
	 *	@param	eventTable	Table source that stores the events for the table associated with the trigger. This table resides in the same database as the table where the trigger is defined.
	 *	@param	eventQueueTable	Table source that stores the events to be fired by the platform.
	 *	@param	triggerDataAccessor	SQL snippet to access the newly triggered data (new or updated line in trigger table).
	 *	@param	needsTriggerDataAccessorInFrom	True if we need to include the triggerDataAccessor in a from clause to access it in a query.
	 *	@param	isUpdateVariableAccessor	SQL snippet to access the variable that is true if this trigger is an update.
	 */
    protected void fillEventTriggerQuery(StringBuilder sql, IPlatformTableSourceColumnInfo triggerTablePrimaryKeyColumn, Iterable<IPlatformTableSourceColumnInfo> triggerTableEventColumns, Iterable<ITableSourceForeignKeyInfo> triggerTableForeignKeys, ITableSourceInfo eventTable, ITableSourceInfo eventQueueTable, String triggerDataAccessor, boolean needsTriggerDataAccessorInFrom, String isUpdateVariableAccessor) {
        
        // We don't use the qualified name if both tables are in the same database, because this breaks database clone processes
        sql.append(StringUtils.format(" INSERT INTO {0}", eventTable.getDatabase().equalsObj(eventQueueTable.getDatabase()) ? eventQueueTable.getName() : eventQueueTable.getQualifiedName()));
        sql.append("(ESPACE_ID, TENANT_ID, ACTIVITY_ID, PROCESS_DEF_ID, DATA_ID, ENQUEUE_TIME, ERROR_COUNT, NEXT_RUN)");
        ArrayList<IPlatformTableSourceColumnInfo> triggerTableEventColumnsList = LinqMethods.toList(triggerTableEventColumns);
        ITableSourceColumnInfo tenantFilterField = getTenantFilterField(triggerTableEventColumnsList);
        String defaultTenantIdField = getIdentifiers().escapeIdentifier("_TENANT_ID");
        
        String tenantIdInSelect = (tenantFilterField == null) ? defaultTenantIdField : "COALESCE(" + defaultTenantIdField + ", " + triggerDataAccessor + "." + 
            getIdentifiers().escapeIdentifier(tenantFilterField.getName()) + 
            ")";
        
        IDMLService dmlService = getDatabaseServices().getDMLService();
        String dataIdInSelect = triggerDataAccessor + "." + getIdentifiers().escapeIdentifier(triggerTablePrimaryKeyColumn.getName());
        
        dataIdInSelect = (triggerTablePrimaryKeyColumn.getDataType().getType() == DBDataType.INTEGER) ? dmlService.getFunctions().integerToText(dataIdInSelect) : dataIdInSelect;
        
        sql.append(StringUtils.format(" (SELECT {0}, {1}, {2}, {3}, {4}, GETDATE(), 0, GETDATE() FROM {5} evt{6}", getIdentifiers().escapeIdentifier("_ESPACE_ID"), tenantIdInSelect, getIdentifiers().escapeIdentifier("_ACTIVITY_ID"), getIdentifiers().escapeIdentifier("_PROCESS_DEF_ID"), dataIdInSelect, getIdentifiers().escapeIdentifier(eventTable.getName()), needsTriggerDataAccessorInFrom ? (", " + triggerDataAccessor) : ""));
        
        sql.append(" WHERE ");
        IDMLOperators operators = dmlService.getOperators();
        String whereClause = operators.equal("evt." + getIdentifiers().escapeIdentifier("_IS_UPDATE"), isUpdateVariableAccessor);
        HashSet<String> triggerTableColumnNames = new HashSet<String>(ArrayUtils.fromIterable(LinqMethods.select(triggerTableForeignKeys, 
    new Func.Func1<ITableSourceForeignKeyInfo, String>() {
        protected String executeImpl(ITableSourceForeignKeyInfo fk) throws Exception
        {
            return fk.getColumnName().toUpperCase(java.util.Locale.ROOT);
        }
    })));
        
        for (IPlatformTableSourceColumnInfo column : triggerTableEventColumnsList) {
            String insertedFieldSnippet = triggerDataAccessor + "." + getIdentifiers().escapeIdentifier(column.getName());
            String evtFieldSnippet = "evt." + getIdentifiers().escapeIdentifier(column.getName());
            String coalesceSnippet = "{0}";
            String nullIfSnippet = "{0}";
            
            if (triggerTableColumnNames.contains(column.getName().toUpperCase(java.util.Locale.ROOT)) || (column == tenantFilterField))
            {
                switch (column.getDataType().getType())
                {
                    case INTEGER : 
                        nullIfSnippet = "NULLIF({0}, " + getDefaultValue(DBDataType.INTEGER) + ")";
                        coalesceSnippet = "COALESCE({0}, " + getDefaultValue(DBDataType.INTEGER) + ")";
                        break;
                    case TEXT : 
                        nullIfSnippet = "NULLIF({0}, " + getDefaultValue(DBDataType.TEXT) + ")";
                        coalesceSnippet = "COALESCE({0}, " + getDefaultValue(DBDataType.TEXT) + ")";
                        break;
                }
            }
            
            String condition = operators.or(operators.isNull(StringUtilities.f(nullIfSnippet, evtFieldSnippet)),
                operators.equal(evtFieldSnippet, StringUtilities.f(coalesceSnippet, insertedFieldSnippet)));
            
            whereClause = operators.and(whereClause, "(" + condition + ")");
        }
        
        sql.append(whereClause);
        sql.append(")");
    }
    
    public abstract String getDefaultValue(DBDataType type);
    
    /**
	 *	This method generates the SQL to create a new table. This implementation returns the statement "CREATE TABLE FullyQualifiedTableName (columnsDefinitionStatements, primaryKeyStatement)"
	 *	@param	newTable	Info about the table to create.
	 *	@param	columns	The columns information for the table to create along with the default values.      Note that some of them may be primary keys, as indicated on the IsPrimaryKey property.      This will lead to the creation of Primary Key Constraints.      Also note that a column could be an autonumber column, there's no need to call the AlterColumnChangeAutoNumber after.
	 *	@return	SQL statements to create the table.
	 */
    public Iterable<String> createTable(ITableSourceInfo newTable, ColumnDetails ... columns) {
        return new Iterable<String>() {
            ITableSourceInfo newTable;
            ColumnDetails[] columns;
            
            public Iterable<String> setup(ITableSourceInfo newTable, ColumnDetails[] columns) {
                this.newTable = newTable;
                this.columns = columns;
                return this;
            }
            public Iterator<String> iterator() {
                return new Yielder<String>() {
                    Iterable<String> columnDefinitions;
                    IPlatformTableSourceColumnInfo primaryKey;
                    
                    String primaryKeyStatement;
                    ITableSourceInfo newTable;
                    ColumnDetails[] columns;
                    
                    public Yielder<String> setup(ITableSourceInfo newTable, ColumnDetails[] columns) {
                        this.newTable = newTable;
                        this.columns = columns;
                        return this;
                    }
                    
                    protected boolean advance() throws Exception
                    {
                        Iterable<String> columnDefinitions = LinqMethods.select(Arrays.asList(columns), 
                            new Func.Func1<ColumnDetails, String>() {
                                protected String executeImpl(ColumnDetails col) throws Exception
                                {
                                    return getColumnDefinition(col.Column, col.DefaultValue);
                                }
                            });
                        IPlatformTableSourceColumnInfo primaryKey = LinqMethods.singleOrDefault(TypeInformation.get(IPlatformTableSourceColumnInfo.class), LinqMethods.select(Arrays.asList(columns), 
    new Func.Func1<ColumnDetails, IPlatformTableSourceColumnInfo>() {
        protected IPlatformTableSourceColumnInfo executeImpl(ColumnDetails col) throws Exception
        {
            return col.Column;
        }
    }), 
    new Func.Func1<IPlatformTableSourceColumnInfo, Boolean>() {
        protected Boolean executeImpl(IPlatformTableSourceColumnInfo col) throws Exception
        {
            return col.isPrimaryKey();
        }
    });
                        String primaryKeyStatement = primaryKey == null ? "" : getPrimaryKeyTableConstraint(getNewPrimaryKeyName(newTable.getName()), primaryKey);
                        
                        return yieldReturn("CREATE TABLE " + newTable.getQualifiedName() + " (" + CollectionsExtensions.strCat(columnDefinitions, ", ") + "" + (CollectionsExtensions.isNullOrEmpty(primaryKeyStatement) ? "" : ", " + primaryKeyStatement) + ")", NO_NEXT_STATEMENT);
                    }
                }.setup(newTable, columns);
            }
        }.setup(newTable, columns);
    }
    
    /**
	 *	This method generates the SQL to create a new index. This implementation returns the statement "CREATE UNIQUE INDEX FullyQualifiedIndexName ON FullyQualifiedTableName (escapedColumnNames)"
	 *	@param	newIndex	Info about the index to create.
	 *	@return	SQL statements to create the index.
	 */
    public Iterable<String> createIndex(IPlatformTableSourceIndexInfo newIndex) {
        String createStatement = "CREATE " + (newIndex.isUnique() ? "UNIQUE " : "") + "INDEX " + getIdentifiers().escapeAndQualifyIdentifier(newIndex.getTableSource().getDatabase(), newIndex.getName()) + " ON " + newIndex.getTableSource().getQualifiedName() + " (" + CollectionsExtensions.strCat(LinqMethods.select(newIndex.getColumns(), 
    new Func.Func1<IPlatformTableSourceColumnInfo, String>() {
        protected String executeImpl(IPlatformTableSourceColumnInfo col) throws Exception
        {
            return getIdentifiers().escapeIdentifier(col.getName());
        }
    }), ",") + ")";
        
        return CollectionsExtensions.toEnumerable(TypeInformation.String, createStatement);
    }
    
    /**
	 *	This method generates the SQL to drop an index previously obtained through the IIntrospectionService API. This implementation returns "DROP INDEX FullyQualifiedIndexName"
	 *	@param	existingIndex	Info about the index to drop.
	 *	@return	SQL statements to drop the index.
	 */
    public Iterable<String> dropIndex(IPlatformTableSourceIndexInfo existingIndex) {
        return new Iterable<String>() {
            IPlatformTableSourceIndexInfo existingIndex;
            
            public Iterable<String> setup(IPlatformTableSourceIndexInfo existingIndex) {
                this.existingIndex = existingIndex;
                return this;
            }
            public Iterator<String> iterator() {
                return new Yielder<String>() {
                    IPlatformTableSourceIndexInfo existingIndex;
                    
                    public Yielder<String> setup(IPlatformTableSourceIndexInfo existingIndex) {
                        this.existingIndex = existingIndex;
                        return this;
                    }
                    
                    protected boolean advance() throws Exception
                    {
                        return yieldReturn("DROP INDEX " + getIdentifiers().escapeAndQualifyIdentifier(existingIndex.getTableSource().getDatabase(), existingIndex.getName()), NO_NEXT_STATEMENT);
                    }
                }.setup(existingIndex);
            }
        }.setup(existingIndex);
    }
    
    /**
	 *	This method generates the SQL to create a new foreign key. This implementation returns ALTER TABLE FullyQualifiedTableName ADD CONSTRAINT escapedConstraintName FOREIGN KEY (escapedForeignKeyColumnNames) REFERENCES FullyQualifiedForeignTableName (escapedForeignColumnNames) ON DELETE CASCADE
	 *	@param	newForeignKey	Info about the foreign key to create.
	 *	@return	SQL statements to create the foreign key.
	 */
    public Iterable<String> createForeignKey(ITableSourceForeignKeyInfo newForeignKey) {
        return new Iterable<String>() {
            ITableSourceForeignKeyInfo newForeignKey;
            
            public Iterable<String> setup(ITableSourceForeignKeyInfo newForeignKey) {
                this.newForeignKey = newForeignKey;
                return this;
            }
            public Iterator<String> iterator() {
                return new Yielder<String>() {
                    ITableSourceForeignKeyInfo newForeignKey;
                    
                    public Yielder<String> setup(ITableSourceForeignKeyInfo newForeignKey) {
                        this.newForeignKey = newForeignKey;
                        return this;
                    }
                    
                    protected boolean advance() throws Exception
                    {
                        return yieldReturn("ALTER TABLE " + newForeignKey.getTableSource().getQualifiedName() + " ADD CONSTRAINT " + getIdentifiers().escapeIdentifier(newForeignKey.getName()) + " FOREIGN KEY (" + getIdentifiers().escapeIdentifier(newForeignKey.getColumnName()) + ") REFERENCES " + newForeignKey.getReferencedTableSource().getQualifiedName() + " (" + getIdentifiers().escapeIdentifier(newForeignKey.getReferencedColumnName()) + ")" + (newForeignKey.isCascadeDelete() ? " ON DELETE CASCADE" : ""), NO_NEXT_STATEMENT);
                    }
                }.setup(newForeignKey);
            }
        }.setup(newForeignKey);
    }
    
    public abstract Iterable<String> createEventTrigger(IPlatformTableSourceEventTriggerInfo newTrigger, IPlatformTableSourceColumnInfo triggerTablePrimaryKeyColumn, Iterable<IPlatformTableSourceColumnInfo> triggerTableEventColumns, Iterable<ITableSourceForeignKeyInfo> triggerTableForeignKeys, ITableSourceInfo eventTable, ITableSourceInfo eventQueueTable);
    
    /**
	 *	This method generates the SQL to create a new primary key. This implementation returns "ALTER TABLE FullyQualifiedTableName ADD primaryKeyStatement"
	 *	@param	existingTable	Info about the table to create a new primary key. This info is obtained through the IIntrospectionServiceAPI
	 *	@param	column	Info about the column that composes the primary key.
	 *	@return	SQL statements to create the primary key.
	 */
    protected Iterable<String> createPrimaryKey(ITableSourceInfo existingTable, IPlatformTableSourceColumnInfo column) {
        String constraintName = getNewPrimaryKeyName(existingTable.getName());
        
        String alterTableStatement = "ALTER TABLE " + existingTable.getQualifiedName() + " ADD " + getPrimaryKeyTableConstraint(constraintName, column);
        
        return CollectionsExtensions.toEnumerable(TypeInformation.String, alterTableStatement);
    }
    
    /**
	 *	This method generates the SQL to create a new column. This implementation returns "ALTER TABLE FullyQualifiedTableName ADD columnsDefinitionStatement" and adds the SQL of the CreatePrimaryKey if the column is primary key.
	 *	@param	newColumn	Info about the column to create.
	 *	@param	defaultValue	Column default value. It could be empty.
	 *	@return	SQL statements to create the column.
	 */
    public Iterable<String> createColumn(IPlatformTableSourceColumnInfo newColumn, String defaultValue) throws java.sql.SQLException {
        String addColumnStatement = "ALTER TABLE " + newColumn.getTableSource().getQualifiedName() + " ADD " + getColumnDefinition(newColumn, defaultValue);
        
        ArrayList<String> result = new ArrayList<String>(Arrays.asList(
            addColumnStatement));
        
        if (newColumn.isPrimaryKey())
        {
            result.addAll(ArrayUtils.fromIterable(createPrimaryKey(newColumn.getTableSource(), newColumn)));
        }
        
        return result;
    }
    
    public abstract Iterable<String> alterColumn(IPlatformTableSourceColumnInfo existingColumn, IPlatformTableSourceColumnInfo newColumn, String defaultValue) throws java.sql.SQLException;
    
    /**
	 *	This method generates the SQL to drop a table previously obtained through the IIntrospectionService API. This implementation always returns "DROP TABLE FullyQualifiedTableName"
	 *	@param	existingTable	Info about the table to drop.
	 *	@return	SQL statements to drop the table.
	 */
    public Iterable<String> dropTable(ITableSourceInfo existingTable) {
        return CollectionsExtensions.toEnumerable(TypeInformation.String, "DROP TABLE " + existingTable.getQualifiedName());
    }
    
    /**
	 *	This method generates the SQL to drop a foreign key previously obtained through the IIntrospectionService API. This implementation returns "ALTER TABLE FullyQualifiedTableName DROP CONSTRAINT escapedConstraintName"
	 *	@param	existingForeignKey	Info about the foreign key to drop.
	 *	@return	SQL statements to drop the foreign key.
	 */
    public Iterable<String> dropForeignKey(ITableSourceForeignKeyInfo existingForeignKey) {
        String statement = "ALTER TABLE " + existingForeignKey.getTableSource().getQualifiedName() + " DROP CONSTRAINT " + getIdentifiers().escapeIdentifier(existingForeignKey.getName());
        
        return CollectionsExtensions.toEnumerable(TypeInformation.String, statement);
    }
    
    /**
	 *	This method generates the SQL to drop a trigger previously obtained through the IIntrospectionService API. This implementation returns "DROP TRIGGER FullyQualifiedTriggerName"
	 *	@param	existingTrigger	Info about the trigger to drop.
	 *	@return	SQL statements to drop the trigger.
	 */
    public Iterable<String> dropEventTrigger(IPlatformTableSourceEventTriggerInfo existingTrigger) {
        String statement = "DROP TRIGGER " + getIdentifiers().escapeAndQualifyIdentifier(existingTrigger.getTableSource().getDatabase(), existingTrigger.getName());
        
        return CollectionsExtensions.toEnumerable(TypeInformation.String, statement);
    }
    
    /**
	 *	This method generates the SQL to drop a column previously obtained through the IIntrospectionService API. This implementation returns "ALTER TABLE FullyQualifiedTableName DROP COLUMN escapedColumnName"
	 *	@param	existingColumn	Info about the column to drop.
	 *	@return	SQL statements to drop the column.
	 */
    public Iterable<String> dropColumn(IPlatformTableSourceColumnInfo existingColumn) {
        return CollectionsExtensions.toEnumerable(TypeInformation.String, "ALTER TABLE " + existingColumn.getTableSource().getQualifiedName() + " DROP COLUMN " + getIdentifiers().escapeIdentifier(existingColumn.getName()));
    }
    
    /**
	 *	Generates a message stating that a given column (existingColumn) cannot be changed to another type, defined by the newColumn.
	 *	@param	existingColumn	Existing column to be changed
	 *	@param	newColumn	New version of the column, based on the model
	 *	@param	isExistingColumnImmutable	True if the existing column cannot be changed into any other type, False if some conversions are allowed
	 *	@return	A user-friendly error message
	 */
    protected static String getColumnCannotBeChangedMessage(IPlatformTableSourceColumnInfo existingColumn, IPlatformTableSourceColumnInfo newColumn, boolean isExistingColumnImmutable) {
        return getColumnCannotBeChangedMessage(existingColumn.getTableSource().getName(), existingColumn.getName(), existingColumn.getDataType().getSqlDataType(), DBDataTypeExtensions.toText(existingColumn.getDataType().getType()), newColumn.getDataType().getSqlDataType(), DBDataTypeExtensions.toText(newColumn.getDataType().getType()), isExistingColumnImmutable);
    }
    
    /**
	 *	Generates a message stating that a given column (columnName) cannot be changed to another type (newColumnType)
	 *	@param	tableName	Name of the existing table that owns the column
	 *	@param	columnName	Name of the existing column to be changed
	 *	@param	existingColumnDbType	Database type of the existing column (e.g. VARCHAR)
	 *	@param	existingColumnType	Model type of the existing column (e.g. Text)
	 *	@param	newColumnDbType	New database type for the column (e.g. VARCHAR)
	 *	@param	newColumnType	New model type for the column
	 *	@param	isExistingColumnImmutable	True if the existing column cannot be changed into any other type, False if some conversions are allowed
	 *	@return	A user-friendly error message
	 */
    protected static String getColumnCannotBeChangedMessage(String tableName, String columnName, String existingColumnDbType, String existingColumnType, String newColumnDbType, String newColumnType, boolean isExistingColumnImmutable) {
        return StringUtils.format("Column '{0}.{1}' exists in database as {2} ({3}) but the new version is defined as {4} ({5}). Database {3} columns can not be changed{6}.", new Object[] {tableName, columnName, existingColumnType, existingColumnDbType, newColumnType, newColumnDbType, isExistingColumnImmutable ? "" : " to " + newColumnDbType});
    }
    
    /**
	 *	This method generates the SQL to create a new view. If already exists a view with the same name it should be replaced by the new one. This implementation returns "CREATE OR REPLACE VIEW FullyQualifiedViewName AS viewSQL"
	 *	@param	newView	Info about the view we want to create.
	 *	@param	viewSQL	SQL query that defines the view contents.
	 *	@param	withCheckOption	true if the INSERT and UPDATE operations performed over the view should be constrained only to the rows referenced by the view
	 *	@return	SQL statements to create the view.
	 */
    public Iterable<String> createOrReplaceView(ITableSourceInfo newView, String viewSQL, boolean withCheckOption) {
        return CollectionsExtensions.toEnumerable(TypeInformation.String, "CREATE OR REPLACE VIEW " + newView.getQualifiedName() + " AS " + viewSQL + "" + (withCheckOption ? " WITH CHECK OPTION" : ""));
    }
    
    /**
	 *	This method generates the SQL to grant permissions on a table source to a user. This implementation returns "GRANT permissions ON FullyQualifiedTableName TO userName"
	 *	@param	existingTableSource	Info about the table or view which we want to grant permissions on.
	 *	@param	username	User to grant permissions.
	 *	@param	permissions	Permissions to grant to the user.
	 *	@return	SQL statements to grant permissions.
	 */
    public Iterable<String> grantPermissions(ITableSourceInfo existingTableSource, String username, EnumSet<Permissions> permissions) {
        List<String> permissionList = new ArrayList<String>();
        if (PermissionsExtensions.hasPermissions(permissions, EnumSet.of(Permissions.Select)))
        {
            permissionList.add("SELECT");
        }
        if (PermissionsExtensions.hasPermissions(permissions, EnumSet.of(Permissions.Insert)))
        {
            permissionList.add("INSERT");
        }
        if (PermissionsExtensions.hasPermissions(permissions, EnumSet.of(Permissions.Update)))
        {
            permissionList.add("UPDATE");
        }
        if (PermissionsExtensions.hasPermissions(permissions, EnumSet.of(Permissions.Delete)))
        {
            permissionList.add("DELETE");
        }
        
        String statement = "GRANT " + CollectionsExtensions.strCat(permissionList, ",") + " ON " + existingTableSource.getQualifiedName() + " TO " + getIdentifiers().escapeIdentifier(username);
        
        return CollectionsExtensions.toEnumerable(TypeInformation.String, statement);
    }
    
    protected String changeTriggersStatus(ITableSourceInfo tableSource, boolean enable) {
        return "ALTER TABLE " + tableSource.getQualifiedName() + " " + (enable ? "ENABLE" : "DISABLE") + " ALL TRIGGERS";
    }
    
    /**
	 *	This method generates the SQL to enable all the triggers for an existing table source. This implementation returns "ALTER TABLE TableQualifiedName ENABLE ALL TRIGGERS"
	 *	@param	existingTableSource	Info about the table source which we want to enable the triggers.
	 *	@return	SQL statements to enable the triggers.
	 */
    public Iterable<String> enableTriggers(ITableSourceInfo existingTableSource) {
        return CollectionsExtensions.toEnumerable(TypeInformation.String, changeTriggersStatus(existingTableSource, /*enable*/
        true));
    }
    
    /**
	 *	This method generates the SQL to disable all the triggers for an existing table source. This implementation returns "ALTER TABLE TableQualifiedName DISABLE ALL TRIGGERS"
	 *	@param	existingTableSource	Info about the table source which we want to disable the triggers.
	 *	@return	SQL statements to disable the triggers.
	 */
    public Iterable<String> disableTriggers(ITableSourceInfo existingTableSource) {
        return CollectionsExtensions.toEnumerable(TypeInformation.String, changeTriggersStatus(existingTableSource, /*enable*/
        false));
    }
    
    /**
	 *	This method generates the SQL to enable the auto-number behavior for an existing table source. This implementation returns an empty statement.
	 *	@param	existingTableSource	Info about the table source which we want to enable the auto-number.
	 *	@return	SQL statements to enable the auto-number.
	 */
    public Iterable<String> enableAutoNumber(ITableSourceInfo existingTableSource) {
        return CollectionsExtensions.toEnumerable(TypeInformation.String, "");
    }
    
    /**
	 *	This method generates the SQL to disable the auto-number behavior for an existing table source. This implementation returns an empty statement.
	 *	@param	existingTableSource	Info about the table source which we want to disable the auto-number.
	 *	@return	SQL statements to disable the auto-number.
	 */
    public Iterable<String> disableAutoNumber(ITableSourceInfo existingTableSource) {
        return CollectionsExtensions.toEnumerable(TypeInformation.String, "");
    }
}
