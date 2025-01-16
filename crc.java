import java.util.Scanner;

public class crc {
    static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }
    static String computeCRC(String data, String generator) {
        int genLen = generator.length();
        String dividend = data + "0".repeat(genLen - 1); // Append 0s based on generator length

        for (int i = 0; i <= dividend.length() - genLen; i++) {
            if (dividend.charAt(i) == '1') { // Perform XOR only if current bit is 1
                dividend = dividend.substring(0, i) +
                        xor(dividend.substring(i, i + genLen), generator) +
                        dividend.substring(i + genLen);
            }
        }
        return dividend.substring(dividend.length() - genLen + 1); // Return remainder
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input data and generator polynomial
        System.out.print("Enter data to be transmitted: ");
        String data = sc.next();
        System.out.print("Enter the generator polynomial: ");
        String generator = sc.next();

        // Compute CRC at sender's end
        String crc = computeCRC(data, generator);
        String codeword = data + crc;
        System.out.println("Data padded with CRC: " + codeword);
        System.out.println("CRC (Check value): " + crc);

        // Simulate receiver end
        System.out.print("Enter the received data: ");
        String received = sc.next();
        String receivedCRC = computeCRC(received, generator);

        // Check for errors
        System.out.println("Data received: " + received);
        if (receivedCRC.equals("0".repeat(generator.length() - 1))) {
            System.out.println("No error detected");
        } else {
            System.out.println("Error detected in received data");
        }
        sc.close();
    }
}
