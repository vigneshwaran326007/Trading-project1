package com.vignesh.tradingApplication.TestContoller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vignesh.tradingApplication.controller.UserController;
import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.service.UserNotFoundException;
import com.vignesh.tradingApplication.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers() {
        List<UserTable> userList = new ArrayList<>();
        userList.add(new UserTable(1, "John", "john@example.com", "USER", null, 0, null));
        userList.add(new UserTable(2, "Jane", "jane@example.com", "ADMIN", null, 0, null));
        when(userService.getAllUsers()).thenReturn(userList);

//        ResponseEntity<List<UserTable>> response = userController.getAllUsers();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userList, response.getBody());
    }

    @Test
    public void testGetUserById() {
    	UserTable user = new UserTable(1, "John", "john@example.com", "USER", null, 0, null);
        when(userService.getUserById(1)).thenReturn(Optional.of(user));

        ResponseEntity<UserTable> response = userController.getUserById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testCreateUser() {
    	UserTable newUser = new UserTable(null, "John", "john@example.com", "USER", null, 0, null);
        when(userService.createUser(newUser)).thenReturn(newUser);

//        ResponseEntity<UserTable> response = userController.createUser(newUser);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(newUser, response.getBody());
    }

    @Test
    public void testUpdateUser() throws UserNotFoundException {
    	UserTable existingUser = new UserTable(1, "John", "john@example.com", "USER", null, 0, null);
    	UserTable updatedUser = new UserTable(1, "John Doe", "johndoe@example.com", "ADMIN", null, 0, null);
        when(userService.updateUser(1, updatedUser)).thenReturn(updatedUser);

        ResponseEntity<UserTable> response = userController.updateUser(1, updatedUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUser, response.getBody());
    }

    @Test
    public void testDeleteUser() {
        ResponseEntity<Void> response = userController.deleteUser(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteUser(1);
    }
}
