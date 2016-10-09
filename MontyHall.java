import java.util.Scanner;

public class MontyHall
{
 /**
  * This is the main method, it is a computer version of the Monty Hall game show with the same rules
  *
  * @param args An array that is irrelevant to the program 
 */
 public static void main(String[] args)
 {
  if (args.length == 0) {
   // TODO Run interactive
   // TODO Put that in a new method 
   interactiveGame();
  }
  
  else {
  // TODO Write the simulation part
   int numSims = Integer.parseInt(args[0]);
   System.out.println("Going to run " + numSims + " simulations. ");
   
   simulateGame(numSims);
  }
 }
 public static void simulateGame(int times) {
  int swapGames = 0;
  int swapWins = 0;
  int stayGames = 0;
  int stayWins = 0;
  

  
  int userDoor;
  boolean swapOrStay;
  boolean result; 
   while (times > 0) { 
    userDoor = (int) (Math.random() * 3 + 1);
    swapOrStay = Math.random() > 0.5; // Generate a random boolean 
    result = simulateSingleGame(userDoor, swapOrStay); 
    if(result && swapOrStay) {
     System.out.println("Both true");
    }

    if (swapOrStay) {
  	  swapGames++;
	  if (result) {
      swapWins++;
      System.out.println("Hello");
     }
    }
    else {
     stayGames++;
     if (result) {
      stayWins++;
     }
    }
    
    times--;
     
   }
  
  double swapSuccessRate = (double) swapWins / swapGames;
  double staySuccessRate = (double) stayWins / stayGames;
  System.out.println("You won " + swapSuccessRate + " of the games when you swapped. ");
  System.out.println("You won " + staySuccessRate + " of the games when you stayed. "); 
  
 
 }
 
 
 
 /**
  * Simulates a single game of Monty Hall
  * @param userDoor The door the user wants to play
  * @param swapOrStay Whether the user wants to swap doors or not 
  * @return Whether the user wins 
  */
 public static boolean simulateSingleGame(int userDoor, boolean swapOrStay){
  //Choose a random car Door
  int carDoor = (int)(Math.random() * 3 + 1);
  
  // Open a goat door
  int revealDoor = revealDoor(carDoor, userDoor); 
  
  if (swapOrStay) {
   userDoor = getOtherDoor(userDoor, revealDoor); 
  
  }
  boolean result = userDoor == carDoor;
  return result; 
 }
 /**
  * Simulates a monty Hall game as played by the user.
  *
  */
 public static void interactiveGame() {
  int carDoor = (int) (Math.random() * 3 + 1);
  
  int userDoor = getUserDoor();
  
  int otherDoor = getOtherDoor(carDoor, userDoor);
  
  // Reveal a goat 

  
  System.out.println("There is a goat behind door number " +revealDoor(carDoor, userDoor));
  
  
  // Ask user if they want to switch
  boolean swap = getUserSwap();
  
  
  if (swap == true)
  {
   userDoor = otherDoor;
  }
  
  if (userDoor == carDoor)
  {
   System.out.println("Congratulations! You won a car!" );
  }
  else
  {
   System.out.println("You won a goat... Better luck next time!");
  }
 }
 
 /**
  * This method returns what door is left besides the user door and car door
  *
  * @param int1 what number the user door is 
  * @param int2 what number the car door is 
  * @return The door that has not been chosen yet 
 */
 public static int getOtherDoor(int int1, int int2)
 { 
  return 6 - int1 - int2;
 }
 /**
  * This method asks if the user would like to switch doors or not.
  *
  * @return True if they would like to switch and False otherwise 
 */
 public static boolean getUserSwap()
 {
  Scanner keyboard = new Scanner(System.in);
  System.out.println("Press 1 if you would like to switch or 0 to stay" );
  int input = keyboard.nextInt();
  
  if (input == 1){
   return true;
  }
  else {
   return false;
  }
 }
 /**
  * This method calculates and returns a door for the host to reveal as not the Grand Prize Door
  *
  * @param invalid1 A door that the host cannot open
  * @param invalid2 A door that the host cannot open (may be the same as invalid1).
  * @return The number of a door containing a goat.
  */
 public static int revealDoor(int invalid1, int invalid2)
 {
  if (invalid1 == invalid2){
   boolean randomBool = (int) Math.random() > 0.5;
   if (invalid1 == 1) {
     if (randomBool) { 
      return 2;
      }
     else {
      return 3;
     }
    }
   if (invalid1 == 2) {
     if (randomBool) { 
      return 1;
      }
     else {
      return 3; 
     }
    }
   if (invalid1 == 3) {
     if (randomBool) { 
      return 1;
      }
     else {
      return 2;
     }
    }
   }
  for (int revealDoor = 1; revealDoor < 4; revealDoor++)
  {
   if (revealDoor != invalid1 && revealDoor != invalid2)
   {
    return revealDoor; 
   }
   
  }
  return -1; 
 }
 /**
  * This method asks which door the user would like to choose of the three.
  *
  * @return Door 1, 2 or 3 depending on which door the user chooses 
  *
 */
 public static int getUserDoor()
 {
  Scanner keyboard = new Scanner(System.in);
  
  System.out.println("Choose a door 1, 2 or 3: ");
  String input = keyboard.nextLine(); 
  
  return Integer.parseInt(input);
 }
}