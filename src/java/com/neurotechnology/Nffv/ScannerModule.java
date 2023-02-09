package com.neurotechnology.Nffv;

/**
 * Provides methods for setting and getting scanner names from the ScannerModule.
 */
public class ScannerModule {
	private String name;
	
	/**
	 * Creates a new instance of the ScannerModule
	 * @param name A name of a scanner to set.
	 */
	protected ScannerModule(String name){
		this.name = name;
	}

	/**
	 * Sets a name of a fingerprint scanner.
	 * @param name A name of a scanner to set.
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets a fingerprint scanner name.
	 * @return String that contains fingerprint scanner name.
	 */
	public String getName() {
		return name;
	}
}
