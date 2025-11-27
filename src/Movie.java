package src;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {

        switch (getPriceCode()) {

            case REGULAR:
                double result = 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                return result;

            case NEW_RELEASE:
                return daysRented * 3;

            case CHILDRENS:
                double resultChild = 1.5;
                if (daysRented > 3) {
                    resultChild += (daysRented - 3) * 1.5;
                }
                return resultChild;

            default:
                throw new IllegalArgumentException("Invalid Price Code in getCharge()");
        }
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
