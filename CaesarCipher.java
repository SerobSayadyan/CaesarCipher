/**
 * The CaesarCipher class is coordinating other classes of the program according to users input.
 * It has 2 working states, Ciphering and Deciphering.
 * Basically they are doing the same thing except:
 *      - the Ciphering (if user entered 1) is decoding/encoding the text that has been inputted by user via console and storing it in .txt file,
 *      - and the Deciphering (if user entered 2) is decoding/encoding the existing text in .txt file.
 * The other state of program is Ending program state (which can be caused by entering 0 or any other number except 1 and 2 when asked).
 *
 * When user types 1 (for Ciphering) the program will ask to type a text in english alphabet.
 * After typing the text the user will be prompted to enter the direction of rotation (left or right).
 * And, at the end, the user will be prompted to enter the amount of rotations user wants to rotate the text.
 * If the entering text field was not blank, the callCaesarCipher method will create an object of CipheringTextWithCaesarCipher class and set input parameters of the class as needed.
 *      The following object instances are of CipheringTextWithCaesarCipher class:
 *          - .setInputStr(String) is setting a string argument for further decoding/encoding.
 *          - .setRotateDirection(boolean) is setting the rotation direction according to input parameter(if 0 - to left || if 1 - to right).
 *          - .setRot(int) is setting the amount of rotations.
 *          - .cipheringAndSavingTheText() is calling the code for further encryption and saving the encrypted text in file.
 *
 *  When typed 2 (for Deciphering) the user will be prompted to enter the direction of rotation (left or right).
 *  Then the user will be prompted to enter the amount of rotations user wants to rotate the text.
 *  If the file does exist, the callCaesarCipher method will create an object of DecipheringTextWithCaesarCipher class and set input parameters of the class as needed.
 *      The following object instances are of DecipheringTextWithCaesarCipher class:
 *          - .setInputFile(File) is setting a File type argument for further decoding/encoding of .txt file.
 *          - .setRotateDirection(boolean) is setting the rotation direction according to input parameter(if 0 - to left || if 1 - to right).
 *          - .setRot(int) is setting the amount of rotations.
 *          - .decipheringAndSavingTheText() is calling the code for further encryption and saving the encrypted text in file.
 */
package CodingSeccion.CaesarAlgorithm;

import java.io.File;
import java.util.Scanner;

public class CaesarCipher {
    private final File file = new File("caesarText.txt");
    public void callCaesarCipher() {
        Scanner scSym = new Scanner(System.in);
        Scanner scNum = new Scanner(System.in);
        boolean isTrue = true;
        int ciperOrDecipher = -1;
        do {
            do {
                System.out.print("Do you want to CIPHER or DECIPHER (enter 1 - for " +
                        "CIPHERING || 2 - for DECIPHERING || enter 0 - for ENDING the program) - ");
                ciperOrDecipher = scNum.nextInt();
                System.out.println();
            } while ((ciperOrDecipher > 2) && (ciperOrDecipher < 0));
            if (ciperOrDecipher == 1) { // CIPHERING
                String str;
                System.out.print("Please enter the text you want to cipher (in english alphabet) - ");
                str = scSym.nextLine();
                System.out.println();
                int rotDir;
                int rot = 0;
                do {
                    System.out.print("Enter the rotation direction (1 - for RIGHT and 0 - for LEFT) - ");
                    rotDir = scNum.nextInt();
                    System.out.println();
                } while (rotDir < 0 || rotDir > 1);
                do {
                    System.out.print("Now please enter the amount of rotations you want cipher to turn - ");
                    rot = scNum.nextInt();
                    System.out.println();
                } while (rot <= 0);
                if (!str.isBlank()) {
                    var caesar = new CipheringTextWithCaesarCipher();
                    caesar.setInputStr(str);
                    if (rotDir == 1) {
                        caesar.setRotateDirection(true);
                    } else {
                        caesar.setRotateDirection(false);
                    }
                    caesar.setRot(rot);
                    caesar.cipheringAndSavingTheText();
                    System.out.println();
                } else {
                    System.out.println("The field is blank");
                }
            } else if (ciperOrDecipher == 2){ // DECIPHERING
                int rotDir;
                int rot = 0;
                do {
                    System.out.print("Enter the rotation direction (1 - for RIGHT and 0 - for LEFT) - ");
                    rotDir = scNum.nextInt();
                    System.out.println();
                } while (rotDir < 0 || rotDir > 1);
                do {
                    System.out.print("Now please enter the amount of rotations you want cipher to turn - ");
                    rot = scNum.nextInt();
                    System.out.println();
                } while (rot <= 0);
                if (this.file.exists()) {
                    var caesarDecode = new DecipheringTextWithCaesarCipher();
                    caesarDecode.setInputFile(file);
                    if (rotDir == 1) {
                        caesarDecode.setRotateDirection(true);
                    } else {
                        caesarDecode.setRotateDirection(false);
                    }
                    caesarDecode.setRot(rot);
                    caesarDecode.decipheringAndSavingTheText();
                    System.out.println();
                } else {
                    System.out.println("The file does not exist");
                }
            } else {
                isTrue = false;
            }
        }while(isTrue);
        System.out.println("\nThe program finished successfully!\n");
    }
}
