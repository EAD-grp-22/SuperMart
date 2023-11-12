package com.supermart.auth.service;

public interface EncryptionService {
     void postConstructor();
     String encryptPassword(String password);
     boolean verifyPassword(String password, String hash);
}
