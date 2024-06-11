package com.challenge.crud.dtos;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class UserDTO
{
    private Long userId;
    private String username;
    private String emailAddress;
    private String password;
    private LocalDate dateOfBirth;
    private Integer subscriptionType;
    private byte[] profilePicture;

    /**
     * Gets the userId.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the userId.
     *
     * @param The userId to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the emailAddress.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the emailAddress.
     *
     * @param The emailAddress to set.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the dateOfBirth.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the dateOfBirth.
     *
     * @param The dateOfBirth to set.
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the subscriptionType.
     */
    public Integer getSubscriptionType() {
        return subscriptionType;
    }

    /**
     * Sets the subscriptionType.
     *
     * @param The subscriptionType to set.
     */
    public void setSubscriptionType(Integer subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    /**
     * Gets the profilePicture.
     */
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    /**
     * Sets the profilePicture.
     *
     * @param The profilePicture to set.
     */
    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}
