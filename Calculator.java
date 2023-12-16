import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        int operator,n1,n2;
        System.out.println(" 1 - Add\n 2 - Subtraction \n 3 - Multiplication \n 4 - Division \n 5 - Modulo");
        System.out.print("Choose the Operation : ");
        Scanner sc=new Scanner(System.in);
        operator=sc.nextInt();
        System.out.print("Enter a First Number : ");
        n1=sc.nextInt();
        System.out.print("Enter a Second Number : ");
        n2=sc.nextInt();
        int result=0;
        switch (operator) {
            case 1:
                result=n1+n2;
                break;
             case 2:
                result=n1-n2;
                break;
             case 3:
                result=n1*n2;
                break; 
             case 4:
                result=n1/n2;
                break;   
             case 5:
                result=n1%n2;
                break;            
        
            default:
            System.out.println("Entered operator is not valid");
                break;
        }
        System.out.println("The Result is : "+result);
    }
    
}
