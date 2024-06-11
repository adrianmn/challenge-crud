package com.challenge.crud.services.response;

import com.challenge.crud.dtos.UserDTO;

public class ServiceResponse {

    private String message;
    private Throwable exception;
    private Boolean success;
    private UserDTO dto;

    public ServiceResponse (String message)
    {
        this.message = message;
        this.success = Boolean.TRUE;
    }

    public ServiceResponse (String message, UserDTO dto)
    {
        this.message = message;
        this.success = Boolean.TRUE;
        this.dto = dto;
    }

    public ServiceResponse (String message, Throwable e)
    {
        this.message = message;
        this.exception = e;
        this.success = Boolean.FALSE;
    }

    public ServiceResponse (String message, Throwable e, UserDTO dto)
    {
        this.message = message;
        this.exception = e;
        this.success = Boolean.FALSE;
        this.dto = dto;
    }

    /**
     * Gets the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param The message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the exception.
     */
    public Throwable getException() {
        return exception;
    }

    /**
     * Sets the exception.
     *
     * @param The exception to set.
     */
    public void setException(Throwable exception) {
        this.exception = exception;
    }

    /**
     * Gets the success.
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Sets the success.
     *
     * @param The success to set.
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * Gets the dto.
     */
    public UserDTO getDto() {
        return dto;
    }

    /**
     * Sets the dto.
     *
     * @param The dto to set.
     */
    public void setDto(UserDTO dto) {
        this.dto = dto;
    }
}
