package week11_juan_117229_assignment;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        super("Autentikasi gagal!");
    }

    public AuthenticationException(String msg) {
        super(msg);
    }
}
