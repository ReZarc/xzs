package com.xzs.exam.configuration.property;

public class PasswordKeyConfig {
    private String publicKey;
    private String privateKey;

    /**
     * 获取公钥
     * @return public key
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * 设置公钥
     * @param publicKey
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * 获取私钥
     * @return the private key
     */
    public String getPrivateKey() {
        return privateKey;
    }
    /**
     * 设置私钥
     * @param privateKey the private key
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

}
