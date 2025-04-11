import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class PasswordEncryptor {

    // Ayan
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        byte[] salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);

        System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));
        System.out.println("Hashed Password: " + hashedPassword);
    }

    public static String hashPassword(String password, byte[] salt) {
        String result = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);  // Adding salt to the hash

            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            result = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Hashing algorithm not found.");
        }

        return result;
    }

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt); // Generates random 16-byte salt
        return salt;
    }
}
