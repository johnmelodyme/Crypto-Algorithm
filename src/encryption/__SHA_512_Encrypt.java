package src.encryption;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import model.__sha_512_model;

public class __SHA_512_Encrypt {
    private static Scanner __get_user_input;
    private static String __user_input, __encrypted_string;
    private static File __file;
    private static FileWriter __fileWriter;

    public static void main(final String[] args) {
        System.out.println("{ SHA 512 } \nEnter text for ecrypt:");
        // Get user input:
        __get_user_input = new Scanner(System.in);
        __user_input = __get_user_input.nextLine();
        __encrypted_string = __sha_512_model.__encryptString(__user_input);
        System.out.println("Encrypted String: " + __encrypted_string);
        __SaveTheOutput();
    }

    protected static void __SaveTheOutput() {
        try {
            __file = new File("output/SHA512/" + new Random().nextInt(7) + "_output.encrypted");
            __fileWriter = new FileWriter(__file);
            __fileWriter.write("Performed at " + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + "\n\n");
            __fileWriter.write("Original Content: " + __user_input + "\n");
            __fileWriter.write("Encrypted String: " + __encrypted_string);
            __fileWriter.close();
            __clearMemory();
        } catch (final IOException ioException) {
            System.out.println("Exception: " + ioException.toString());
        }
    }

    protected static void __clearMemory() {
        System.gc();
    }
}