package tcptest.tcpclient;

import org.apache.commons.net.telnet.TelnetClient;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Component
public class TcpTest {
    public static void main(String[] args) {
//        new Thread(new DD()).start();//先开启接收端的线程
        new Thread(new CC()).start();//在开启发送端的线程
    }
}
class CC implements Runnable{
    @Override
    public void run() {
        //采用TelnetClient方式链接
//        TelnetClient tcpNet = new TelnetClient();
        //采用Socket方式链接
        Socket tcpNet = new Socket();
        try {
//            tcp访问地址和端口
            //采用TelnetClient方式链接
//            tcpNet.connect("127.0.0.1", 30311);
//            InputStream inputStream = tcpNet.getInputStream();
            //采用Socket方式链接
            tcpNet = new Socket("172.20.146.159",9880);
            InputStream inputStream = tcpNet.getInputStream();
            byte[] b = new byte[1024];
            int size;
            while (true) {
                System.out.println("----------获取TCP信息开始----------");
                byte[] line= new byte[]{0,1,2,3,1,78,67,65,87,68,70,65,48,76,55,53,49,78,49,51,50,56,54,56,57,50,50,48,53,56,57,52,53,51,53,57,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,22,53,22,22,22,113,50,40,101,0,22,21,49,50,51,52,53,54,55,56,57,48,49,50,51,52,53,54,22,22,83,22,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                size = inputStream.read(line);
                String aa = new String(line, 0, size);
                System.out.println("tcp获取字符长度:" + size);
                System.out.println("tcp获取的条码：" + aa);
                //建立客户端信息输出流（客户端向服务端发送信息）
                OutputStream pt = tcpNet.getOutputStream();
                String printText = "客户端已成功接收信息！";
                pt.write(printText.getBytes());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("++++++故障重新访问++++");
            //断开tcp后自动重新链接
            //断开后两秒后重新链接tcp  Socket方式
//            tcpNet.connect(tcpNet.getRemoteSocketAddress(), 2000);
            //断开后重新链接tcp  TelnetClient方式
            //tcpNet.disconnect();
        }
    }


}
