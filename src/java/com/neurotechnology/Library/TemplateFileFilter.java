package com.neurotechnology.Library;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * Extends Java's FileFilter interface. Provides methods for filtering files.
 */
public class TemplateFileFilter extends FileFilter {

	/**
	 * Tests whether or not the specified file should be included in a file list.
	 * @param f Path to a file that should be tested.
	 * @return Boolean value that indicates if file should be be included. File
	 * is included when a return value is true.
	 */
    public boolean accept(File f) 
    {
    	//allow other directories  besides the current one
        if (f.isDirectory()) 
        {
            return true;
        }

        String extension = getFileExtension(f);
        if (extension != null) 
        {
            if (extension.equals("data"))
	        {
	            return true;
	        } 
	        else 
	        {
	            return false;
	        }
	    }

	    return false;
	}

	/**
	 * Gets a description of template files.
	 * @return String that contains template files description.
	 */
	public String getDescription() 
	{
	    return "Template files: *.data";
	}
	    
	/**
	 * Gets the extension of a file.
	 * @param f Path to a file which extension should be returned.
	 * @return String that contains file extension.
	 */
	 public static String getFileExtension(File f) 
	 {
	     String ext = null;
	     String s = f.getName();
	     int i = s.lastIndexOf('.');
	        
	     if (i > 0 &&  i < s.length() - 1) 
	     {
	        ext = s.substring(i + 1).toLowerCase();
	     }
	     return ext;
	 }
}
