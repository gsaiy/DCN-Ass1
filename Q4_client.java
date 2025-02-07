import java.lang.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class Q4_client
{
    public static void main(String args[])
    {
        try{
DatagramSocket ds=new DatagramSocket();

InetAddress in = InetAddress.getByName("localhost");
int port = 8080;
String mess1;
Scanner sc=new Scanner(System.in);
mess1=sc.nextLine();
byte[] bf1=mess1.getBytes();
DatagramPacket dp1=new DatagramPacket(bf1,bf1.length,in,port);
ds.send(dp1);

// InetAddress in = new InetAddress("localhost");
// int port = 8080;
byte []bf=new byte[1024];
DatagramPacket dp=new DatagramPacket(bf,bf.length);
ds.receive(dp);
String mess=new String(dp.getData());
System.out.println("Server: "+mess);



        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}