import java.util.Scanner;
import java.util.Random;
public class Random_Number {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        System.out.println("  Pick a Number,any Number... ");
        System.out.println("------------------------------");
        Random rand=new Random();
        int random_number=rand.nextInt(99)+1;
        Scanner sc=new Scanner(System.in);
        System.out.print("Pick a number btw 0 to 100(You have 5 guess): ");
        int guess;
        int tries=1;
        boolean win=false;
        while(win==false){
            guess=sc.nextInt();
            if(tries < 5)
            {
                if(guess==random_number)
                {
                //System.out.println();
                System.out.println("You got it! : "+random_number);
                System.out.println("It took only " + tries + "tries.");
                win=true;
                }
                else if(guess < random_number)
                {
                System.out.println("You are too low!");
                //System.out.println();
                System.out.println("Guess Again! ");
                }
                else if(guess > random_number)
                {
                System.out.println("You are too high!");
                //System.out.println();
                System.out.println("Guess Again! ");
                }
        }
        else if(tries == 5)
        {
            if(guess == random_number)
            {
                //System.out.println();
                System.out.println("You got it! : "+random_number);
                System.out.println("It took only " + tries + "tries.");
                win=true;
            }
            if(guess != random_number)
            {
                //System.out.println();
                System.out.println("Sorry!you ran out of attempts.\nThe Correct number is: "+random_number);
                break;
            }
        }
        tries=tries+1;
    }
    
}
}

