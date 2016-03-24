package spc.exception;

/**
 * Created by YogeshK on 2015-07-22.
 */
public class UserNotFoundException extends Throwable {
    /**
     * Constructs an instance of
     * <code>UserNotFoundException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of
     * <code>UserNotFoundException</code> with the specified cause.
     *
     * @param cause the cause.
     */
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an instance of
     * <code>UserNotFoundException</code> with the specified detail message and
     * cause.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
