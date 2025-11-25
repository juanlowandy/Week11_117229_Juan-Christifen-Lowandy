package week11_juan_117229_assignment;

public class ExcessiveFailedLoginException extends Exception {
    public ExcessiveFailedLoginException() {
        super("Anda telah mencapai jumlah batas login");
    }

    public ExcessiveFailedLoginException(String msg) {
        super(msg);
    }
}
