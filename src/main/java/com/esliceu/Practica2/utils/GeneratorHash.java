package com.esliceu.Practica2.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/*Cambiar a base 64 */
public class GeneratorHash {
    private static MessageDigest md = null;

    public static String generaHash(String password){
        try {
            if (md==null){
                md = MessageDigest.getInstance("SHA-256");
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }

        try {
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            byte[] thedigest = md.digest(bytesOfMessage);
            return new String(thedigest);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
