package com.neurotechnology.Library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * This class is responsible for loading Neurotechnology modules and
 * native library that contains implementation of native methods in 
 * JavaWrapper classes.     
 */
public class NativeManager {

	/**
	 * A boolean value indicating if a library was loaded.
	 */
	
	protected static boolean isLibraryLoaded;
	
	/**
	 * Default name of a library.
	 */
	public static String defaultlibrary = "NeurotecJavaNative";
	
	/**
	 * Loads a default library.
	 */
	public static void loadDefault(){
//		if(isLibraryLoaded) return;
//		//System.out.println("Loading NLicensing");
//		if (getWrapperLibraryInfo().getProduct().compareTo("Nffv") == -1) System.loadLibrary("NLicensing");
//		//System.out.println("Loading " + defaultlibrary);
//		System.loadLibrary(defaultlibrary);
//		isLibraryLoaded = true;
//		compareVersions();
	}
	
	/**
	 * Loads default and Java native libraries.
	 * @param neurotecjavanative Name of a Java native library.
	 * @param nlicensing Name of the Neurotechnology's NLicensing library.
	 */
	public static void loadFile(String neuratecjavanative, String nlicensing){
		if(isLibraryLoaded) return;
		if (getWrapperLibraryInfo().getProduct().compareTo("Nffv") == -1){
			System.out.println("Loading NLicensing");
			System.load(nlicensing);
		}
		System.out.println("Loading " + defaultlibrary);
		System.load(neuratecjavanative);
		isLibraryLoaded = true;
		compareVersions();
	}
	
	/**
	 * Checks if a library was loaded to memory.
	 * @return Boolean value indicating if a library was loaded to memory.
	 */
	public static boolean isLoaded(){
		return isLibraryLoaded;
	}

	/**
	 * Gets a product name. If a library fails to load an exception is thrown.
	 * @return String that contains a product name.
	 */
	public static String getProductName() throws Exception{
		if(!isLibraryLoaded)throw new Exception("Library not loaded");
		return getProductNameN();
	}

	/**
	 * Gets a major version of a library. If a library fails to load an exception is thrown.
	 * @return Integer value of library version.
	 */
	public static int getVersionMajor()throws Exception{
		if(!isLibraryLoaded)throw new Exception("Library not loaded");
		return  getVersionMajorN();
	}

	/**
	 * Gets a minor version of a library. If a library fails to load an exception is thrown.
	 * @return Integer value of library minor version.
	 */
	public static int getVersionMinor()throws Exception{
		if(!isLibraryLoaded)throw new Exception("Library not loaded");
		return  getVersionMinorN();
	}
	
	private static void compareVersions(){
		LibraryInfo libinf = getWrapperLibraryInfo();
		if(getVersionMajorN() != libinf.getVersionMajor() || getVersionMinorN() != libinf.getVersionMinor())
			System.out.println("WARNING: native library(" + getVersionMajorN() + "." + getVersionMinorN()
			+ ") and java wrapper(" + libinf.getVersionMajor() + "." + libinf.getVersionMinor() + ") versions do not match");
	}
	
	/**
	 * Gets information (such as company name, product, copyright notice) about wrapper's library.
	 * @return LibraryInfo object that information about wrapper.
	 */
	public static LibraryInfo getWrapperLibraryInfo(){
		LibraryInfo libinf = new LibraryInfo();
		try{
			URL url = libinf.getClass().getResource("/com/neurotechnology/Library/LibraryInfo.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			libinf.setCompany(br.readLine());
			libinf.setCopyright(br.readLine());
			libinf.setProduct(br.readLine());
			libinf.setTitle(br.readLine());
			libinf.setVersionBuild(new Integer(br.readLine()).intValue());
			libinf.setVersionMajor(new Integer(br.readLine()).intValue());
			libinf.setVersionMinor(new Integer(br.readLine()).intValue());
			libinf.setVersionRevision(new Integer(br.readLine()).intValue());
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return libinf;
	}
	
	private static native String getProductNameN();
	private static native int getVersionMajorN();
	private static native int getVersionMinorN();
	public static native void unload(String libName);
}
