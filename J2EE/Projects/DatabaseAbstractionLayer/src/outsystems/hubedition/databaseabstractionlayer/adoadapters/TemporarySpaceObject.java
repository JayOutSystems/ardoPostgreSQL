/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.databaseabstractionlayer.adoadapters;

import java.sql.Connection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import outsystems.hubedition.util.IDisposable;
import outsystems.hubedition.util.OSStackTrace;
import outsystems.hubedition.util.RefParmHolder;
import outsystems.runtimecommon.OSTrace;

public abstract class TemporarySpaceObject<TObject> extends RefParmHolder<TObject> implements IDisposable {
    private static final String PROPERTY_NAME = "outsystems.db.TemporarySpaceAllocationsLog";
    private static Map<Connection, Set<TemporarySpaceObject<?>>> temporaryObjects = new HashMap<Connection, Set<TemporarySpaceObject<?>>>();
    
    private Connection conn;
    private OSStackTrace stackTrace;
    protected abstract void freeObject(TObject obj) throws Exception;
    
    public TemporarySpaceObject(Connection conn, TObject value) {
        super(value);
        this.conn = conn;
        associateTemporarySpaceObject(conn, this);
        
        if (logTemporarySpaceAllocations()) {
            stackTrace = new OSStackTrace(true);
        }
    }
    
    public void callFreeObjectIfNeeded() throws Exception {
        TObject val = getVal();
        
        if (val != null) {
            freeObject(val);
            super.setVal(null);
        }
    }
    
    @Override
    public void dispose() {
        try {
            callFreeObjectIfNeeded();            
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        
        removeTemporarySpaceObject(conn, this);
    }
    
    @Override
    public void setVal(TObject val) {
        throw new UnsupportedOperationException("setVal");
    }

    private static void associateTemporarySpaceObject(Connection conn, TemporarySpaceObject<?> temporarySpaceObject) {
        Set<TemporarySpaceObject<?>> temporaryObjsForConnection;
        
        synchronized (temporaryObjects) {
            temporaryObjsForConnection = temporaryObjects.get(conn);
            
            if (temporaryObjsForConnection == null) {
                temporaryObjsForConnection = Collections.synchronizedSet(new HashSet<TemporarySpaceObject<?>>());
                temporaryObjects.put(conn, temporaryObjsForConnection);
            }
        }
        
        temporaryObjsForConnection.add(temporarySpaceObject);
    }
    
    private static void removeTemporarySpaceObject(Connection conn, TemporarySpaceObject<?> temporarySpaceObject) {
        Set<TemporarySpaceObject<?>> temporaryObjsForConnection;
        
        synchronized (temporaryObjects) {
            temporaryObjsForConnection = temporaryObjects.get(conn);
        }
        
        if (temporaryObjsForConnection != null) {
            temporaryObjsForConnection.remove(temporarySpaceObject);
        }
    }
    
    private static boolean logTemporarySpaceAllocations() {
        String propertyValue = System.getProperty(PROPERTY_NAME);        
        return ((propertyValue != null) && (propertyValue.equalsIgnoreCase("true") || propertyValue.equals("1")));
    }
    
    public static void cleanAllTemporaryObjectsForConnection(Connection conn) {
        Set<TemporarySpaceObject<?>> temporaryObjsForConnection;
        
        synchronized (temporaryObjects) {
            temporaryObjsForConnection = temporaryObjects.get(conn);
        }
        
        if (temporaryObjsForConnection == null) {
            return;
        }
        
        for (TemporarySpaceObject<?> temporaryObj: temporaryObjsForConnection) {
            try {
                if (temporaryObj.getVal() != null) {
                    temporaryObj.callFreeObjectIfNeeded();
                    
                    if (logTemporarySpaceAllocations()) {
                        OSTrace.error("Temporary Object was not freed in the common way. Stack Trace of the object allocation:\n" + temporaryObj.stackTrace);   
                    }
                }
            } catch (Exception e) {
                OSTrace.error("Freeing temporary object", e);
            }
        }
        
        synchronized (temporaryObjects) {
            temporaryObjects.remove(conn);
        }
    }
}
