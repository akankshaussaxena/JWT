package model;

public class AuthenticateResponse {
    private  String jwt;

    public String getJwt() {
        return jwt;
    }

    public AuthenticateResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticateResponse() {
    }
}
