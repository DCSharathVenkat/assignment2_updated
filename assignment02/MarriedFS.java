package assignment02;

import static assignment02.Brackets.*;
import java.util.Map;
import static java.util.Map.entry;

public class MarriedFS extends TaxComponent {
    private int income;
    private int standardDeduction = 14600;
    
    Map<Brackets, Integer> caps = Map.ofEntries(
        entry(BRACKET1, 11600), entry(BRACKET2, 47150),
        entry(BRACKET3, 100525), entry(BRACKET4, 191950),
        entry(BRACKET5, 243725), entry(BRACKET6, 365600),
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
        if (income > 125000) {
            medicareSurTax = 0.009 * (income - 125000);
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
    
    public MarriedFS(Person spouseIn) {
        spouse = spouseIn;
    }
    
    public String getName() {
        return spouse.getName();
    }
    
    public String getSSN() {
        return spouse.getSsnOrItin();
    }
}
