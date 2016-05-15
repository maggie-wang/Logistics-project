package classsource;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
//import org.mockito.Mockito;

import junit.framework.Assert;

public class DBMethodsTest1 {
	
	DBMethods dbm;
	//DBMethods db_mock = Mockito.spy(DBMethods.class);
	
	@Before
	public void setup(){
		dbm = new DBMethods();		
	}
	
	String result;
	List<String> resultList;
	
	@Test
	public void getReport(){
		resultList = dbm.getReport("00-00-00", "2017-12-12");
		for(int i=0; i<resultList.size(); i++){
			System.out.println(resultList.get(i));
			assertNotNull("Result", resultList.get(i));
		}
	}
	
	@Test
	public void testBookDock(){
		
	}
	
	//public void bookDock(int dockId, String date, String time, String sName, int SID)

}
