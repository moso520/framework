package tcptest.tcpclient;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class tcpTimeoutTest {
    @Test
    public void tcpTest() {
        // 建立tcp服务
        Socket socket = null;
        InputStream inputStream = null;
        try {
            //            socket = new Socket(InetAddress.getLocalHost(), 8005);
            socket = new Socket("172.20.146.159",9880);
            // 获取socket输出流对象
            OutputStream outputStream = socket.getOutputStream();
            // 写数据
            String data = "[170,85,59,3,0,127,0,1,3,6,1,78,67,65,87,68,70,65,48,76,55,53,49,78,49,51,50,56,54,56,57,50,50,48,53,56,57,52,53,51,53,57,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,172,53,238,199,199,113,50,40,101,0,175,21,49,50,51,52,53,54,55,56,57,48,49,50,51,52,53,54,192,168,83,71,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]";
            outputStream.write(data.getBytes());
            socket.setSoTimeout(10000);
            // 与服务器端交互
            inputStream = socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] buf = new byte[]{0,1,2,3,1,78,67,65,87,68,70,65,48,76,55,53,49,78,49,51,50,56,54,56,57,50,50,48,53,56,57,52,53,51,53,57,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,72,53,28,19,19,113,50,40,101,0,17,21,49,50,51,52,53,54,55,56,57,48,49,50,51,52,53,54,12,18,83,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        try {
            int length = inputStream.read(buf);
            int oneFlg_1 = 1;
            if (-1 != length) {
                oneFlg_1 = 1;

                String reu = new String(buf, 0, length);
//                log.info("---oneAirtightTCPClient_1 -与服务器端交互返回数据：{}",reu);
                // 截取ffcommand:result1:之后字符串
                String str = reu.substring(18, reu.length());
                if (!StringUtils.isBlank(str) && !"null".equals(str) && !"#".equals(str)) {
                    if (0 == oneFlg_1) {
                        String airtight[] = str.split(";");
//                        OneAirtight oneAirtight = new OneAirtight();
//                        oneAirtight = oneAirtightService.setOneAirtight(oneAirtight,airtight,"1");
//                        oneAirtightService.insOneAirtightNew(oneAirtight);
                        oneFlg_1 = 1;

                    }
                } else {
                    oneFlg_1 = 0;
                }
            } else {
                oneFlg_1 = 0;
            }
        } catch (IOException e) {
//            log.info("------oneAirtightTCPClient_1 接收数据超时");
            System.out.println("------oneAirtightTCPClient_1 接收数据超时");
            try {
                inputStream.close();
                socket.close();
                inputStream.close();
//                log.info("------oneAirtightTCPClient_1 关闭连接");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }
}
