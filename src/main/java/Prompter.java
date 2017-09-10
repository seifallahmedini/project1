import java.util.Scanner;
import java.util.Random;
public class Prompter{
  private Jar jar;
  Scanner sc = new Scanner(System.in);
  
  public Prompter(Jar jar){
    this.jar = jar;
  }
  
  //no changes needed
  public void displayAdminSetup(){
     System.out.println("Administrator Setup:");
     System.out.println("=========================");
     System.out.print("What type of item?: ");
     jar.setTypeOfItems(sc.nextLine());
     System.out.printf("What is the maximum amount of %s?: ",jar.getTypeOfItems());
     jar.setMaxItemsAllowed(sc.nextInt());
     System.out.printf("%n%n%n");
  }
 
  //no changes needed
  public void displayPlayerGame(){
     System.out.println("Player:");
      System.out.println("===============");
      System.out.printf("Your goal is to guess how many %s are in the jar. Your guess should be between 1 and %d%n",jar.getTypeOfItems(),jar.getMaxItemsAllowed()); 
  }
  
  
  //no changes needed
  public void moreThanMax(int guessedNumber){
    while(guessedNumber > jar.getMaxItemsAllowed()){
        System.out.printf("Your guess must be less than %d: ",jar.getMaxItemsAllowed());
        guessedNumber = sc.nextInt();
    }
  }
  
  public void equalZero(int guessedNumber){
    throw new IllegalArgumentException("The item capacity must be greater than zero!");
  }
  
  public void guessHint(int guessedNumber,int randomNumber){
    if(guessedNumber > randomNumber){
      System.out.println("Your guess is too high");
    }else if(guessedNumber < randomNumber){
      System.out.println("Your guess is too low");
    }
  }
  
  
  
  public void startTheGame(){
    int randomNumber = jar.fill();
    System.out.printf("How many %s are in the jar? Pick a number between 1 and %d: ",jar.getTypeOfItems(),jar.getMaxItemsAllowed());
    int guessedNumber = sc.nextInt();
    if(guessedNumber < jar.getMaxItemsAllowed() && guessedNumber != 0){
      guessHint(guessedNumber,randomNumber);
    }
    int attempt = 1;
    while(guessedNumber != randomNumber){
      if(guessedNumber > jar.getMaxItemsAllowed()){
        while(guessedNumber > jar.getMaxItemsAllowed()){
          System.out.printf("Your guess must be less than %d: ",jar.getMaxItemsAllowed());
          guessedNumber = sc.nextInt();
          if(guessedNumber < jar.getMaxItemsAllowed() && guessedNumber != 0){
            guessHint(guessedNumber,randomNumber);
            break;
          }
        }
      }else if(guessedNumber == 0){
        throw new IllegalArgumentException("The item capacity must be greater than zero!");
      }else{
        System.out.printf("How many %s are in the jar? Pick a number between 1 and %d: ",jar.getTypeOfItems(),jar.getMaxItemsAllowed());
         guessedNumber = sc.nextInt();
        if(guessedNumber < jar.getMaxItemsAllowed() && guessedNumber != 0){
          guessHint(guessedNumber,randomNumber);
        }  
        attempt++;
      } 
    }
    System.out.printf("You got it in "+attempt+" attempts");
  }
  
}