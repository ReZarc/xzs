package com.xzs.exam.exception;

public class BusinessException extends RuntimeException {

    /**
     * The constant UNKNOWN_EXCEPTION.
     */
    public static final int UNKNOWN_EXCEPTION = 0;

    private int code;

    /**
     * Instantiates a new Business exception.
     *
     * @param message the message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Is unknown boolean.
     *
     * @return the boolean
     */
    public boolean isUnknown() {
        return code == UNKNOWN_EXCEPTION;
    }


}
