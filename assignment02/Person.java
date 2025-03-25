/*
 * Created on Jan 26, 2005
 *
 */
package assignment02;
// In a full application we would also need more information
public class Person {
	private String name;
	private String ssnOrItin;
	public Person (String name, String num) {
		this.name = name;
		ssnOrItin = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String nameIn) {
		name = nameIn;
	}
	public String getSsnOrItin() {
		return ssnOrItin;
	}
}
