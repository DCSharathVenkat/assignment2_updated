package assignment02;

public class Bracket2 extends TaxDecorator {
    int taxSlice;
    Brackets bracket = Brackets.BRACKET2;

    public Bracket2(TaxComponent delegate) {
        super(delegate);
        taxSlice = delegate.getCap(bracket) - delegate.getCap(Brackets.BRACKET1);
    }

    @Override
    public TaxComputation getTaxInfo() {
        TaxComputation comp = delegate.getTaxInfo();
        int carryOver = 0;
        double taxInThisBracket = 0;
        int temp = comp.amountLeftToTax();

        if (temp == 0) {
            taxInThisBracket = 0;
        } else if (temp < taxSlice) {
            int temp1 = (temp / 50) * 50;
            int temp2 = temp1 + 50;
            double tx1 = bracket.getTaxpercent() * temp1 / 100.0;
            double tx2 = bracket.getTaxpercent() * temp2 / 100.0;
            taxInThisBracket = Math.floor((tx1 + tx2) / 2.0 + 0.5);
        } else if (temp == taxSlice) {
            int temp1 = (temp / 50) * 50;
            double tx1 = bracket.getTaxpercent() * temp1 / 100.0;
            double tx2 = bracket.getTaxpercent() * temp1 / 100.0;
            tx2 += Brackets.BRACKET3.getTaxpercent() * 50 / 100.0;
            taxInThisBracket = Math.floor((tx1 + tx2) / 2.0 + 0.5);
        } else {
            carryOver = temp - taxSlice;
            taxInThisBracket = bracket.getTaxpercent() * taxSlice / 100.0;
        }
        return new TaxComputation(comp.taxdue() + taxInThisBracket, carryOver);
    }
}
