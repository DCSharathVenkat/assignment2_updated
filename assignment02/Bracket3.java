package assignment02;

public class Bracket3 extends TaxDecorator {
    int taxSlice;
    Brackets bracket = Brackets.BRACKET3;

    public Bracket3(TaxComponent delegate) {
        super(delegate);
        taxSlice = delegate.getCap(bracket) - delegate.getCap(Brackets.BRACKET2);
    }

    @Override
    public TaxComputation getTaxInfo() {
        TaxComputation comp = delegate.getTaxInfo();
        int carryOver = 0;
        double taxInThisBracket = 0;
        int temp = comp.amountLeftToTax();

        if (temp == 0) {
            taxInThisBracket = 0;
        } else if (delegate.getTaxableIncome() <= 100000) { 
            int temp1 = (temp / 50) * 50;
            int temp2 = temp1 + 50;
            double tx1 = bracket.getTaxpercent() * temp1 / 100.0;
            double tx2 = bracket.getTaxpercent() * temp2 / 100.0;
            taxInThisBracket = Math.floor((tx1 + tx2) / 2.0 + 0.5); 
        } else {
            carryOver = Math.max(0, temp - taxSlice);
            taxInThisBracket = bracket.getTaxpercent() * Math.min(temp, taxSlice) / 100.0;
        }
        return new TaxComputation(comp.taxdue() + taxInThisBracket, carryOver);
    }
}
