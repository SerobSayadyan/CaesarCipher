/**
 * The DecipheringTextWithCaesarCipher class is reading from .txt file and deciphering the text of the file, then saving it in back in the same .txt file.
 * The decipheringAndSavingTheText method is deciphering according to instance variable settings of the class.
 * The decipheringAndSavingTheText method also creates an object of the LeftOrRightRotateCaesarCipher class and setting argument of object as needed:
 *      - the first argument is string input, and the second is rotation amount.
 *
 * Then the "if" condition checks the direction of encryption.
 * The BufferedWriter is calling method of LeftOrRightRotateCaesarCipher class with string return according to condition:
 *      - .cipheringRight for right rotation of text;
 *      - .cipheringLeft for left rotation of tex;
 * and saving the text in .txt file.
 */
package CodingSeccion.CaesarAlgorithm;


import java.io.*;

public class DecipheringTextWithCaesarCipher {
    private File inputFile;
    private String str;
    private int rotation;
    private boolean rotateDirection;

    /**
     * The setInputFile is setting the File type instance variable and converting the text of .txt file into String.
     * @param inputFile is a File type variable and is used to get as an argument the file for further working.
     */
    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
        try{
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            this.str = bufferedReader.readLine();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public void setRot(int rotation) {
        this.rotation = rotation;
    }

    public void setRotateDirection(boolean rotateDirection) {
        this.rotateDirection = rotateDirection;
    }

    public void decipheringAndSavingTheText() {
        try {
            FileWriter fileWriter = new FileWriter(inputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            var leftRight = new LeftOrRightRotateCaesarCipher(str, rotation);
            if (this.rotateDirection) {
                bufferedWriter.write(leftRight.cipheringRight());
            } else {
                bufferedWriter.write(leftRight.cipheringLeft());
            }
            leftRight = null;
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}