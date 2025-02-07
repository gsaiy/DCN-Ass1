import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class Q2_server
{
    public static void main(String args[])
    {
        try{
            DatagramSocket ds=new DatagramSocket(8080);
// InetAddress in = new InetAddress("localhost");
int port = 8080;
byte []bf=new byte[1024];
DatagramPacket dp=new DatagramPacket(bf,bf.length);
ds.receive(dp);
String mess=new String(dp.getData());
System.out.println("Client: "+mess);



// DatagramSocket ds1=new DatagramSocket();
InetAddress in = dp.getAddress();
// int port = 8080;
int port1=dp.getPort();
String mess1;
Scanner sc=new Scanner(System.in);
mess1=sc.nextLine();
byte[] bf1=mess1.getBytes();
DatagramPacket dp1=new DatagramPacket(bf1,bf1.length,in,port1);
ds.send(dp1);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}