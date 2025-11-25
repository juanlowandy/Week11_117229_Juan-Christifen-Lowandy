package week11_juan_117229_assignment;

public class User {

    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String userName;
    private String password;

    private int loginAttempts = 0;
    private final int maxLoginAttempts = 3;

    public User(String firstName, String lastName, String gender,
                String address, String userName, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }

    public boolean login(String username, String password)
            throws ExcessiveFailedLoginException {

        if (this.userName.equals(username)) {

            if (loginAttempts == maxLoginAttempts) {
                loginAttempts++;
                throw new ExcessiveFailedLoginException();
            } 
            else if (loginAttempts > maxLoginAttempts) {
                throw new ExcessiveFailedLoginException("Anda telah mencapai batas login");
            }

            if (this.password.equals(password)) {
                loginAttempts = 0;
                return true;
            } else {
                System.out.println("Password yang anda masukkan salah");
                System.out.println("Kesempatan Anda Login : " 
                        + (maxLoginAttempts - loginAttempts));
                loginAttempts++;
            }
        }

        return false;
    }

    public String greeting() {
        String greet = "Selamat Datang! ";
        switch (gender) {
            case "L": greet += "Tuan "; break;
            case "P": greet += "Nona "; break;
        }
        greet += this.firstName + " " + this.lastName;
        return greet;
    }

    public String getUserName() { return userName; }
}
