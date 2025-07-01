package Service;

import Enums.CashChange;
import Enums.CoinDenominators;
import Enums.PaymentMode;
import InventoryEntities.Product;

import java.util.List;

public class Transaction {
    private PaymentMode mode;
    private Product selectedProduct;
    private List<CoinDenominators> coinDenominators;
    private List<CashChange> cashChanges;
    private double change;

    public Transaction() {}

    public Transaction(PaymentMode mode, Product selectedProduct, List<CoinDenominators> coinDenominators, List<CashChange> cashChanges) {
        this.mode = mode;
        this.selectedProduct = selectedProduct;
        this.coinDenominators = coinDenominators;
        this.cashChanges = cashChanges;
    }

    public boolean completeTransaction(double amount) {
        double productPrice = selectedProduct.getPrice();
        if (amount >= productPrice) {
            change = amount - productPrice;
        }

        return amount >= productPrice;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<CoinDenominators> getCoinDenominators() {
        return coinDenominators;
    }

    public void setCoinDenominators(List<CoinDenominators> coinDenominators) {
        this.coinDenominators = coinDenominators;
    }

    public List<CashChange> getCashChanges() {
        return cashChanges;
    }

    public void setCashChanges(List<CashChange> cashChanges) {
        this.cashChanges = cashChanges;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
}
