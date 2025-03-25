package assignment02;

public abstract class TaxComponent {
	public abstract String getName();
	public abstract String getSSN();
	public abstract int getCap(Brackets bracket);
	public abstract int getTaxableIncome();
	public abstract TaxComputation getTaxInfo();
	public abstract void setIncome(int inc); 
	public abstract int getIncome();
}
