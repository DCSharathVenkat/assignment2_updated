package assignment02;

public record TaxComputation(double taxdue, int amountLeftToTax) {
    @Override
    public String toString() {
        return String.format("(%.2f, %d)", taxdue, amountLeftToTax);
    }
}
