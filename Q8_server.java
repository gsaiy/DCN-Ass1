import java.lang.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Q8_server
{
    public static void main(String args[])
    {
        try{
            DatagramSocket ds=new DatagramSocket(8080);
int port = 8080;
byte []bf=new byte[1024];
DatagramPacket dp=new DatagramPacket(bf,bf.length);
ds.receive(dp);
String mes = new String(dp.getData(),0,dp.getLength());
// int x1 = Integer.parseInt(mes);
String[] arr=mes.split(",");

int sum=0;
// int min=Integer.parseInt(arr[0]);
for(int i=0;i<arr.length;i++)
{
    if(Integer.parseInt(arr[i])%2 == 0)
    {
        sum+=Integer.parseInt(arr[i]);
    }
    
}
// System.out.println("Client: "+max);

InetAddress in = dp.getAddress();
int port1=dp.getPort();
String mess1=Integer.toString(sum)+" is sum of even digits";
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