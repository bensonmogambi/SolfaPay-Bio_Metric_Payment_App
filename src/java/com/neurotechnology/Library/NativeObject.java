package com.neurotechnology.Library;

/**
 * Provides methods for working with native objects.
 */
public class NativeObject extends Object{

	private long handle;
	
	private static int count;
	
	/**
	 * Creates a new instance of the NativeObject.
	 */
	public NativeObject(){
		count++;
		//System.out.println(this.getClass() + " created, total - " + count + " - " + handle);
	}

	/**
	 * Sets a handle for the NativeObject.
	 * @param handle Handle for the NativeObject.
	 */
	public void setHandle(long handle) {
		this.handle = handle;
	}

	/**
	 * Gets a handle of the NativeObject.
	 * @return Handle to the NativeObject.
	 */
	public long getHandle() {
		return handle;
	}
	
	protected void finalize() throws Throwable {
		count--;
		//System.out.println(this.getClass() + " finalized, total - " + count + " - " + handle);
		handle = 0;
		super.finalize();
	}
}
