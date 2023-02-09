package MDT.FingerPrint.cmu;



import java.util.ArrayList;

public class CustomerList {
	
	private static CustomerList instance = null;
	public ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	private CustomerList(){
		
	}
	public static CustomerList getInstance(){
		if(instance==null){
			instance = new CustomerList();
		}
		return instance;
		
	}
}
