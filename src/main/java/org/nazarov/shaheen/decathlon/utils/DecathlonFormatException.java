package org.nazarov.shaheen.decathlon.utils;
/**
 * @author nazarov
 * @version 1.0
 */
public class DecathlonFormatException extends IllegalArgumentException{
    public DecathlonFormatException(){

    }

    public DecathlonFormatException(String message) {
        super(message);
    }

    public DecathlonFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecathlonFormatException(Throwable cause) {
        super(cause);
    }
}
