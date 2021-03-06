/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.hubedition.extensibility.data.executionservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataRowCollection implements Iterable<DataRow> {

	private final List<DataRow> rows = new ArrayList<DataRow>();
	
	DataRowCollection() {
	}

	public void add(DataRow row) {
		rows.add(row);
		row.setState(DataRowState.Added);
	}

	@Override
	public Iterator<DataRow> iterator() {
		return rows.iterator();
	}
	
	public int getCount() {
		return rows.size();
	}

	public DataRow get(int i) {
		return rows.get(i);
	}
}
