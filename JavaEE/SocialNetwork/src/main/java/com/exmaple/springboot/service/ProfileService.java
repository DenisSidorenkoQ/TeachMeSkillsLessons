package com.exmaple.springboot.service;

import com.exmaple.springboot.facade.ProfileServiceFacade;
import com.exmaple.springboot.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileServiceFacade profileServiceFacade;

    public Profile getProfile(int userId) {
        return profileServiceFacade.getProfile(userId);
    }

    public void editProfile(int userId, String login, String password, MultipartFile file) throws IOException {
        profileServiceFacade.editProfile(userId, login, password, file);
    }
}
