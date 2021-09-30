import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;
public class ceasarcypher {
    public static String abc = " abcdefghijklmnopqrstuvwxyzæøå";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        System.out.println("Please choose if you want to use the number cypher or ceasar cypher\n Press 1 for Standard Decryption, Press 2 for Advanced Decryption");
        int PickYourPoison = scanner.nextInt();
        do {
            if (PickYourPoison == 1) {
                numberCypher();
                isValid = true;
            } else if (PickYourPoison == 2) {
                CeasarEncoder();
                isValid = true;
            } else {
                System.out.println("Please write either 1 or 2, shouldnt be that difficult");
                PickYourPoison = scanner.nextInt();
            }
        } while (!isValid);

    }


    public static void numberCypher() {

        Scanner sc = new Scanner(System.in);
        System.out.println("What word would you like to encode?");
        String EncodedWord = sc.nextLine();
        EncodedWord.toLowerCase();
        EncodedWord = EncodedWord.toLowerCase();
        int[] EncoderIndex = new int[EncodedWord.length()];
        for (int i = 0; i < EncodedWord.length(); i++) {
            EncoderIndex[i] = abc.indexOf(EncodedWord.charAt(i));
        }
        for (int i = 0; i < EncoderIndex.length; i++) {
            System.out.println(EncoderIndex[i]);
        }
        System.out.println("Type the numbers you want decoded");
        int[] DecoderIndex = new int[EncoderIndex.length];
        for (int i = 0; i < DecoderIndex.length; i++) {
            DecoderIndex[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0; i < DecoderIndex.length; i++) {
            System.out.print(abc.charAt(DecoderIndex[i]));
        }

    }

    public static void CeasarEncoder() {
        System.out.println("Write the text you want to encode");
        Scanner scanner = new Scanner(System.in);
        String EncodedString = scanner.nextLine();
        System.out.println("Enter the digits you want to shift");
        int ShiftValue = scanner.nextInt();
        String CypherString = "";
        char alphabet;

        for (int i = 0; i < EncodedString.length(); i++) {
            alphabet = EncodedString.charAt(i);
            if (EncodedString.charAt(i) == EncodedString.toLowerCase().charAt(i)) {
                if (alphabet >= 'a' && alphabet <= 'å') {
                    alphabet = (char) (alphabet + ShiftValue);
                }
                if (alphabet > 'å') {
                    alphabet = (char) (alphabet + 'a' - 'å' - 1);
                }
                CypherString = CypherString + alphabet;
            } else if (EncodedString.charAt(i) == EncodedString.toUpperCase().charAt(i)) {
                if (alphabet >= 'A' && alphabet <= 'Å') {
                    alphabet = (char) (alphabet + ShiftValue);
                }
                if (alphabet > 'Å') {
                    alphabet = (char) (alphabet + ShiftValue);
                }
                CypherString = CypherString + alphabet;


            }


        }
        System.out.println(CypherString);
    }
}

