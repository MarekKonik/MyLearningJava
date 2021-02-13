package sample.rest;

import sample.dto.UserCredentialsDto;

public class AuthenticatorImpl implements Authenticator{

    private static final String LOGIN = "marek";
    private static final String PASSWORD = "marek";

    @Override
    public void authenticate(UserCredentialsDto userCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {


        boolean authenticated = LOGIN.equals(userCredentialsDto.getLogin()) && PASSWORD.equals(userCredentialsDto.getPassword());
        System.out.println("is user authenticated: " + authenticated);
    }
}
