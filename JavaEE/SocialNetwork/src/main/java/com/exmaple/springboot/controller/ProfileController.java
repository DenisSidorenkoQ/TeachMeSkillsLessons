package com.exmaple.springboot.controller;

import com.exmaple.springboot.model.Profile;
import com.exmaple.springboot.service.ImageService;
import com.exmaple.springboot.service.ProfileService;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;

@Controller
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    private final ImageService imageService;
    private final AuthorizedUser authorizedUser;

    @GetMapping("/profile/{userId}")
    protected String outputUserProfile(@PathVariable int userId, Model model) throws IOException {
        Profile profile = profileService.getProfile(userId);
        URI imageUrl = imageService.getImagePath(profile.getImageName());
        if (authorizedUser.getUserId() == userId) {
            model.addAttribute("rightsToChange", true);
        } else {
            model.addAttribute("rightsToChange", false);
        }
        model.addAttribute("imageUrl", imageUrl);
        model.addAttribute("profile", profile);
        return "Profile";
    }

    @GetMapping("/profile/edit/{userId}")
    protected String profileEditPage(Model model,
                                     @PathVariable int userId) {
        model.addAttribute("userId", userId);
        return "EditProfile";
    }

    @PostMapping("/profile/edit/{userId}")
    protected String editProfile(Model model,
                                 @PathVariable int userId,
                                 @RequestParam(required = false) String login,
                                 @RequestParam(required = false) String password,
                                 @RequestParam(required = false, name = "file") MultipartFile file
                                 ) throws IOException {
        profileService.editProfile(userId, login, password, file);
        return "redirect:/profile/" + userId;
    }

    @PostMapping("/profile/edit/img/{userId}")
    protected String editImg(@PathVariable int userId, Model model) {
        Profile profile = profileService.getProfile(userId);
        model.addAttribute("profile", profile);
        return "EditProfile";
    }
}
