/**
 * The LeftOrRightRotateCaesarCipher class is rotating left or right the text.
 * The LeftOrRightRotateCaesarCipher(String, int) is getting as an argument the string and the amount of rotation.
 * The cipheringLeft method is rotating the text to left according to Caesar Cipher and returns changed text as a String.
 * The cipheringRight method is rotating the text to right according to Caesar Cipher and returns changed text as a String.
 */
package CodingSeccion.CaesarAlgorithm;

public class LeftOrRightRotateCaesarCipher {
    private String str;
    private final int rotation;
    final private char firstUpper = 'A';
    final private char lastUpper = 'Z';
    final private char firstLower = 'a';
    final private char lastLower = 'z';
    final private char firstDigit = '0';
    final private char lastDigit = '9';
    final private int alphabetCount = 26;
    final private int digitCount = 10;
    LeftOrRightRotateCaesarCipher(String str, int rotation){
        this.str = str;
        this.rotation = rotation;
    }
    public String cipheringLeft() {

        char[] strChars = this.str.toCharArray();
        int n = strChars.length;
        this.str = null;
        int symAddCount = forSymbols();
        int numAddCount = forNumbers();
        for (int i = 0; i < n; i++) {
            if ((strChars[i] >= firstUpper) && (strChars[i] <= lastUpper)) {
                if ((strChars[i] - symAddCount) < firstUpper) {
                    strChars[i] += alphabetCount - symAddCount;
                } else {
                    strChars[i] -= symAddCount;
                }
            } else if ((strChars[i] >= firstLower) && (strChars[i] <= lastLower)) {
                if ((strChars[i] - symAddCount) < firstLower) {
                    strChars[i] += alphabetCount - symAddCount;
                } else {
                    strChars[i] -= symAddCount;
                }
            } else if ((strChars[i] >= firstDigit) && (strChars[i] <= lastDigit)) {
                if ((strChars[i] - numAddCount) < firstDigit) {
                    strChars[i] += digitCount - numAddCount;
                } else {
                    strChars[i] -= numAddCount;
                }
            }
        }
        return new String(strChars);
    }

    public String cipheringRight() {
        char[] strChars = this.str.toCharArray();
        int n = strChars.length;
        this.str = null;
        int symAddCount = forSymbols();
        int numAddCount = forNumbers();
        for (int i = 0; i < n; i++) {
            if ((strChars[i] >= firstUpper) && (strChars[i] <= lastUpper)) {
                if ((strChars[i] + symAddCount) > lastUpper) {
                    strChars[i] += symAddCount - alphabetCount;
                } else {
                    strChars[i] += symAddCount;
                }
            } else if ((strChars[i] >= firstLower) && (strChars[i] <= lastLower)) {
                if ((strChars[i] + symAddCount) > lastLower) {
                    strChars[i] += symAddCount - alphabetCount;
                } else {
                    strChars[i] += symAddCount;
                }
            } else if ((strChars[i] >= firstDigit) && (strChars[i] <= lastDigit)) {
                if ((strChars[i] + numAddCount) > lastDigit) {
                    strChars[i] += numAddCount - digitCount;
                } else {
                    strChars[i] += numAddCount;
                }
            }
        }
        return new String(strChars);
    }

    private int forSymbols() {
        int rotation = this.rotation;
        return rotation % alphabetCount;
    }
    private int forNumbers() {
        int rotation = this.rotation;
        return rotation % digitCount;
    }
}