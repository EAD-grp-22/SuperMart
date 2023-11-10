package com.supermart.auth.service;

public interface EncryptionService {
    public void postConstructor();
    public String encryptPassword(String password);
    public boolean verifyPassword(String password, String hash);
}
