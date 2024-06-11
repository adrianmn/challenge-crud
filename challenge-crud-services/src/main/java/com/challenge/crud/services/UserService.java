package com.challenge.crud.services;

import com.challenge.crud.dtos.UserDTO;
import com.challenge.crud.entities.User;
import com.challenge.crud.repositories.UserRepository;
import com.challenge.crud.services.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService
{
    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
    @Autowired
    protected UserRepository userRepository;

    /**
     * Saves the user info in the DTO using userRepository.
     * @param dto The dto with the information.
     * @return @{ServiceResponse}
     */
    public ServiceResponse saveUser(UserDTO dto)
    {
        User user = convertToEntity(dto);
        try {
            userRepository.save(user);
        } catch(Throwable t)
        {
            LOGGER.log(Level.SEVERE, "Failed to save. ", t);
            return new ServiceResponse(t.getMessage(), t);
        }
        LOGGER.log(Level.FINE, "Saved object.", user);
        UserDTO response = convertToDTO(user);
        return new ServiceResponse("Succesfully saved.", response);
    }

    /**
     * Gets the user invoking userRepository by Id.
     * @param id The id of the user
     * @return @{ServiceResponse}
     */
    public ServiceResponse getUser(Long id)
    {
        UserDTO dto;
        try
        {
            Optional<User> userFound = userRepository.findById(id);
            dto =  convertToDTO(userFound.get());
            LOGGER.log(Level.FINE, "Retrieved object.", userFound.get());
        } catch (Throwable t)
        {
            LOGGER.log(Level.SEVERE, "Failed to retrieve from DB. ", t);
            return new ServiceResponse("No user found for that id.");
        }
        return new ServiceResponse("Successfully found.", dto);
    }

    /**
     * Deletes the user invoking userRepository by Id.
     * @param id The id of the user
     * @return @{ServiceResponse}
     */
    public ServiceResponse deleteUser(Long id)
    {
        try
        {
            userRepository.deleteById(id);
        } catch (Throwable t)
        {
            LOGGER.log(Level.FINER, "Failed to retrieve from DB. ", t);
            return new ServiceResponse("Failed to delete.", t);
        }
        LOGGER.log(Level.FINE, "Deleted object with id: ", id);
        return new ServiceResponse("Succesfully deleted.");
    }

    /**
     * Converts @{User} to @{UserDTO}.
     * @param user The user to convert.
     * @return @{UserDTO}
     */
    protected UserDTO convertToDTO(User user)
    {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        dto.setProfilePicture(user.getProfilePicture());
        dto.setSubscriptionType(user.getSubscriptionType());
        dto.setEmailAddress(user.getEmailAddress());
        return dto;
    }

    /**
     * Converts @{UserDTO} to @{User}.
     * @param dto The dto to convert.
     * @return @{User}
     */
    protected User convertToEntity(UserDTO dto)
    {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmailAddress(dto.getEmailAddress());
        user.setProfilePicture(dto.getProfilePicture());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setSubscriptionType(dto.getSubscriptionType());
        return user;
    }
}
