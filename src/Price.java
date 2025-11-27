package src;

public abstract class Price {
    public abstract int getPriceCode();

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

    public abstract double getCharge(int daysRented);
}
