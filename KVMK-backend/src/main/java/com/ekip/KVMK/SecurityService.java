package com.ekip.KVMK;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
