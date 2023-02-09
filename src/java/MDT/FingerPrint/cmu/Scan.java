/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDT.FingerPrint.cmu;

//import com.neurotechnology.Library.NativeManager;
//import com.neurotechnology.Nffv.Nffv;
//import com.neurotechnology.Nffv.NffvUser;
//import com.neurotechnology.Nffv.ScannerModule;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author arjunmehrotra
 */
public class Scan {

    static final int TIMEOUT = 10000;

    public void scanSave() {
        try {
//            Nffv engine;
//            NffvUser curruser;
//
//            ScannerModule[] scanners = Nffv.getAvailableScannerModules();
//            ScannerModule[] scan = new ScannerModule[1];
//            for (int i = 0; i < scanners.length; i++) {
//                if (scanners[i].getName().equals("Futronic")) {
//                    scan[0] = scanners[i];
//                    break;
//                }
//            }
//            engine = new Nffv("Test", "test", scan);
//            curruser = engine.enroll(TIMEOUT);
//            System.out.println(engine.getEngineStatus());
//
//            BufferedImage im = curruser.getNffvImage().getBufferedImage();
//            File outputfile = new File("abc.png");
//
//            ImageIO.write(im, "png", outputfile);
//
//            engine.clearUsers();
//            engine = null;
//            curruser = null;
//            
//            System.gc();
            
        } catch (Exception ex) {
            Logger.getLogger(Scan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
