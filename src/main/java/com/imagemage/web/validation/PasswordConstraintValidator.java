package com.imagemage.web.validation;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator passwordValidator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1)
        ));

        RuleResult ruleResult = passwordValidator.validate(new PasswordData(password));

        if (ruleResult.isValid()) {
            return true;
        }

        List<String> message = passwordValidator.getMessages(ruleResult);

        String messageTemplate = message.stream()
                .collect(Collectors.joining(","));

        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
