package com.lorenzo.raceteamcreator_bp02.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    Database db = new Database();
    UserController uc = new UserController(db);


    @Test
    void registerUser() {
        try {
            uc.registerUser("test", "test");
        }catch (Exception e){
            fail("This should not have thrown an exception");
    };
    }

    @Test
    void loginUser() {
        try {
            uc.setEmail("test");
            uc.setPassword("test");
            uc.loginUser();
        }catch (Exception e){
            fail("This should not have thrown an exception");
        };
    }

    @Test
    void setEmail() {
        try {
            uc.setEmail("test");
        }catch (Exception e){
            fail("This should not have thrown an exception");
        };
    }

    @Test
    void setPassword() {
        try {
            uc.setPassword("test");
        }catch (Exception e){
            fail("This should not have thrown an exception");
        };
    }

    @Test
    void setEmailEmpty() {
        try {
            uc.setEmail("");
        }catch (Exception e){
            fail("This should not have thrown an exception");
        };
    }
}