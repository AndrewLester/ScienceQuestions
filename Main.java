import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

class Main {
  public static void main(String[] args) {
    Science[] science = new Science[10];
    int count = 0;

    String optionsMessage = "1] Add a question\n2]Get questions from file\n3]Take a quiz (pick questions)\n4] End";
    String option = null;

    do {
      option = JOptionPane.showInputDialog(null, optionsMessage);

      if (option.equals("1")) {
        if (count > 9) {
          JOptionPane.showMessageDialog(null, "Question array is full");
          continue;
        }

        science[count] = new Science();
        count++;
      } else if (option.equals("2")) {
        int initialCount = count;
          try (Scanner scanner = new Scanner(new FileInputStream("questions.txt"));) {
            while (scanner.hasNextLine() && count <= 9) {
              String question = scanner.nextLine();
            String answer = scanner.nextLine();
            int level = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();
              science[count] = new Science(true);
              science[count].setQuestion(question);
              science[count].setAnswer(answer);
              science[count].setLevel(level);
                      JOptionPane.showMessageDialog(null, "Added question:\n" + science[count].toString());
              count++;
            }
          } catch (FileNotFoundException e) {
            System.out.println("Error finding file");
          }
JOptionPane.showMessageDialog(null, "Read " + (count - initialCount) + " questions");
      } else if (option.equals("3")) {
        String message = "";
        for (int i = 0; i < science.length; i++) {
          if (science[i] == null) continue;

            message += i + "] " + science[i].getQuestion() + "\n";
        }
        String[] questions = JOptionPane.showInputDialog(null, "Choose questions: (E.x.: 1,2,5)\n" + message).split(",");

        double correct = 0;

        for (int i = 0; i < questions.length; i++) {
          Science question = science[Integer.parseInt(questions[i])];
          String response = JOptionPane.showInputDialog(null, "Question " + i + ": " + question.getQuestion());

          if (response.equals(question.getAnswer())) {
              JOptionPane.showMessageDialog(null, "Correct!");
              correct++;
          } else {
JOptionPane.showMessageDialog(null, "Incorrect!");
          }

          JOptionPane.showMessageDialog(null, "Your score: " + (correct / questions.length));

        }
      }
    } while (!option.equals("4"));

    // Add questions to 10 question array
    // Pick questions from array
    // Make a quiz (of specific number of questions)
  }
}