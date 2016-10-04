import java.util.Scanner;

public class MontyHall
{
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
 
 public static int getOtherDoor(int int1, int int2)
 { 
  return 6 - int1 - int2;
 }
 
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
  *This method calculates and returns a door for the host to reveal as not the Grand Prize Door
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
 
 public static int getUserDoor()
 {
  Scanner keyboard = new Scanner(System.in);
  
  System.out.println("Choose a door 1, 2 or 3: ");
  String input = keyboard.nextLine(); 
  
  return Integer.parseInt(input);
 }
}