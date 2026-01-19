package util;

/**
 * Thrown when the station lacks enough resources to proceed.
 */
public class InsufficientResourceException extends Exception {
    public InsufficientResourceException(String message) {
        super(message);
    }
}
