import javax.swing.JOptionPane;

class Main {
  public static void main(String[] args) {
    Science[] science = new Science[10];

    String optionsMessage = "1] Add a question\n2]Get questions from file\n3]Take a quiz (pick questions)\n4] End"
    String option = null;

    do {
      option = JOptionPane.showMessageDialog(null, optionsMessage);

      if (option.equals("1")) {

      } else if (option.equals("2")) {
        
      } else if (option.equals("3")) {

      }
    } while (option.equals("4"));

    // Add questions to 10 question array
    // Pick questions from array
    // Make a quiz (of specific number of questions)
  }
}