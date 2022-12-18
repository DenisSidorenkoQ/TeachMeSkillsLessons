package com.exmaple.springboot.service;

import com.exmaple.springboot.model.Profile;
import com.exmaple.springboot.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Profile getProfile(int userId) {
        return profileRepository.getProfile(userId);
    }

    public void changeImage(int userId, int imageId) {
        profileRepository.changeImage(userId, imageId);
    }
}
