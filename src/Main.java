import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree<String, String> dictionary = new BinaryTree<>();

        // Leer el archivo diccionario.txt y construir el diccionario
        try {
            File dictionaryFile = new File("diccionario.txt");
            Scanner scanner = new Scanner(dictionaryFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String englishWord = parts[0].trim().substring(1);
                String spanishWord = parts[1].trim().substring(0, parts[1].length() - 1);
                Association<String, String> association = new Association<>(englishWord.toLowerCase(), spanishWord);
                dictionary.insert(association);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo diccionario.txt no encontrado.");
            e.printStackTrace();
            return;
        }

        try {
            File textFile = new File("texto.txt");
            Scanner scanner = new Scanner(textFile);

            System.out.println("Texto traducido:");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    String translatedWord = dictionary.translate(cleanWord);
                    if (translatedWord != null) {
                        System.out.print(translatedWord + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }
                System.out.println();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo texto.txt no encontrado.");
            e.printStackTrace();
        }
    }
}
