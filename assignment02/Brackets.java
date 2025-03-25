package assignment02;

public enum Brackets {
	// https://www.irs.gov/filing/federal-income-tax-rates-and-brackets
	BRACKET1(10),BRACKET2(12),BRACKET3(22),
	BRACKET4(24),BRACKET5(32),BRACKET6(35),
	BRACKET7(37);
	private int taxpercent;
	Brackets(int percent) {
		taxpercent = percent;
	}
	public int getTaxpercent() {
		return taxpercent;
	}
}
