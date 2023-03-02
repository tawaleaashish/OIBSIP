import javax.swing.*;
import java.util.Random;

public class NumberGuess {
    public static void main(String[] args) {
        Random a=new Random();
        int Guess=0,score=0;
        Output x=new Output();
        JOptionPane.showMessageDialog(null,"\tHow to Score?\nCorrect guess in 1st attempt gives 10 POINTS and will decrease\nas number of attempts increases,in 10th attempt will get 1 POINT.\nIf not guessed correctly no POINTS wil be given.");
        for(int round=1;round<4;round++)
        {
            int random=a.nextInt(1, 100);
            for(int attempt=1;attempt<10;attempt++)
            {
                String input=JOptionPane.showInputDialog("Guess an Integer number between 1 to 100.");
                try{
                    Guess=Integer.parseInt(input);
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