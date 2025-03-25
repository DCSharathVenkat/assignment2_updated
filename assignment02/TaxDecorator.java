package assignment02;

public abstract class TaxDecorator extends TaxComponent {
	protected TaxComponent delegate; 	
	public TaxDecorator(TaxComponent delegateIn) {
		delegate = delegateIn;
	}
	public abstract TaxComputation getTaxInfo();

	@Override
	public void setIncome(int inc) {
		delegate.setIncome(inc);
	}
	@Override
	public int getIncome() {
		return delegate.getIncome();
	}
	@Override
	public int getTaxableIncome() {
		return delegate.getTaxableIncome();
	}
	@Override
	public String getName() {
		return delegate.getName();
	}
	@Override
	public String getSSN() {
		return delegate.getSSN();
	}
	public int getCap(Brackets bracket) {
		return delegate.getCap(bracket);
	}
}
