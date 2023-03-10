/**
 * The MainCaesar class is the entry point of the program.
 * It creates an object of the CaesarCipher class and calls the callCaesarCipher method.
 */
package CodingSeccion.CaesarAlgorithm;

public class MainCaesar {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        cipher.callCaesarCipher();
    }
}
