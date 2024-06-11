package com.challenge.crud.services;

import com.challenge.crud.dtos.UserDTO;
import com.challenge.crud.entities.User;
import com.challenge.crud.repositories.UserRepository;
import com.challenge.crud.services.response.ServiceResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private byte[] picture = new byte[10];
    private LocalDate date = LocalDate.now();
    @Test
    void saveUser()
    {
        UserService service     = mock(UserService.class);
        UserRepository userRepository = mock(UserRepository.class);
        service.userRepository = userRepository;
        UserDTO dto = new UserDTO();
        User user = new User();
        UserDTO dtoResponse = new UserDTO();
        assertNotNull(service);
        when(service.convertToDTO(user)).thenReturn(dtoResponse);
        when(service.convertToEntity(dto)).thenReturn(user);
        doCallRealMethod().when(service).saveUser(dto);
        ServiceResponse response = service.saveUser(dto);
        verify(userRepository).save(user);
        assertEquals(response.getDto(), dtoResponse);
        assertTrue(response.getSuccess());
        assertNotNull(response.getMessage());
        assertNull(response.getException());
    }

    @Test
    void saveUserFail()
    {
        UserService service     = mock(UserService.class);
        UserRepository userRepository = mock(UserRepository.class);
        service.userRepository = userRepository;
        UserDTO dto = new UserDTO();
        User user = new User();
        UserDTO dtoResponse = new UserDTO();
        assertNotNull(service);
        when(service.convertToDTO(user)).thenReturn(dtoResponse);
        when(service.convertToEntity(dto)).thenReturn(user);
        doCallRealMethod().when(service).saveUser(dto);
        when(userRepository.save(user)).thenThrow(new RuntimeException());
        ServiceResponse response = service.saveUser(dto);
        verify(userRepository).save(user);
        assertNull(response.getDto());
        assertFalse(response.getSuccess());
        assertNotNull(response.getException());
    }

    @Test
    void getUserFail()
    {
        UserService service     = mock(UserService.class);
        UserRepository userRepository = mock(UserRepository.class);
        service.userRepository = userRepository;
        Long id = 1000L;
        User user = new User();
        UserDTO dtoResponse = new UserDTO();
        assertNotNull(service);
        when(service.convertToDTO(user)).thenReturn(dtoResponse);
        doCallRealMethod().when(service).getUser(id);
        when(userRepository.findById(id)).thenThrow(new RuntimeException());
        ServiceResponse response = service.getUser(id);
        verify(userRepository).findById(id);
        assertNull(response.getDto());
        assertTrue(response.getSuccess());
        assertNotNull(response.getMessage());
        assertNull(response.getException());
    }

    @Test
    void getUser()
    {
        UserService service     = mock(UserService.class);
        UserRepository userRepository = mock(UserRepository.class);
        service.userRepository = userRepository;
        Long id = 1000L;
        User user = new User();
        UserDTO dtoResponse = new UserDTO();
        assertNotNull(service);
        when(service.convertToDTO(user)).thenReturn(dtoResponse);
        doCallRealMethod().when(service).getUser(id);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        ServiceResponse response = service.getUser(id);
        verify(userRepository).findById(id);
        assertEquals(response.getDto(), dtoResponse);
        assertTrue(response.getSuccess());
        assertNotNull(response.getMessage());
        assertNull(response.getException());
    }

    @Test
    void deleteUser()
    {
        UserService service     = mock(UserService.class);
        UserRepository userRepository = mock(UserRepository.class);
        service.userRepository = userRepository;
        Long id = 1000L;
        assertNotNull(service);
        doCallRealMethod().when(service).deleteUser(id);
        ServiceResponse response = service.deleteUser(id);
        verify(userRepository).deleteById(id);
        assertNull(response.getDto());
        assertTrue(response.getSuccess());
        assertNotNull(response.getMessage());
        assertNull(response.getException());
    }

    @Test
    void deleteUserFail()
    {
        UserService service     = mock(UserService.class);
        UserRepository userRepository = mock(UserRepository.class);
        service.userRepository = userRepository;
        Long id = 1000L;
        assertNotNull(service);
        doThrow(new RuntimeException()).when(userRepository).deleteById(id);
        doCallRealMethod().when(service).deleteUser(id);
        ServiceResponse response = service.deleteUser(id);
        verify(userRepository).deleteById(id);
        assertNull(response.getDto());
        assertFalse(response.getSuccess());
        assertNotNull(response.getMessage());
        assertNotNull(response.getException());
    }

    @Test
    void convertToEntityTest()
    {
        UserService service = new UserService();
        UserDTO dto = createDTO();
        User entity = service.convertToEntity(dto);
        assertTrue(compare(dto, entity));
    }

    @Test
    void convertToDTOTest()
    {
        UserService service = new UserService();
        User entity = createEntity();
        UserDTO dto = service.convertToDTO(entity);
        assertTrue(compare(dto, entity));
    }

    Boolean compare(UserDTO dto, User entity)
    {
        if (!dto.getUserId().equals(entity.getUserId())) return Boolean.FALSE;
        if (!dto.getUsername().equals(entity.getUsername())) return Boolean.FALSE;
        if (!dto.getPassword().equals(entity.getPassword())) return Boolean.FALSE;
        if (!dto.getProfilePicture().equals(entity.getProfilePicture())) return Boolean.FALSE;
        if (!dto.getDateOfBirth().equals(entity.getDateOfBirth())) return Boolean.FALSE;
        if (!dto.getEmailAddress().equals(entity.getEmailAddress())) return Boolean.FALSE;
        if (!dto.getSubscriptionType().equals(entity.getSubscriptionType())) return Boolean.FALSE;
        return Boolean.TRUE;
    }
    UserDTO createDTO()
    {
        UserDTO obj = new UserDTO();
        obj.setUserId(3L);
        obj.setProfilePicture(picture);
        obj.setPassword("pwd");
        obj.setUsername("username");
        obj.setSubscriptionType(4);
        obj.setDateOfBirth(date);
        obj.setEmailAddress("email");
        return obj;
    }

    User createEntity()
    {
        User obj = new User();
        obj.setUserId(3L);
        obj.setProfilePicture(picture);
        obj.setPassword("pwd");
        obj.setUsername("username");
        obj.setSubscriptionType(4);
        obj.setDateOfBirth(date);
        obj.setEmailAddress("email");
        return obj;
    }
}