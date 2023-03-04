import javax.swing.*;

import java.util.Random;

public class Task2{
    public static void main(String[] args) {
        Random a=new Random();
        int Guess=0,score=0;
        Output x=new Output();
        JOptionPane.showMessageDialog(null,"\tHow to Score?\nCorrect guess in 1st attempt gives 10 POINTS and will decrease\nas number of attempts increases,in 10th attempt will get 1 POINT.\nIf not guessed correctly no POINTS wil be given.\n(There will be 2 rounds)");
        for(int round=1;round<3;round++)
        {
            int random=a.nextInt(1, 100);
            for(int attempt=1;attempt<11;attempt++)
            {
                try{
                    String input=JOptionPane.showInputDialog("Round:  "+round+"\nGuess an Integer number between 1 to 100.");
                    if(input==null)
                    {
                        System.exit(0);
                    }
                    else
                    {
                        Guess=Integer.parseInt(input);
                    }
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Entered Input is Invalid,Try again.");
                    attempt--;
                    continue;
                }
                JOptionPane.showMessageDialog(null,x.GuessingNumber(Guess,random,round,attempt));
                if(Guess==random)
                {
                    score+=11-attempt;
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(null,"You Scored "+score+" POINTS!!");
    }
}
class Output{
    public String GuessingNumber(int Guess,int random,int round,int attempt)
    {
        if(Guess<random)
        {
            return "Round: "+round+"  Attempt: "+attempt+"\nNumber is Higher than your Guess.Try Again.";
        }
        else if(Guess>random)
        {
            return "Round: "+round+"  Attempt: "+attempt+"\nNumber is Lower than your Guess.Try Again.";
        }
        else if(Guess==random)
        {
            return "Round: "+round+"  Attempt: "+attempt+"\nCongrats your guess is CORRECT!!\n";
        }
        return null;
    }
}