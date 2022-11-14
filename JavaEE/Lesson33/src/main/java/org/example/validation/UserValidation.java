package org.example.validation;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public class UserValidation {

    public boolean validate(BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            if (bindingResult.hasFieldErrors("login")) {
                model.addAttribute("loginErrorText",
                        bindingResult.getFieldError("login").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("password")) {
                model.addAttribute("passwordErrorText",
                        bindingResult.getFieldError("password").getDefaultMessage());
            }
            return false;
        }
        return true;
    }
}
