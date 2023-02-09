package com.neurotechnology.Library;

import java.util.Vector;

/**
 * Provides methods for managing scanner files.
 */
public class ScannerFiles {
	private String name;
	private Vector<String> files;

	/**
	 * Creates a new instance of the ScannerFiles.
	 */
	protected ScannerFiles(){
		files = new Vector<String>();
	}
	
	/**
	 * Sets a scanner name.
	 * @param name Name of a fingerprint scanner to set.
	 */
	protected void setName(String name){
		this.name = name;
	}
	
	/**
	 * Adds a file which is used by a fingerprint scanner.
	 * @param fileName Name of a file to add.
	 */
	protected void addFile(String fileName){
		files.add(fileName);
	}
	
	/**
	 * Gets a name of a fingerprint scanner.
	 * @return String that contains a name of fingerprint scanner.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns an array of objects (vector) that contains names of all fingerprint scanners files.
	 * @return Vector that contains files names.
	 */
	public Vector<String> getFiles(){
		return files;
	}
	
}
