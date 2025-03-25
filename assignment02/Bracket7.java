package assignment02;

public class Bracket7 extends TaxDecorator {
    Brackets bracket = Brackets.BRACKET7;

    public Bracket7(TaxComponent delegate) {
        super(delegate);
    }

    @Override
    public TaxComputation getTaxInfo() {
        TaxComputation comp = delegate.getTaxInfo();
        int carryForward = 0;
        double taxInThisBracket = bracket.getTaxpercent() * comp.amountLeftToTax() / 100.0; // FIXED

        // Debugging print statement (optional)
        // System.out.printf("%.2f:%d / ", comp.taxdue() + taxInThisBracket, carryForward);

        return new TaxComputation(comp.taxdue() + taxInThisBracket, carryForward);
    }
}
