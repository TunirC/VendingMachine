package Enums;

public enum CoinDenominators {
    ONE(1), TWO(2), FIVE(5), TEN(10);

    private final int value;

    CoinDenominators(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
