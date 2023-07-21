package com.lililli.mybatis_jsp.RSAUtil;

import java.security.PrivateKey;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RSAKeyHolder {
    private static final Map<String, PrivateKey> keyMap =
            new ConcurrentHashMap<String, PrivateKey>();

    public static void set(String publicKey, PrivateKey key) {
        keyMap.put(publicKey, key);
    }

    public static PrivateKey get(String publicKey) {
        return keyMap.get(publicKey);
    }

    public static void remove(String publicKey) {
        keyMap.remove(publicKey);
    }
}

