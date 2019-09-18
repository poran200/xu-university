package com.seu.athorization.cotroller;

import com.seu.athorization.exception.ResourseAlreadyExisitException;
import com.seu.athorization.exception.ResourseNotFoundException;
import com.seu.athorization.model.LoginToken;
import com.seu.athorization.services.LoginTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/authorization")
public class LoginTokenController {
    private LoginTokenService loginTokenService;

    public LoginTokenController(LoginTokenService loginTokenService) {
        this.loginTokenService = loginTokenService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<LoginToken>> findAll(){
        return  ResponseEntity.ok().body( loginTokenService.findAll());
    }
    @PostMapping(value = "")
    public ResponseEntity<LoginToken> insert(@RequestBody LoginToken loginToken){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(loginTokenService.insert(loginToken));
        } catch (ResourseAlreadyExisitException e) {
             return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<LoginToken> findById(@PathVariable String id){
        try {
            return ResponseEntity.ok(loginTokenService.findById(id));
        } catch (ResourseNotFoundException e) {
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }

    }


    @PutMapping(value = "/{id}")
    public  ResponseEntity<LoginToken> update(@PathVariable String  id,@RequestBody LoginToken loginToken){
        try {
            return ResponseEntity.ok().body(loginTokenService.update(id,loginToken));
        } catch (ResourseNotFoundException e) {
             return  ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<String> delete(@PathVariable String  id){
        try {
            return  ResponseEntity.accepted().body(loginTokenService.delete(id));
        } catch (ResourseNotFoundException e) {
             return ResponseEntity.notFound().build();
        }catch ( Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

}
