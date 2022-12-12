package com.exmaple.springboot.facade;

import com.exmaple.springboot.model.Profile;
import com.exmaple.springboot.repository.ProfileRepository;
import com.exmaple.springboot.service.ImageService;
import com.exmaple.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class ProfileServiceFacade {
    private final ImageService imageService;
    private final UserService userService;
    private final ProfileRepository profileRepository;
    public Profile getProfile(int userId) {
        return profileRepository.getProfile(userId);
    }

    public void setNewProfileImage(int userId, String imageName) throws IOException {
        String oldImage = imageService.getImageByUserId(userId);
        if (!oldImage.equals("Placeholder.png")) {
            imageService.deleteImage(oldImage);
        }
        int imageId = imageService.createNewImage(imageName);
        profileRepository.changeImage(userId, imageId);
    }

    public void editProfile(int userId, String login, String password, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            imageService.upload(file.getInputStream(), file.getOriginalFilename());
            setNewProfileImage(userId, file.getOriginalFilename());
        }
        if (!login.isBlank()) {
            userService.changeUserLogin(userId, login);
        }
        if (!password.isBlank()) {
            userService.changeUserPassword(userId, password);
        }
    }
}
