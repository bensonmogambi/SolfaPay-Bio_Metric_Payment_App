/**
 * Classes under this namespace provides methods for the com.neurotechnology.Nffv library.
 */
package com.neurotechnology.Nffv;

import java.util.ArrayList;
import java.util.List;

import com.neurotechnology.Library.NativeManager;
import com.neurotechnology.Library.NativeObject;

/**
 * The main class of the Free Fingerprint Verification SDK. 
 * Provides methods and properties for working with users list and enrolling or verifying 
 * user fingerprints. 
 */
public class Nffv{
	
	private ArrayList<NffvUser> users;
	private NffvStatus engineStatus;
	private boolean disposed = true;
	
	/**
	 * Creates a new instance of the Nffv.
	 * @param database Name of a database,
	 * @param password Password for a database.
	 * @param scannerModules List of scanner modules that should be loaded.
	 */
	public Nffv(String database, String password, ScannerModule[] scannerModules){
		String scanners = "";
		for(int i = 0; i < scannerModules.length; i++){
			if(scanners.length() != 0) scanners += ";";
			scanners += scannerModules[i].getName();
		}
		
		create0(database, password, scanners);
		disposed = false;
		
		users = new ArrayList<NffvUser>();
		long[] handles = getUsers0();
		for (int i = 0; i < handles.length; i++)
			users.add(new NffvUser(handles[i],this));
			
	}
	
	/**
	 * Implements standard Java method used by the garbage collector.
	 */
	public void finalize() throws Throwable {
		if(!disposed){
			free0();
			disposed = true;
		}
	}
	
	/**
	 * Gets a list of users enrolled to a database.
	 * @return List of users that was enrolled to a database.
	 */
	public List<NffvUser> getUsers(){
		return users;
	}
	
	/**
	 * Removes all users from a database.
	 */
	public void clearUsers(){
		users = new ArrayList<NffvUser>();
		removeUsers0();
	}
	
	/**
	 * Returns a user details by the Id.
	 * @param id User Id.
	 * @return NffvUser object that contains user details.
	 */
	public NffvUser getUserByID(int id){
		long handle = getUserByID0(id);
		for (NffvUser user : users) {
			if(user.getHandle() == handle) return user;
		}		
		return null;
	}
	
	/**
	 * Removes a concrete user from a database.
	 * @param user NffvUser object that should be removed.
	 */
	public void removeUser(NffvUser user) throws Exception{
		for (int i = 0; i < this.users.size(); i++)
			if(users.get(i) == user){
				removeUser0(user.getHandle());
				users.remove(user);
				return;
			}
	}
	
	/**
	 * Removes user's ID.
	 * @param ID User's ID to remove.
	 */
	public void removeUserID(int ID){
		removeUserID0(ID);
	}
	
	/**
	 * Checks if the database contains a concrete user.
	 * @param user User details to check.
	 * @return Boolean value indicating if a database contains a concrete user.
	 */
	public boolean contains(NffvUser user){
		return users.contains(user);
	}

	/**
	 * Returns available fingerprint scanner modules for usage in the Free Fingerprint Verification SDK. 
	 * @return Array that contains available scanner modules.
	 */
	public static ScannerModule[] getAvailableScannerModules(){
		String modules = getAvailableScannerModules0();
		if(modules == null) return null;
		
		String[] names = modules.split(";");
		ScannerModule[] scannerModules = new ScannerModule[names.length];
		
		for(int i = 0; i < names.length; i++)
			scannerModules[i] = new ScannerModule(names[i]);
		
		return scannerModules;
	}

	/**
	 * Gets a fingerprint from a scanner and saves it to a database. 
	 * @param timeout Specifies the time in milliseconds after which the fingerprint scanner
	 * stops scanning fingerprint. This usually happens when a finger is removed from a scanner
	 * for longer than timeout milliseconds.
	 * @return NffvUser object that contains details of an enrolled user.
	 */
	public NffvUser enroll(int timeout){
		long handle = enroll0(timeout, this);
		if (handle == 0) return null;
		NffvUser user = new NffvUser(handle, this);
		users.add(user);
		return user;
	}

	/**
	 * Compares a captured fingerprint with the one that was enrolled to a database before
	 * in order to determine whether two match.
	 * @param user A reference to a database record that should be matched with the scanned fingerprint.
	 * @param timeout Specifies the time in milliseconds after which the fingerprint scanner stops
	 * scanning fingerprint. This usually happens when a finger is removed from a scanner for
	 * longer than timeout milliseconds.
	 * @return Matching score.
	 */
	public int verify(NffvUser user, int timeout){
		return verify0(user.getHandle(), timeout, this);
	}

	/**
	 * Gets image quality threshold.
	 * @return Returns fingerprint quality threshold. The value should be in range [0, 255].
	 * The default value is 100. 
	 */
	public int getQualityThreshold(){
		return getQualityThreshold0();
	}

	/**
	 * Sets image quality threshold.
	 * @param Image quality threshold to set.
	 */
	public void setQualityThreshold(int value){
		setQualityThreshold0(value);
	}

	/**
	 * Gets the minimum similarity value that verification function uses to determine whether the fingerprint matches.
	 * @return The minimum similarity value that verification function accept for the same finger fingerprints.
	 * The default value is 0.01 %. 
	 */
	public int getMatchingThreshold(){
		return getMatchingThreshold0();
	}

	/**
	 * Sets the minimum similarity value that verification function uses to determine whether the fingerprint matches. 
	 * @param value The minimum similarity value that verification function accept for the same finger fingerprints.
	 */
	public void setMatchingThreshold(int value){
		setMatchingThreshold0(value);
	}
	
	
	private static native String getAvailableScannerModules0();
	private static native void create0(String database, String password, String scannerModules);
	private static native long[] getUsers0();
	private static native long getUserByID0(int id);
	private static native void removeUser0(long userHandle);
	private static native void removeUserID0(int id);
	private static native void removeUsers0();
	private static native int verify0(long userhandle, int timeout, Nffv engine);
	private static native long enroll0(int timeout, Nffv engine);
	private static native int getQualityThreshold0();
	private static native void setQualityThreshold0(int value);
	private static native int getMatchingThreshold0();
	private static native void setMatchingThreshold0(int value);
	private static native void free0();

	/**
	 * The maximum number of users that can be enrolled to a database. 
	 * @return The maximum number of users that can be enrolled to a database.
	 */
	public static native int getMaxUserCount();

	/**
	 * Sets status information for the com.neurotechnology.Nffv.
	 * @param engineStatus NffvStatus object that holds information to set.
	 */
	protected void setEngineStatus(NffvStatus engineStatus) {
		this.engineStatus = engineStatus;
	}

	/**
	 * Sets status information for the com.neurotechnology.Nffv.
	 * @param engineStatus Number that indicates Nffv status.
	 */
	protected void setIntEngineStatus(int engineStatus) {
		this.engineStatus = NffvStatus.getVal(engineStatus);
	}

	/**
	 * Gets status information of the com.neurotechnology.Nffv.
	 * @return NffvStatus object that holds information about Nffv.
	 */
	public NffvStatus getEngineStatus() {
		return engineStatus;
	}
	
	static{
		NativeManager.defaultlibrary = "NffvJavaNative";
		NativeManager.loadDefault();
	}
}
