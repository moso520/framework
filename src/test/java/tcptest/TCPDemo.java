package tcptest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDemo {
    public static void main(String[] args) {
//        new Thread(new DD()).start();//先开启接收端的线程
        new Thread(new TT()).start();//在开启发送端的线程
    }
}//发送端的代码如下：
class TT implements Runnable{

    @Override
    public void run() {
        try {
            //发送请求
            Socket s=  new Socket("172.20.146.159",9880);//创建一个socket绑定的端口和地址
            OutputStream oos = s.getOutputStream();//获取到输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oos));
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line= "[0,1,2,3,1,78,67,65,87,68,70,65,48,76,55,53,49,78,49,51,50,56,54,56,57,50,50,48,53,56,57,52,53,51,53,57,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,172,53,238,199,199,113,50,40,101,0,175,21,49,50,51,52,53,54,55,56,57,48,49,50,51,52,53,54,192,168,83,176,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]";
//            String line= "[0x00,0x01,0x01,0x01,0x01,0x38,0x36,0x38,0x35,0x34,0x30,0x30,0x35,0x36,0x35,0x32,0x36,0x30,0x33,0x37,0x34,0x36,0x30,0x30,0x34,0x39,0x37,0x30,0x30,0x32,0x30,0x31,0x37,0x39,0x33,0x00,0x00,0x00,0x00]";
            bw.write(line);
            bw.flush();

            //获取服务的信息
            InputStream is=s.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String info=br.readLine();
            System.out.println("我是客户端，服务器说："+info);

            //关闭资源
            br.close();
            is.close();
            s.close();

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


}//接收端的代码
class DD implements Runnable{

    @Override
    public void run() {
        try { ServerSocket ss  = new ServerSocket(8082);//创建一个serversocket其端口与发送端的端口是一样的
            Socket s = ss.accept();//侦听并接受到此套接字的连接，返回一个socket对象
            InputStream is = s.getInputStream();//获取到输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            byte[] buf = new byte[1024];//接收收到的数据
            int line = 0;
            while((line=is.read(buf))!=-1){
                System.out.println(new String(buf,0,line));//将接收到的数据在控制台输出
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}