package spc.exception;

/**
 * Created by yogeshkumar on 15/08/21.
 */
public class UserroleNotFoundException extends Throwable {
    /**
     * Constructs an instance of
     * <code>UserroleNotFoundException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UserroleNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of
     * <code>UserroleNotFoundException</code> with the specified cause.
     *
     * @param cause the cause.
     */
    public UserroleNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an instance of
     * <code>UserroleNotFoundException</code> with the specified detail message and
     * cause.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public UserroleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}