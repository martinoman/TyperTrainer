import java.util.Scanner;
import java.io.Console;

public class TyperTrainer {
  String word;
  String[] attempts;
  String[] faultyAttempts;

  int numAttempts;
  int[] errors;

  Console console;

  public static void main(String[] args) {

    try{
      TyperTrainer trainer = new TyperTrainer(args[0], Integer.parseInt(args[1]));
      trainer.run();
    }catch(Exception e){
      System.out.println("Enter valid data poophead");
      System.exit(0);
    }


    //TODO tid och procentfel
  }

  public TyperTrainer(String word, int numAttempts){
    this.word = word;
    this.numAttempts = numAttempts;
    this.errors = new int[word.length() + 1];
    this.console = System.console();
    this.attempts = new String[numAttempts];
    this.faultyAttempts = new String[numAttempts];
  }

  public void run(){
    System.out.println("Type your word " + numAttempts + " times!");
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < numAttempts ; i++) {
      attempts[i] = new String(console.readPassword());
    }

    long timeNeeded =  ((System.currentTimeMillis() - startTime) /(long)1000);

    int faultyIndex = 0;
    for (String str : attempts) {
      if (!str.equals(word)) {
        faultyAttempts[faultyIndex] = str;
        faultyIndex++;
      }
    }
    System.out.println("Total time for all attempts: " + timeNeeded + " sec");
    System.out.println("Average time per attempt: " + timeNeeded/numAttempts + " sec");

    System.out.println("Faulty attempts:");

    for (String str : faultyAttempts) {
      if (str != null && !str.equals("")) {
        System.out.println(str);
      }else{
        break;
      }
    }
  }
}
