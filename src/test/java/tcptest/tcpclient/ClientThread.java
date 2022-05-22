//package tcptest.tcpclient;
//
//
//import com.teruisa.jinji100.utils.SocketUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.*;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
///**
// * socket 长连接：连接建立后不会主动断开，可以持续收发消息
// */
//public class ClientThread {
//
//    private final Logger logger = LoggerFactory.getLogger(ClientThread.class);
//    private String hosts;
//    private int port;
//    private Socket socket = null;
//    private OutputStream os = null;
//    private InputStream is = null;
//
//    public ClientThread(String hosts, int port) {
//        this.hosts = hosts;
//        this.port = port;
//        try {
//            this.socket = new Socket(hosts, port);
//            this.os = socket.getOutputStream();
//            this.is = socket.getInputStream();
//            SocketThread socketThread = new SocketThread();
//            socketThread.start();
//            logger.info("创建socket连接成功，address：{}:{}", hosts, port);
//        } catch (UnknownHostException e) {
//            logger.error("创建socket连接UnknownHost异常", e);
//        } catch (IOException e) {
//            logger.error("创建socket连接IO异常", e);
//        }
//    }
//
//    /**
//     * 办公灯光
//     * @param msg
//     * @return
//     */
//    public String sendLampComd(String msg) {
//        String receiveMsg = "";
//        PrintWriter pw = null;
//        BufferedReader br = null;
//        try {
//            pw = new PrintWriter(os);
//            pw.write(msg);
//            pw.flush();
//            socket.shutdownOutput();
//            // 从服务器接收的信息
//            br = new BufferedReader(new InputStreamReader(is));
//            receive(br);
//        } catch (IOException e) {
//            logger.error("IOException", e);
//        } finally {
//            // 关闭资源
//            SocketUtil.close(br, null, is, os, socket);
//        }
//        return receiveMsg;
//    }
//
//    /**
//     * 会议室灯光
//     * @param msg
//     * @return
//     */
//    public String sendMeetingComd(String msg) {
//        byte[] data = HexUtil.hexStrToBinaryStr(msg);
//        return sendCurtainComd(data);
//    }
//
//    /**
//     * 窗帘
//     * @param data
//     * @return
//     */
//    public String sendCurtainComd(byte[] data) {
//        String receiveMsg = "";
//        BufferedReader br = null;
//        try {
//            os.write(data);
//            socket.shutdownOutput();
//            br = new BufferedReader(new InputStreamReader(is));
//            receive(br);
//        } catch (IOException e) {
//            logger.error("IOException", e);
//        } finally {
//            // 关闭资源
//            SocketUtil.close(br, null, is, os, socket);
//        }
//        return receiveMsg;
//    }
//
//    private String receive(BufferedReader br) throws IOException {
//        // 从服务器接收的信息
//        String receiveMsg = "";
//        String reply;
//        while((reply = br.readLine()) != null){
//            logger.info("设备中控返回信息：{}", reply);
//            receiveMsg = reply;
//        }
//        return receiveMsg;
//    }
//
//    /**
//     * 发送心跳包
//     */
//    /*public void sendHeartbeat() {
//        try {
//            String heartbeat = "ping\r\n";
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//                        try {
//                            Thread.sleep(10 * 1000);// 10s发送一次心跳
//                            os.write(heartbeat.getBytes());
//                            os.flush();
//                        } catch (Exception e) {
//                            logger.error("发送心跳异常", e);
//                        }
//                    }
//                }
//            }).start();
//        } catch (Exception e) {
//            logger.error("发送心跳异常", e);
//        }
//    }*/
//
//    private class SocketThread extends Thread {
//        @Override
//        public void run() {
//            long startTime = System.currentTimeMillis();
//            //sendHeartbeat();
//            while (true) {
//                try {
//                    if (socket == null || socket.isClosed()) {
//                        socket = new Socket(hosts, port); // 连接socket
//                        os = socket.getOutputStream();
//                    }
//                    Thread.sleep(100);
//                    is = socket.getInputStream();
//                    int size = is.available();
//                    if (size <= 0) {
//                        if ((System.currentTimeMillis() - startTime) > 3 * 10 * 1000) { // 如果超过30秒没有收到服务器发回来的信息，说明socket连接可能已经被远程服务器关闭
////                            socket.close(); // 这时候可以关闭socket连接
////                            startTime = System.currentTimeMillis();
//                        }
//                        continue;
//                    } else {
//                        startTime = System.currentTimeMillis();
//                    }
//                    byte[] resp = new byte[size];
//                    is.read(resp);
//                    String response = new String(resp, "utf-8");
//                    logger.info("连接成功：{}：{}，server端返回结果：{}", hosts, port, response);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    try {
//                        socket.close();
//                        is.close();
//                        os.close();
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//}
