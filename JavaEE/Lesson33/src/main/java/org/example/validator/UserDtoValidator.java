package org.example.validator;

import org.example.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserDtoValidator implements ConstraintValidator<ValidUserDto, UserDto> {
    @Override
    @SuppressWarnings("PMD")
    public boolean isValid(UserDto dto, ConstraintValidatorContext context) {
        if (dto.getPassword().equals(dto.getConfirmationPassword())) {
            return true;
        }
        return false;
    }

}
