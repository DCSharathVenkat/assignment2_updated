package assignment02;

public class Bracket1 extends TaxDecorator {
    int taxSlice;
    Brackets bracket = Brackets.BRACKET1;

    public Bracket1(TaxComponent delegate) {
        super(delegate);
        taxSlice = delegate.getCap(bracket);
    }

    @Override
    public TaxComputation getTaxInfo() {
        TaxComputation comp = delegate.getTaxInfo();
        int carryOver = 0;
        double taxInThisBracket = 0;
        int temp = comp.amountLeftToTax();

        if (temp < 5) {
            taxInThisBracket = 0;
        } else if (temp < 15) {
            taxInThisBracket = 1;
        } else if (temp < 25) {
            taxInThisBracket = 2;
        } else if (temp < 3000) {
            int temp1 = (temp / 25) * 25;
            int temp2 = temp1 + 25;
            double tx1 = bracket.getTaxpercent() * temp1 / 100.0;
            double tx2 = bracket.getTaxpercent() * temp2 / 100.0;
            taxInThisBracket = Math.floor((tx1 + tx2) / 2.0 + 0.5);
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
            tx2 += Brackets.BRACKET2.getTaxpercent() * 50 / 100.0;
            taxInThisBracket = Math.floor((tx1 + tx2) / 2.0 + 0.5);
        } else {
            carryOver = temp - taxSlice;
            taxInThisBracket = bracket.getTaxpercent() * Math.min(temp - carryOver, taxSlice) / 100.0;
        }
        return new TaxComputation(comp.taxdue() + taxInThisBracket, carryOver);
    }
}
