package com.api.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ServiceController {

    @RequestMapping("/user")
    public User getAll(){
        return new User("carlos apablaza","carlos@email.com");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    ErrorInfo handleBadRequest(HttpServletRequest req, Exception ex){
        return new ErrorInfo(req.getRequestURI(), ex);
    }
}
