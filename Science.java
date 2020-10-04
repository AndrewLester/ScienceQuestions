import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

public class Science {
  private String question;
  private String answer;
  private int level;

  public Science() {
    setQuestion();
    setAnswer();
    setLevel();
  }

  public Science(boolean info) {
  }

  private String setQuestion() {
    question = JOptionPane.showInputDialog(null, "What is the science question you would like to answer?");

  return question;
  }

  private String setAnswer() {
    answer = JOptionPane.showInputDialog(null, "What is the answer to the question?");

    return answer;
  }

  private int setLevel() {
    level = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the question's level?"));

    return level;
  }

  public String toString() {
    return "Question: " + question + "\nAnswer: " + answer + "\nLevel: " + level;
  }

  public void saveQuestion() {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(new FileOutputStream("questions.txt", true));
      writer.println(question);
      writer.println(answer);
      writer.println(level);
      writer.println("********");
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error finding file");
    }
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public int getLevel() {
    return level;
  }


}