package Exceptions;

public class ProductDIspenseException extends RuntimeException {
    public ProductDIspenseException(String message) {
        super(message);
    }

    public ProductDIspenseException() {
        super();
    }

    public ProductDIspenseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDIspenseException(Throwable cause) {
        super(cause);
    }

    protected ProductDIspenseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
