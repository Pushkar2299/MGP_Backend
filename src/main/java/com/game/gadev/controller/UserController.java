package com.game.gadev.controller;

import com.game.gadev.exception.CustomException;
import com.game.gadev.model.User;
import com.game.gadev.service.UserService;
import com.game.gadev.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getUser(@PathVariable(value = "userId")Long id){
        Optional<User> user = userService.getSingleUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser (@RequestBody UserVO userVO, BindingResult result){
        User newUser = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            String errors = result.getFieldErrors().stream()
                    .map(err -> "Field '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.joining(","));
            throw new CustomException(errors, HttpStatus.BAD_REQUEST);
        }
        try {
           newUser  = userService.createUser(userVO);
        } catch (DataAccessException e) {
            throw new CustomException("Error in inserting data", HttpStatus.BAD_REQUEST);
        }


        response.put("user", newUser);
        response.put("message","User Created Successfully");
        return new ResponseEntity<>( response , HttpStatus.CREATED);




    }


}
