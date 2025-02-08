import java.io.*;
import java.net.*;

class Q9_server
{
    public static void main(String args[])
    {
        try
        {
        ServerSocket s= new ServerSocket(5050);
        Socket clso=s.accept();
        DataInputStream din = new DataInputStream(clso.getInputStream());
        DataOutputStream dout = new DataOutputStream(clso.getOutputStream());
        String str=new String();
        String cl="";
        cl=din.readUTF();
        System.out.println("Client: "+cl);
        if(cl.equals(""))
        {
            System.out.println("String is empty");
            dout.writeUTF("string is empty");
        }
        else if(cl.length()>10)
        {
            System.out.println("String is too long");
            dout.writeUTF("string is too long");
        }
        else
        {
        StringBuffer sb=new StringBuffer(cl);
        sb.reverse();
        str=sb.toString();
        dout.writeUTF(str);
        System.out.println("You: "+str);
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