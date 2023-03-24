import java.util.Scanner;
import java.util.ArrayList;

class UserData{
    private ArrayList<String> username =new ArrayList<>();
    private ArrayList<String> password =new ArrayList<>();
    private ArrayList<String> name=new ArrayList<>();
    private ArrayList<Double> amount=new ArrayList<>();
    private ArrayList<ArrayList<String>> transtype=new ArrayList<>(5);
    private ArrayList<ArrayList<Double>> transamount=new ArrayList<>(5);
    
    public void setUsername(String Username){
        username.add(Username);
    }
    public void setPassword(String Password){
        password.add(Password);
    }
    public void setName(String Name){
        name.add(Name);
    }
    
    public int SearchUsername(String Username){
        return username.indexOf(Username);
    }
    public String CheckPassword(int key){
        return password.get(key);
    }

    public void Deposit(Double Amount,int key){
        if(Amount<=0)
        {
            System.out.println("\nEntered amount cannot be zero or negative.");
        }
        else
        amount.set(key,amount.get(key)+Amount);
    }
    public void SetAmount(Double Amount){
        amount.add(Amount);
    }
    public void WithdrawAmount(Double Amount,int key){
        if(amount.get(key)<Amount)
        {
            System.out.println("\nAmount is larger than your Current Balance.Withdraw Failed.");
        }
        else if(Amount<=0)
        {
            System.out.println("\nEntered amount cannot be zero or negative.");
        }
        else
        {
            amount.set(key,amount.get(key)-Amount);
            setHistory(key,"Withdrawed",Amount*(-1));
            System.out.println("\nAmount has been Withdrawn.");
        }
    }
    public void TransferAmount(Double Amount,int key,String Receiver){
        if(amount.get(key)<Amount)
        {
            System.out.println("\nAmount is larger than your Current Balance.Transfer Failed.");
        }
        else if(Amount<=0)
        {
            System.out.println("\nEntered amount cannot be zero or negative.");
        }
        else
        {
            System.out.println("\nAmount of "+Amount+" has been transferred to "+Receiver+".");
            setHistory(key,"Transfered", Amount*(-1));
            amount.set(key,amount.get(key)-Amount);
        }
    }
    public Double GetBalance(int key){
        return amount.get(key);
    }
    public void setHistory(int key,String Type,Double Amount){
        for(int p=0;p<key+1;p++)
        {
            transtype.add(new ArrayList<>());
            transamount.add(new ArrayList<>());
        }
        transtype.get(key).add(Type);
        transamount.get(key).add(Amount);
    }
    public void getHistory(int key){
        for(int p=0;p<transtype.get(key).size();p++)
        {
            System.out.println((p+1)+")\t"+transtype.get(key).get(p)+"\t"+transamount.get(key).get(p));
        }
    }
}
public class Task3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        UserData data=new UserData();

        //To Show Login function.
        data.setName("Aashish");
        data.setUsername("aashish03");
        data.setPassword("1234");
        data.SetAmount(15000.00);

        int n,y=0;
        double amount;
        String username,password,name,z,receiver;
        System.out.println("\n********* Welcome *********\n");
        for(int i=1;i>0;i--)
        {
            System.out.println("1.Login\n2.Register\n3.Exit\n");
            System.out.print("Choose you option: ");
            try{
                n=Integer.parseInt(sc.nextLine());
                if(n==1)
                {
                    for(int j=1;j>0;j--)
                    {
                        System.out.print("\nUsername: ");
                        username=sc.nextLine();
                        y=data.SearchUsername(username);
                        if(y==-1)
                        {
                            System.out.println("Incorrect Username.Try Again.");
                            j++;
                            continue;
                        }
                        else
                        {
                            System.out.print("Password: ");
                            password=sc.nextLine();
                            z=data.CheckPassword(y);
                            if(z.equals(password))
                            {
                                System.out.println("\nLogin Sucessfull!!");
                            }
                            else
                            {
                                System.out.println("Incorrect Username or Password.Try Again.");
                                j++;
                            }
                        }
                    }
                }
                else if(n==2)
                {
                    System.out.print("\nEnter Name:  ");
                    name=sc.nextLine();
                    data.setName(name);
                    System.out.print("New Username:  ");
                    username=sc.nextLine();
                    data.setUsername(username);
                    System.out.print("Enter Password: ");
                    password=sc.nextLine();
                    data.setPassword(password);
                    y=data.SearchUsername(username);
                    System.out.println("\nRegistration Sucessfull!!");
                    data.SetAmount(0.0);
                }
                else if(n==3)
                {
                    System.out.println("\n********* Thank You!! *********\n");
                    System.exit(0);
                }
                else
                {
                    System.out.println("\nInvalid Option.Try Again\n");
                    i++;
                }  
                if(n==1 || n==2)
                {
                    for(int k=1;k>0;k--)
                    {
                        System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Balance\n5.Transaction History\n6.Exit");
                        System.out.print("\nChoose you option: ");
                        try{
                            n=Integer.parseInt(sc.nextLine());
                            if(n==1)
                            {
                                System.out.print("\nEnter amount to be deposited: ");
                                amount=Double.parseDouble(sc.nextLine());
                                data.Deposit(amount, y);
                                System.out.println("\nAmount has been deposited.");
                                data.setHistory(y,"Deposited",amount);
                                k++;
                            }
                            else if(n==2)
                            {
                                System.out.print("\nEnter amount you want to withdraw: ");
                                amount=Double.parseDouble(sc.nextLine());
                                data.WithdrawAmount(amount, y);
                                k++;
                            }
                            else if(n==3)
                            {
                                System.out.print("\nEnter Name of Receiver: ");
                                receiver=sc.nextLine();
                                System.out.print("Enter amount to be transferred: ");
                                amount=Double.parseDouble(sc.nextLine());
                                data.TransferAmount(amount, y,receiver);
                                k++;
                            }
                            else if(n==4)
                            {
                                System.out.println("\nYour Current Balance is: "+data.GetBalance(y));
                                k++;
                            }
                            else if(n==5)
                            {
                                System.out.println("\nYour Transaction History is:");
                                System.out.println("********************************");
                                System.out.println("Sr.no\tType\t\tAmount");
                                data.getHistory(y);
                                System.out.println("\n********************************");
                                k++;
                            }
                            else if(n==6)
                            {
                                System.out.println("\n********* Thank You!! *********\n");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("\nInvalid Option.Try Again.");
                                k++;
                            }
                        }
                        catch(NumberFormatException e){
                            System.out.println("\nInvalid Option.Try Again.");
                            k++;
                            n=0;
                        }
                    }
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("\nInvalid Option.Try Again.\n"); 
                i++;
                continue; 
            }
        }
        sc.close();
    }
}