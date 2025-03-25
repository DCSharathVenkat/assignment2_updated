package assignment02;

import static assignment02.Brackets.*;
import java.util.Map;
import static java.util.Map.entry;

public class MarriedFJ extends TaxComponent {
    private int income;
    private int standardDeduction = 29200;
    
    
    Map<Brackets, Integer> caps = Map.ofEntries(
        entry(BRACKET1, 23200), entry(BRACKET2, 94300),
        entry(BRACKET3, 201050), entry(BRACKET4, 383900),
        entry(BRACKET5, 487450), entry(BRACKET6, 731200),
        entry(BRACKET7, Integer.MAX_VALUE)
    );
    
    private Person spouse;
    
    @Override
    public int getTaxableIncome() {
        return Math.max(0, income - standardDeduction);
    }
    
    @Override
    public TaxComputation getTaxInfo() {
        double medicareSurTax = 0;
        if (income > 250000) {
            medicareSurTax = 0.009 * (income - 250000);
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
    
    public MarriedFJ(Person spouseIn) {
        spouse = spouseIn;
    }
    
    public String getName() {
        return spouse.getName();
    }
    
    public String getSSN() {
        return spouse.getSsnOrItin();
    }
}
