package br.com.erudio.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectsIsNullException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RequiredObjectsIsNullException(){
        super("It is not allowed to persist null objects");
    }

    public RequiredObjectsIsNullException(String string){
        super(string);
}


}
