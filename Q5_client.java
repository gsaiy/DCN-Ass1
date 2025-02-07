import java.io.*;
import java.net.*;
import java.util.Scanner;

class Q5_client
{
    public static void main(String args[])
    {
        try
        {
        Socket s= new Socket("localhost",5050);
        // Socket clso=s.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the operator: ");
        String str=sc.nextLine();
        System.out.println("Enter the 1st operand: ");
        String opr1=sc.nextLine();
        System.out.println("Enter the 2nd operand: ");
        String opr2=sc.nextLine();
        
        dout.writeUTF(str);
        dout.writeUTF(opr1);
        dout.writeUTF(opr2);
        // System.out.println("You: "+str);
        
        
        
        
        
        System.out.println("Server: "+din.readUTF());
        
        din.close();
        dout.close();
        s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}