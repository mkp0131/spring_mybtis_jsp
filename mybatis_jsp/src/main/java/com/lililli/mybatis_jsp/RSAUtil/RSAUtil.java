package com.lililli.mybatis_jsp.RSAUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class RSAUtil {

    public static final int KEY_SIZE = 1024;

    public static KeyPair genRSAKeyPair() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(KEY_SIZE, secureRandom);
        return gen.genKeyPair();
    }

    public static String decryptRSA(String encrypted, PrivateKey privateKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("RSA");
        byte[] byteEncrypted = Base64.getDecoder().decode(encrypted.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytePlain = cipher.doFinal(byteEncrypted);
        return new String(bytePlain, StandardCharsets.UTF_8);
    }

    public static String decryptRSA(String encrypted, String publicKey) throws Exception {
        PrivateKey privateKey = RSAKeyHolder.get(publicKey);
        RSAKeyHolder.remove(publicKey);
        return decryptRSA(encrypted, privateKey);
    }
}
