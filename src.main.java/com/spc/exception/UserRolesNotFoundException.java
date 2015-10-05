package com.spc.exception;

/**
 * Created by YogeshK on 2015-09-17.
 */
public class UserRolesNotFoundException extends Throwable {
    /**
     * Constructs an instance of
     * <code>UserRolesNotFoundException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UserRolesNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of
     * <code>UserRolesNotFoundException</code> with the specified cause.
     *
     * @param cause the cause.
     */
    public UserRolesNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an instance of
     * <code>UserRolesNotFoundException</code> with the specified detail message and
     * cause.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public UserRolesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
