package MDT.FingerPrint.cmu;


import static com.neurotechnology.Library.NativeManager.getWrapperLibraryInfo;
import com.neurotechnology.Nffv.Nffv;
import com.neurotechnology.Nffv.NffvUser;
import com.neurotechnology.Nffv.ScannerModule;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arjunmehrotra
 */
public class FingerCode {
    
    private static FingerCode fc = new FingerCode();
    private ArrayList<NffvUser> users = new ArrayList<NffvUser>();
    private Nffv engine;
//    private NffvUser curruser;

    public ArrayList<NffvUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<NffvUser> users) {
        this.users = users;
    }


    public Nffv getEngine() {
        return engine;
    }

//    public NffvUser getCurruser() {
//        return curruser;
//    }

    public ScannerModule[] getScanners() {
        return scanners;
    }

    public ScannerModule[] getScan() {
        return scan;
    }

    
    public void setEngine(Nffv engine) {
        this.engine = engine;
    }

//    public void setCurruser(NffvUser curruser) {
//        this.curruser = curruser;
//    }

    public void setScanners(ScannerModule[] scanners) {
        this.scanners = scanners;
    }

    public void setScan(ScannerModule[] scan) {
        this.scan = scan;
    }
    
    private ScannerModule[] scanners;
    private ScannerModule[] scan;
    private FingerCode(){
        Random r = new Random();
        int rand = r.nextInt(1000);
    String defaultlibrary = "NffvJavaNative";

		
		//System.out.println("Loading " + defaultlibrary);
		System.loadLibrary(defaultlibrary);


        scanners = Nffv.getAvailableScannerModules();
        scan = new ScannerModule[1];
        for (int i = 0; i < scanners.length; i++) {
            if (scanners[i].getName().equals("Futronic")) {
                scan[0] = scanners[i];
                break;
            }
        }
        String db="Test" + rand;
        engine = new Nffv(db, "test", scan);
    }
    
    public static FingerCode getInstace(){
        return fc;
    }
}
