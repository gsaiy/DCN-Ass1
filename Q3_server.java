import java.io.*;
import java.net.*;

class Q3_server
{
    public static void main(String args[])
    {
        try
        {
        ServerSocket s= new ServerSocket(5050);
        Socket clso=s.accept();
        DataInputStream din = new DataInputStream(clso.getInputStream());
        DataOutputStream dout = new DataOutputStream(clso.getOutputStream());
        String str=new String("hello");
        String cl="";
        while(/*!str.equalsIgnoreCase("bye"))*/ !cl.equalsIgnoreCase("bye"))
        {
        // Scanner sc=new Scanner(System.in);
        // str=sc.nextLine();
        cl=din.readUTF();
        dout.writeUTF("You have Sent to Server : "+cl);
        // System.out.println("You: "+str);
            
        // System.out.println("Client: "+cl);
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