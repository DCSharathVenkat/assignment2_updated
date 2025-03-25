package assignment02;

import static assignment02.Brackets.*;
import java.util.Map;
import static java.util.Map.entry;

public class HeadofHouse extends TaxComponent {
    private int income;
    private int standardDeduction = 21900;
    private Person dependent;

    
    Map<Brackets, Integer> caps = Map.ofEntries(
        entry(BRACKET1, 16550), entry(BRACKET2, 63100),
        entry(BRACKET3, 100500), entry(BRACKET4, 191950),
        entry(BRACKET5, 243700), entry(BRACKET6, 609350),
        entry(BRACKET7, Integer.MAX_VALUE)
    );

    public HeadofHouse(Person dependentIn) {
        this.dependent = dependentIn; 
    }

    @Override
    public int getTaxableIncome() {
        return Math.max(0, income - standardDeduction);
    }

    @Override
    public TaxComputation getTaxInfo() {
        double medicareSurTax = 0;
        if (income > 200000) {
            medicareSurTax = Math.round(0.009 * (income - 200000) * 100.0) / 100.0;
        }
        return new TaxComputation(medicareSurTax, Math.max(0, income - standardDeduction));
    }

    public void setIncome(int inc) {
        income = inc;
    }

    public int getIncome() {
        return income;
    }

    public int getCap(Brackets bracket) {
        return caps.get(bracket);
    }

    public String getName() {
        return dependent.getName();
    }

    public String getSSN() {
        return dependent.getSsnOrItin();
    }
}
