package Factory;

import Enums.PaymentMode;

public class DispensorFactory {
    public Dispensor createDispensor(PaymentMode mode) {
        return switch (mode) {
            case COIN -> new CoinPaymentDispensor();
            case CASH -> new CashPaymentDispensor();
            case ONLINE -> new OnlinePaymentDispensor();
        };
    }
}
