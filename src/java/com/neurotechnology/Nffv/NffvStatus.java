package com.neurotechnology.Nffv;

/**
 * Enumerates NffvStatus values.
 */
public enum NffvStatus {
	None,
	/**
	* Indicates that a fingerprint template was created.
	*/
	TemplateCreated,
	/**
	* Indicates that there is no fingerprint scanner connected. 
	*/
	NoScanner,
	/**
	* Indicates that the fingerprint scanner has reached the timeout.
	*/
	ScannerTimeout,
	/**
	* Indicates that the Free Fingerprint Verification SDK had failed to check the quality of a fingerprint. 
	*/
	QualityCheckFailed;

	public int eval(){
		switch(this){
			case None : return 0;
			case TemplateCreated : return 1;
			case NoScanner : return 2;
			case ScannerTimeout : return 3;
			case QualityCheckFailed : return 100;
		}
		return 0;
	}
	
	public static NffvStatus getVal(int val){
		switch(val){
			case 0 : return NffvStatus.None;
			case 1 : return NffvStatus.TemplateCreated;
			case 2 : return NffvStatus.NoScanner;
			case 3 : return NffvStatus.ScannerTimeout;
			case 100 : return NffvStatus.QualityCheckFailed;
		}
		return NffvStatus.None;
	}
}
