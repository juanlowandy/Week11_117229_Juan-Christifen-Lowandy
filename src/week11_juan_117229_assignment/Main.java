package week11_juan_117229_assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<User> listOfUser = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void initialize() {
        User defaultUser = new User(
                "John",
                "Doe",
                "L",
                "Jl. Merpati No. 1 RT 1 RW 1, Banten",
                "admin",
                "admin"
        );
        listOfUser.add(defaultUser);
    }

    public static void handleLogin() {
        System.out.print("Username : ");
        String u = sc.nextLine();

        System.out.print("Password : ");
        String p = sc.nextLine();

        boolean success = false;

        for (User usr : listOfUser) {
            try {
                if (usr.login(u, p)) {
                    System.out.println(usr.greeting());
                    success = true;
                    break;
                }
            }
            catch (ExcessiveFailedLoginException e) {
                System.out.println(e.getMessage());
                success = true;
                break;
            }
        }

        if (!success) {
            try {
                throw new AuthenticationException();
            } catch (AuthenticationException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
    }

    public static void handleSignUp() {

        System.out.print("Nama Depan : ");
        String fn = sc.nextLine();

        System.out.print("Nama Belakang : ");
        String ln = sc.nextLine();

        System.out.print("Jenis Kelamin (L/P) : ");
        String g = sc.nextLine();

        System.out.print("Alamat : ");
        String addr = sc.nextLine();

        System.out.print("Username : ");
        String u = sc.nextLine();

        System.out.print("Password : ");
        String p = sc.nextLine();

        boolean hasUpper = false, hasDigit = false;

        for (char c : p.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
        }

        if (p.length() < 8 || !hasUpper || !hasDigit) {
            System.out.println("Password harus mengandung huruf besar, angka,"
                    + " minimum 6 karakter dan maksimum 16 karakter\n");
            return;
        }

        listOfUser.add(new User(fn, ln, g, addr, u, p));

        System.out.println("User telah berhasil didaftarkan\n");
    }

    public static void main(String[] args) {

        initialize();

        while (true) {
            System.out.println("Menu Utama");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.print("Pilihan : ");
            int pilih = sc.nextInt(); sc.nextLine();

            System.out.println();

            switch (pilih) {
                case 1: handleLogin(); break;
                case 2: handleSignUp(); break;
            }
        }
    }
}
