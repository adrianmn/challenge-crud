package com.challenge.crud.controllers;

import com.challenge.crud.dtos.UserDTO;
import com.challenge.crud.services.UserService;
import com.challenge.crud.services.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.javapoet.ClassName;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UserController
{
    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Autowired
    protected UserService userService;

    /**
     * Request to find a user by id.
     * @param id The id to look for.
     * @return @{ServiceResponse}
     */
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/user/findById/{id}")
    public ServiceResponse getUserById(@PathVariable Long id)
    {
        LOGGER.log(Level.FINE, "Asking for userId: ", id);
        return userService.getUser(id);
    }

    /**
     * Request to create a new user.
     * @param username The username.
     * @param emailAddress The email address.
     * @param password The password.
     * @param subType The subType.
     * @param birthDate The birthDate.
     * @param picture The picture.
     * @return @{ServiceResponse}
     */
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/user/create/{username}/{emailAddress}/{password}/{subType}/{birthDate}/{picture}")
    public ServiceResponse createUser(@PathVariable String username,
                                      @PathVariable String emailAddress,
                                      @PathVariable String password,
                                      @PathVariable Integer subType,
                                      @PathVariable String birthDate,
                                      @PathVariable byte[] picture)
    {
        UserDTO dto = new UserDTO();
        dto.setUsername(username);
        dto.setEmailAddress(emailAddress);
        dto.setPassword(password);
        dto.setSubscriptionType(subType);
        dto.setDateOfBirth(LocalDate.parse(birthDate, formatter));
        dto.setProfilePicture(picture);
        LOGGER.log(Level.FINE, "Creating user: ", dto);
        return userService.saveUser(dto);
    }

    /**
     * Request to update a new user.
     * @param id The id.
     * @param username The username.
     * @param emailAddress The email address.
     * @param password The password.
     * @param subType The subType.
     * @param birthDate The birthDate.
     * @param picture The picture.
     * @return @{ServiceResponse}
     */
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/user/update/{id}/{username}/{emailAddress}/{password}/{subType}/{birthDate}/{picture}")
    public ServiceResponse updateUser(@PathVariable Long id,
                                      @PathVariable String username,
                                      @PathVariable String emailAddress,
                                      @PathVariable String password,
                                      @PathVariable Integer subType,
                                      @PathVariable String birthDate,
                                      @PathVariable byte[] picture)
    {
        UserDTO dto = new UserDTO();
        dto.setUserId(id);
        dto.setUsername(username);
        dto.setEmailAddress(emailAddress);
        dto.setPassword(password);
        dto.setSubscriptionType(subType);
        dto.setDateOfBirth(LocalDate.parse(birthDate, formatter));
        dto.setProfilePicture(picture);
        LOGGER.log(Level.FINE, "Updating user: ", dto);
        return userService.saveUser(dto);
    }

    /**
     * Request to delete a user by id.
     * @param id The id to delete.
     * @return @{ServiceResponse}
     */
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/user/deleteById/{id}")
    public ServiceResponse deleteUserById(@PathVariable Long id)
    {
        LOGGER.log(Level.FINE, "Deleting user: ", id);
        return userService.deleteUser(id);
    }

}
