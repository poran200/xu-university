package com.seu.athorization.services;

import com.seu.athorization.exception.ResourseAlreadyExisitException;
import com.seu.athorization.exception.ResourseNotFoundException;
import com.seu.athorization.model.LoginToken;
import com.seu.athorization.repository.LoginTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class LoginTokenService {
    private LoginTokenRepository loginTokenRepository;

    public LoginTokenService(LoginTokenRepository loginTokenRepository) {
        this.loginTokenRepository = loginTokenRepository;
    }

     public List<LoginToken> findAll(){
        return  loginTokenRepository.findAll();
    }

    public   LoginToken insert(LoginToken loginToken) throws ResourseAlreadyExisitException {
        Optional<LoginToken> optionalLoginToken= loginTokenRepository.findById(loginToken.getUsername());
        if (optionalLoginToken.isPresent()){
            throw  new ResourseAlreadyExisitException(loginToken.getUsername());
        }
        else {
            return loginTokenRepository.save(loginToken);
        }
    }

    public  LoginToken update(String id, LoginToken loginToken) throws ResourseNotFoundException {
        Optional<LoginToken> optionalLoginToken= loginTokenRepository.findById(id);
        if (!optionalLoginToken.isPresent()){
            throw new ResourseNotFoundException(id);
        }
        else {
            return loginTokenRepository.save(loginToken);
        }
    }
    public  LoginToken findById(String id) throws ResourseNotFoundException {
        Optional<LoginToken> optionalLoginToken= loginTokenRepository.findById(id);
        if (!optionalLoginToken.isPresent()){
            throw  new ResourseNotFoundException(id);
        }
        else {
           return optionalLoginToken.get();
        }
    }

    public String delete(@PathVariable String username) throws ResourseNotFoundException {

        Optional<LoginToken> optionalLoginToken = loginTokenRepository.findById(username);
        if (!optionalLoginToken.isPresent()) {
            throw new ResourseNotFoundException(username);
        } else {
             loginTokenRepository.deleteById(username);
             return username+" Deleted !";
        }
    }
}
