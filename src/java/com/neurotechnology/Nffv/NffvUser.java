package com.neurotechnology.Nffv;

import com.neurotechnology.Library.NativeManager;
import com.neurotechnology.Library.NativeObject;

/**
 * Provides methods for working with users.
 */
public class NffvUser extends NativeObject{

	private Nffv owner;
	
	protected NffvUser(long handle, Nffv owner){
		this.setHandle(handle);
		this.owner = owner;
	}
	
	
	/**
	 * Retrieves from a database user's ID. If a user was disposed or removed from engine an error is thrown.
	 * @return User's ID.
	 */
	public int getID() throws Exception{
		if (owner == null || !owner.contains(this)) throw new Exception("User was dispozed or removed from engine");
		return getID(this.getHandle());
	}
	
	
	/**
	 * Gets tan Image from the com.neurotechnology.Nffv.
	 * @return NffvImage object.
	 */
	public NffvImage getNffvImage() throws Exception{
		if (owner == null || !owner.contains(this)) throw new Exception("User was dispozed or removed from engine");
		NffvImage image = new NffvImage();
		loadImage(this.getHandle(), image);
		return image;
	}

	protected void finalize() throws Throwable {
		owner = null;
		super.finalize();
	}
	
	/**
	 * Gets a string representation of object.
	 * @return String representation of object.
	 */
	public String toString(){
		return new Integer(getID(this.getHandle())).toString();
	}
	
	private static native int getID(long handle);
	private static native void loadImage(long handle, NffvImage image);
	
	static{
		NativeManager.defaultlibrary = "NffvJavaNative";
		NativeManager.loadDefault();
	}
}
