/**
 * The CipheringTextWithCaesarCipher class is ciphering the inputted text and saving it in .txt file.
 * The cipheringAndSavingTheText method is ciphering according to instance variable settings of class.
 * The cipheringAndSavingTheText method also creates an object of the LeftOrRightRotateCaesarCipher class and setting argument of object as needed:
 *      - the first argument is string input, and the second is rotation amount.
 *
 * Then the "if" condition checks the direction of encryption.
 * The BufferedWriter is calling method of LeftOrRightRotateCaesarCipher class with string return according to condition:
 *      - .cipheringRight for right rotation of text;
 *      - .cipheringLeft for left rotation of tex;
 * and saving the text in .txt file.
 */
package CodingSeccion.CaesarAlgorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CipheringTextWithCaesarCipher {
    private File file = new File("caesarText.txt");
    private String inputStr;
    private int rotation;
    private boolean rotateDirection;
    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }
    public void setRot(int rotation) {
        this.rotation = rotation;
    }

    public void setRotateDirection(boolean rotateDirection) {
        this.rotateDirection = rotateDirection;
    }

    public void cipheringAndSavingTheText() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            var leftRight = new LeftOrRightRotateCaesarCipher(inputStr, rotation);
            if (this.rotateDirection) {
                bufferedWriter.write(leftRight.cipheringRight());
            } else {
                bufferedWriter.write(leftRight.cipheringLeft());
            }
            leftRight = null;
            this.file = null;
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}