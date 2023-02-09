package com.neurotechnology.Library;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * NetInstall class manages installation of Neurotechnogy
 * modules for Applet applications. Since com.neurotechnology.Nffv classes are 
 * using native libraries these libraries need to be accessible
 * for application that are using classes from com.neurotechnology.Nffv. This class 
 * parses files that consist list of libraries needed and allows 
 * download them to predefined location.
 */
public class NetInstall {
	
	private static boolean wdset;
	
	private Handler handler;
	private XMLReader parser;
	
	/**
	 * Creates a new instance of the NetInstall.
	 */
	public NetInstall() throws Exception{
		handler = new Handler();
		parser = XMLReaderFactory.createXMLReader();
		parser.setContentHandler(handler);
		parser.setErrorHandler(handler);
	}

	/**
	 * Tries to load libraries by default load method. Search is done in system path and user path variables.
	 * If Libraries are found they are loaded and checkLoadDefault returns true. Overwise it returns false.
	 * @return Boolean value indicating if the default FFV SDK library was loaded.
	 */
	public static boolean checkLoadDefault(){
		try{
			NativeManager.loadDefault();
			System.out.println("default library found");
			return true;
		}catch (Error e) {
			e.printStackTrace();
		}
		System.out.println("default library not found");
		return false;
	}

	/**
	 * Tries to load libraries from temporary folder that is located in <USER.HOME>/.neurotec/.<productname>
	 * If load is successful returns true and false overwise.
	 */
	public boolean checkLoadTemp(){
		try{
	        
			Vector<String> mainlibs = null;
			if (System.getProperty("os.name").indexOf("Windows") != -1){
				mainlibs = getMainLibrariesWindows();
				for (int i = 0; i < mainlibs.size(); i++){
					System.out.println("Loading - " + mainlibs.get(i));
					System.out.println(getPath() + mainlibs.get(i));
					
					System.load(getPath() + mainlibs.get(i));
				}
			}
			if (System.getProperty("os.name").indexOf("Linux") != -1){
				wdset();
				System.load(getPath() + "lib" + NativeManager.defaultlibrary + ".so");
				restoreWd();
			}
			
			NativeManager.isLibraryLoaded = true;
			return true;
		}catch (Error e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("temp library not found");
		return false;
	}
	

	/**
	 * Gets an environment properties.
	 * @return Property list that contains environment data.
	 */
	public Properties getEnvironment() throws java.io.IOException {
		Properties env = new Properties();
		env.load(Runtime.getRuntime().exec("env").getInputStream());
		return env;
	}
	
	protected static void wdset() throws Exception{
		System.out.println("trying to load libdlpath.so");
		System.load(getPath() + "libdlpath.so");
		wdset = true;
	}
	
	protected static void restoreWd(){
		if(wdset) restoreWd0();
	}
	
	private static native void restoreWd0(); 
	
	/**
	 * Retrieves an array of objects (vector) of libraries for Windows OS. These libraries are used by 
	 * the FFV SDK.
	 * @return Array of objects (vector) that contains strings of libraries for the Windows.
	 */
	public Vector<String> getMainLibrariesWindows() throws Exception{
		URL mainLibsURL = NetInstall.class.getResource("/com/neurotechnology/Library/MainLibWindows.xml");
		InputSource mainlibs = new InputSource(new InputStreamReader(mainLibsURL.openStream()));
		parser.parse(mainlibs);
		
		return handler.mainlibs;
	}

	/**
	 * Retrieves an array of objects (vector) of libraries for fingerprint scanners.
	 * @return Array of objects (vector) that contains fingerprint scanners names.
	 */
	public Vector<ScannerFiles> getScannerLibrariesWindows()throws Exception{
		if ("VeriLook".equals(NativeManager.getWrapperLibraryInfo().getProduct()))
			throw new Exception("This product does not support fingerprint scanners");
		URL fpsmmLibsURL = NetInstall.class.getResource("/com/neurotechnology/Library/fpsmmLibWindows.xml");
		InputSource fpsmmlibs = new InputSource(new InputStreamReader(fpsmmLibsURL.openStream()));
		parser.parse(fpsmmlibs);
		
		return handler.sf;
	}

	/**
	 * Retrieves an array of objects (vector) of libraries for fingerprint scanners.
	 * This method returns libraries for Linux.
	 * @return Array of objects (vector) that contains strings of libraries for the Linux.
	 */
	public Vector<String> getMainLibrariesLinux()throws Exception{
		URL mainLibsURL = NetInstall.class.getResource("/com/neurotechnology/Library/MainLibLinux.xml");
		InputSource mainlibs = new InputSource(new InputStreamReader(mainLibsURL.openStream()));
		parser.parse(mainlibs);
		
		return handler.mainlibs;
	}
	
	/**
	 * Installs Neurotec libraries to temporary directory <USER.HOME>/.neurotec/<productname>
	 */
	public void installTemp(String codeBase, Vector<String> mainlibs, Vector<ScannerFiles> scanners){
		String destination = getPath();
		if (mainlibs != null){
			for (int i = 0; i < mainlibs.size(); i++)
				copyURL(codeBase + mainlibs.get(i), destination + mainlibs.get(i));
		}
		
		if (scanners != null){
			destination += "fpsmm" + System.getProperty("file.separator");
			new File(destination).mkdirs();
			new File(destination + "plugin\\").mkdirs();
			new File(destination + "config\\").mkdirs();
			codeBase += "fpsmm" + System.getProperty("file.separator");
			for (int i = 0; i < scanners.size(); i++)
				for (int j = 0; j < scanners.get(i).getFiles().size(); j++)
					copyURL(codeBase + scanners.get(i).getFiles().get(j), destination + scanners.get(i).getFiles().get(j));
			
		}
	}
	
	private static String getPath(){
		String path = System.getProperty("user.home") 
			+ System.getProperty("file.separator") + ".neurotec" 
			+ System.getProperty("file.separator") + NativeManager.getWrapperLibraryInfo().getProduct()
			+ System.getProperty("file.separator");
		new File(path).mkdirs();
		return path;
	}
	
	private static void copyURL(String srcURL, String destFile)
	  {
	      try{
	          URL url  = new URL(srcURL);
	      
	          System.out.println("Opening connection to " + srcURL);

	          InputStream is = url.openStream();

	          FileOutputStream fos=null;
	          fos = new FileOutputStream( new File(destFile));
	          int oneChar, count=0;

	          while ((oneChar=is.read()) != -1)
	          {
	             fos.write(oneChar);
	             count++;
	          }
	          is.close();
	          fos.close();

	          System.out.println(count + " byte(s) copied");
	      }
	      catch (Exception e){ 
	    	  e.printStackTrace();
	      }
	  }
	
	class Handler extends DefaultHandler{
		
		ScannerFiles currScanner;
		Vector<ScannerFiles> sf;
		Vector<String> mainlibs;
		String oelem;
		
		
		public void startDocument (){
			//System.out.println("Start document");
	    }

	    public void endDocument (){
	    	//System.out.println("End document");
	    }
	    
	    public void startElement (String uri, String name, String qName, Attributes atts){
	    	if ("mainlib".equals(name)){
	    		//System.out.println("Start parsing mainlib");
	    		mainlibs = new Vector<String>();
	    	}
	    	if ("fpsmm".equals(name)){
	    		//System.out.println("Start parsing fpsmm");
	    		sf = new Vector<ScannerFiles>();
	    	}
	    	if ("lib".equals(name) || "name".equals(name) || "file".equals(name)){
	    		//System.out.print(name + ":");
	    		oelem = name;
	    	}
	    	if ("scanner".equals(name)){
	    		currScanner = new ScannerFiles();
	    	}
	    }


	    public void endElement (String uri, String name, String qName){
	    	
	    	if (name.equals("mainlib")){
	    		//System.out.println("end parsing mainlib");
	    	}
	    	if (name.equals("fpsmm")){
	    		//System.out.println("end parsing fpsmm");
	    	}
	    	if (name.equals("lib") || name.equals("name") || name.equals("file")){
	    		//System.out.println();
	    		oelem = null;
	    	}
	    	if (name.equals("scanner")){
	    		sf.add(currScanner);
	    	}
	    }


	    public void characters (char ch[], int start, int length){
	    	
	    	if (oelem != null){
	    		if (oelem.equals("lib")){
	    			mainlibs.add(new String(ch,start,length));
	    		}
	    		if (oelem.equals("name")){
	    			currScanner.setName(new String(ch,start,length));
	    		}
	    		if (oelem.equals("file")){
	    			currScanner.addFile(new String(ch,start,length));
	    		}
	    		//System.out.print(new String(ch,start,length));
	    	}
	    	
	    }
	}
}
