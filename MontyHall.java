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