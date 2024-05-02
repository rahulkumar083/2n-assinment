import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Prompt user for input
        String text = promptUser();
        if (text != null) {
            // Split text into words
            String[] words = splitText(text);
            // Count words
            int wordCount = countWords(words);
            // Display the total count of words to the user
            System.out.println("Total number of words: " + wordCount);
        }
    }

    public static String promptUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter '1' to input text or '2' to provide a file: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            System.out.println("Enter the text: ");
            return scanner.nextLine();
        } else if (choice.equals("2")) {
            System.out.println("Enter the file path: ");
            String filePath = scanner.nextLine();
            File file = new File(filePath);
            try {
                Scanner fileScanner = new Scanner(file);
                StringBuilder fileContent = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    fileContent.append(fileScanner.nextLine()).append("\n");
                }
                fileScanner.close();
                return fileContent.toString();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return null;
            }
        } else {
            System.out.println("Invalid choice.");
            return null;
        }
    }

    public static String[] splitText(String text) {
        // Split text into words using space or punctuation as delimiters
        return text.split("\\b\\W+\\b");
    }

    public static int countWords(String[] words) {
        // Initialize a counter variable
        int wordCount = 0;
        // Iterate through the array of words and increment the counter
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
