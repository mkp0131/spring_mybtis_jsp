package com.lililli.mybatis_jsp.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import com.lililli.mybatis_jsp.RSAUtil.RSAKeyHolder;
import com.lililli.mybatis_jsp.RSAUtil.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lililli.mybatis_jsp.service.HomeService;
import com.lililli.mybatis_jsp.service.HomeVO;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping(value="/")
    public String getHome(String pw, Model model) throws NoSuchAlgorithmException {
        KeyPair keyPair = RSAUtil.genRSAKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        String base64PublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        RSAKeyHolder.set(base64PublicKey, privateKey);
        model.addAttribute("publicKey", base64PublicKey);
        System.out.println("🐯 PublicKey 발급: " + base64PublicKey);
        return "home";
    }

    @PostMapping(value="/login")
    public String getHome(String emplyrId, String password, String publicKey, Model model) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        PrivateKey privateKey = RSAKeyHolder.get(publicKey);

        Cipher cipher = Cipher.getInstance("RSA");
        byte[] byteEncrypted = Base64.getDecoder().decode(password.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytePlain = cipher.doFinal(byteEncrypted);
        String decrypted = new String(bytePlain, StandardCharsets.UTF_8);
        System.out.println(decrypted);

        return "home";
    }
}