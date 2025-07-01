package Enums;

public enum CashChange {
    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100), FIVE_HUNDRED(500);

    private final int value;

    CashChange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
