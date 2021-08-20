package com.imonichris.authenticationmicroservice.util;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	private final Random RANDOM = new SecureRandom();
    private final String ALPHA_NUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int LENGTH = 30;
    
    public String generateRandomString() {
        StringBuilder returnValue = new StringBuilder(LENGTH);

        for(int i = 0; i < LENGTH; i++) {
            returnValue.append(ALPHA_NUMERIC.charAt(RANDOM.nextInt(ALPHA_NUMERIC.length())));
        }

        return new String(returnValue);
    }

}
