/**
 * Classes under this namespace provides methods for working with com.neurotechnology.Nffv library.
 */
package com.neurotechnology.Library;

/**
 * Provides methods for getting a library information.
 */
public class LibraryInfo {
	
	private String company;
	private String copyright;
	private String product;
	private String title;
	private int versionBuild;
	private int versionMajor;
	private int versionMinor;
	private int versionRevision;
	
	/**
	 * Sets a company name.
	 * @param company Company name.
	 */
	void setCompany(String company) {
		this.company = company;
	}

	/**
	 * Gets a company name.
	 * @return A string that contains a company name.
	 **/
	public String getCompany() {
		return company;
	}

	/**
	 * Sets a copyright notice for the library.
	 * @param copyright A string that contains a copyright notice.
	 */
	void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * Gets a copyright notice from the library.
	 * @return A string that contains library's copyright notice.
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * Sets product name.
	 * @param product A string that contains product name.
	 */
	void setProduct(String product) {
		this.product = product;
	}

	/**
	 * Gets product name.
	 * @return A string that contains product name.
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * Sets a title for the library.
	 * @param title A title to set for the library.
	 */
	void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets a title form the library.
	 * @return A string that contains library title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets library build version.
	 * @param versionBuild Library's version number.
	 */
	void setVersionBuild(int versionBuild) {
		this.versionBuild = versionBuild;
	}

	/**
	 * Gets library build version.
	 * @return Library's build version number.
	 */
	public int getVersionBuild() {
		return versionBuild;
	}

	/**
	 * Sets library's major version.
	 * @param versionMajor Library's major version number.
	 */
	void setVersionMajor(int versionMajor) {
		this.versionMajor = versionMajor;
	}

	/**
	 * Gets library's major version.
	 * @return Major version of a library..
	 */
	public int getVersionMajor() {
		return versionMajor;
	}

	/**
	 * Sets library's minor version.
	 * @param versionMMinor Library's minor version number.
	 */
	void setVersionMinor(int versionMinor) {
		this.versionMinor = versionMinor;
	}

	/**
	 * Gets library's minor version.
	 * @return Library's minor version number.
	 */
	public int getVersionMinor() {
		return versionMinor;
	}

	/**
	 * Sets library's revision version.
	 * @param versionRevision Library's revision version number.
	 */
	void setVersionRevision(int versionRevision) {
		this.versionRevision = versionRevision;
	}

	/**
	 * Gets library's revision version.
	 * @return Library's revision version number.
	 */
	public int getVersionRevision() {
		return versionRevision;
	}
}
