package Exceptions;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException() {
    super();
  }

  public ProductNotFoundException(String message) {
    super(message);
  }

  public ProductNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public ProductNotFoundException(Throwable cause) {
    super(cause);
  }

  protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
