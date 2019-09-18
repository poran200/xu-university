package com.seu.edu.bd.hrmserver.exception;

public class ResourseAlreadyExist extends  Exception {
    public ResourseAlreadyExist(String message) {
        super(message +" its already exist !");
    }
}
