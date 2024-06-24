package br.com.erudio.api.exceptions;

import java.util.Date;
import java.io.Serializable;

public class ExceptionResponse implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestap, String message, String details){
        timestap = this.timestamp;
        message = this.message;
        details = this.details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    

}
