package com.challenge.crud.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.challenge.crud.dtos.UserDTO;
import com.challenge.crud.services.UserService;
import com.challenge.crud.services.response.ServiceResponse;
import org.junit.jupiter.api.Test;

class UserControllerTest {

    @Test
    void getUserById()
    {
        Long id = 34L;
        UserDTO dto = new UserDTO();
        UserService service = mock(UserService.class);
        UserController controller = new UserController();
        controller.userService = service;
        ServiceResponse expected = new ServiceResponse("Testing.", dto);
        when(service.getUser(id)).thenReturn(expected);
        ServiceResponse response = controller.getUserById(id);
        assertEquals(response, expected);
        verify(service).getUser(id);
    }

    @Test
    void createUser()
    {
        UserDTO dto = new UserDTO();
        UserService service = mock(UserService.class);
        UserController controller = new UserController();
        controller.userService = service;
        ServiceResponse expected = new ServiceResponse("Testing.", dto);
        when(service.saveUser(any(UserDTO.class))).thenReturn(expected);
        ServiceResponse response = controller.createUser("user1", "email@entity.com", "passw", 4, "1971-12-03", new byte[10]);
        assertEquals(response, expected);
        verify(service).saveUser(any(UserDTO.class));
    }

    @Test
    void updateUser()
    {
        Long id = 34L;
        UserDTO dto = new UserDTO();
        UserService service = mock(UserService.class);
        UserController controller = new UserController();
        controller.userService = service;
        ServiceResponse expected = new ServiceResponse("Testing.", dto);
        when(service.saveUser(any(UserDTO.class))).thenReturn(expected);
        ServiceResponse response = controller.updateUser(id,"user1", "email@entity.com", "passw", 4, "1971-12-03", new byte[10]);
        assertEquals(response, expected);
        verify(service).saveUser(any(UserDTO.class));
    }

    @Test
    void deleteUserById()
    {
        Long id = 34L;
        UserDTO dto = new UserDTO();
        UserService service = mock(UserService.class);
        UserController controller = new UserController();
        controller.userService = service;
        ServiceResponse expected = new ServiceResponse("Testing.", dto);
        when(service.deleteUser(id)).thenReturn(expected);
        ServiceResponse response = controller.deleteUserById(id);
        assertEquals(response, expected);
        verify(service).deleteUser(id);
    }
}