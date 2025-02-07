import java.io.*;
import java.net.*;

class Q5_server
{
    public static void main(String args[])
    {
        try
        {
        ServerSocket s= new ServerSocket(5050);
        Socket clso=s.accept();
        DataInputStream din = new DataInputStream(clso.getInputStream());
        DataOutputStream dout = new DataOutputStream(clso.getOutputStream());
        // String str=new String("hello");
        String operator="";
            String opr1="";
            String opr2="";
        // dout.writeUTF(str);
        // System.out.println("You: "+str);
            operator=din.readUTF();
            opr1=din.readUTF();
            opr2=din.readUTF();
        System.out.println(opr1+operator+opr2);
        int x1 = Integer.parseInt(opr1);
        int x2 = Integer.parseInt(opr2);
            try{
        if(operator.equals("+"))
        {
            int sum=x1+x2;
            dout.writeUTF(Integer.toString(sum));
        }
        else if(operator.equals("-"))
        {
            int sub=x1-x2;
            dout.writeUTF(Integer.toString(sub));
        }
        else if(operator.equals("*"))
        {
            int mul=x1*x2;
            dout.writeUTF(Integer.toString(mul));
        }
        else if(operator.equals("/"))
        {
            int div=x1/x2;
            dout.writeUTF(Integer.toString(div));
        }
    }
        catch(IOException e)
        {
            System.out.println(e);
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