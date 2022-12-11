package com.exmaple.springboot.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.exmaple.springboot.model.Profile;
import com.exmaple.springboot.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final AmazonS3 client;
    private final ImageService imageService;
    private final UserService userService;

    public Profile getProfile(int userId) {
        return profileRepository.getProfile(userId);
    }

    public void setNewProfileImage(int userId, String imageName) {
        String oldImage = imageService.getImageByUserId(userId);
        if (!oldImage.equals("Placeholder.png")) {
            DeleteObjectRequest request = new DeleteObjectRequest("imgBucket", oldImage);
            client.deleteObject(request);
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
