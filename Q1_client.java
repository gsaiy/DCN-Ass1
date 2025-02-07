import java.io.*;
import java.net.*;
import java.util.Scanner;

class Q1_client
{
    public static void main(String args[])
    {
        try
        {
        Socket s= new Socket("localhost",5050);
        // Socket clso=s.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        String str=new String("hello");
        while(!str.equalsIgnoreCase("bye"))// && !din.readUTF().equalsIgnoreCase("bye"))
        {
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
        dout.writeUTF(str);
        System.out.println("You: "+str);
        System.out.println("Server: "+din.readUTF());
        }
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