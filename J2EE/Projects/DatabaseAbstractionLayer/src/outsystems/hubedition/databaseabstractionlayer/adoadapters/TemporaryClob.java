/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.databaseabstractionlayer.adoadapters;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;

public class TemporaryClob extends TemporarySpaceObject<Clob> {
    @Override
    protected void freeObject(Clob obj) throws SQLException {
        obj.free();
    }
    
    public TemporaryClob(Connection conn, Clob value) {
        super(conn, value);
    }
}
