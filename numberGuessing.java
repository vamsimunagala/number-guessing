import java.util.*;

public class numberGuessing
{
    static int rnum=0;  // rnum stands for the round number 
    static int finalscore=0;
    static int [] score =new int[10];

    static boolean check(int trails)
    {
        if(trails>=20)   
        {
            return true;
        }
        return false; 
    }
    static void calculatingscore(int trails,int rnum)
    {
        if(trails<=5)
          score[rnum]=5;
        else if (trails>5 && trails<=9)
          score[rnum]=4;
        else if (trails>9 && trails<=12)
          score[rnum]=3;
        else if (trails>12 && trails<=15)
          score[rnum]=2;
        else if (trails>15 && trails<=20)
          score[rnum]=1;
        else 
           return ;
    }
    static int start(int min,int max)
    {
      Scanner input=new Scanner(System.in);

      Random r=new Random();

      int rannum =min+r.nextInt(max-min);
      int trails=0;
        rnum++;
      while(true)
      {
        System.out.println("Enter the number that you are going to guess between("+min+"-"+max+") :");
         int inputnumber=input.nextInt();

         trails++;

        if(inputnumber==rannum)
        {
          calculatingscore(trails, rnum);

          System.out.println("number you are guessed is correct ::");
          System.out.println("\nno of trails you are used is :"+trails);

          System.out.println("Do you want to play the game again(y/n)?");

          String choice=input.next();

          if(choice.equals("y"))
          start(min, max);
          break;
        }
          
        else if (inputnumber<rannum)
          System.out.println("\nthe number you entered is lower ..try again to guess ");
        else 
          System.out.println("\nthe number you entered is higher..try again to guess ");

       
          
        if(check(trails))
        {
          System.out.println("you have exceeded the max number of chances to guess the nummber :");


          System.out.println("\nDo You Want to play another round(y/n)?");
          String choice= input.next();
          if(choice.equals("y"))
          start(min,max); 
          break;
        }
      }
      return rnum;
    }
public static void main(String args[])
  {
      int i;
      Scanner input=new Scanner(System.in);
      System.out.println("welcome to Number Guessing Game \n");
      System.out.println("you have to guess number in 20 trails");

      System.out.println("Enter the range that you want to guess a number :");
      System.out.print("begin: ");
      int min=input.nextInt();
      System.out.print("end :");

      int max=input.nextInt();

      int rnum=start(min,max);

      System.out.println("the total number of rounds you have played is :"+rnum);

      System.out.println("your score out of 5 is :");

      for(i=1;i<=rnum;i++)
      {
         System.out.printf("Round[%d]= %d\n",i,score[i]);
         finalscore=finalscore+score[i];
      }
      System.out.println("your total score is :"+finalscore);
    }
  }

