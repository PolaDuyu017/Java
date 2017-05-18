package service;

public interface Authenticator {

	void authenticate(LoginCommand logincommand) throws AuthenticationException;
}
