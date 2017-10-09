package com.androidSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class androidSocketServer {
	private static final int PORT = 9999;

	public static void main(String[] args) throws NoSuchAlgorithmException {
		boolean hasHandshake = false;
		
		try {
			// 实例化服务器套接字 设置端口号9999
			ServerSocket server = new ServerSocket(PORT);
			while (true) {
				Socket socket = server.accept();
				
				 InputStream in = socket.getInputStream();
                 
				 OutputStream socketOut = socket.getOutputStream();
				 PrintWriter pw = new PrintWriter(socketOut, true);
				 
	                //读入缓存
	                byte[] buf = new byte[1024];
	                //读到字节
	                int len = in.read(buf, 0, 1024);
	                //读到字节数组
	                byte[] res = new byte[len];
	                System.arraycopy(buf, 0, res, 0, len);
	                String key = new String(res);
	                if(!hasHandshake && key.indexOf("Key") > 0){
	                    //握手
	                    key = key.substring(0, key.indexOf("==") + 2);
	                    key = key.substring(key.indexOf("Key") + 4, key.length()).trim();
	                    key+= "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
	                    MessageDigest md = MessageDigest.getInstance("SHA-1");  
	                    md.update(key.getBytes("utf-8"), 0, key.length());
	                    byte[] sha1Hash = md.digest();  
	                        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();  
	                    key = encoder.encode(sha1Hash);  
	                    pw.println("HTTP/1.1 101 Switching Protocols");
	                    pw.println("Upgrade: websocket_tomcat");
	                    pw.println("Connection: Upgrade");
	                    pw.println("Sec-WebSocket-Accept: " + key);
	                    pw.println();
	                    pw.flush();
	                    // hasHandshake = true;
	                }
	                
				// 返回客户端(示例使用android)：no
//				BufferedWriter writer = new BufferedWriter(
//						new OutputStreamWriter(socket.getOutputStream()));
//				// 写字符串
//				writer.write("这是一段来自服务器的问候：Hello沃德！");
//				writer.flush();
//				writer.close();
	            
	                
	            // 返回客户端(使用websocket)：ok
				ByteBuffer byteB = ByteBuffer.allocate(256);
				byteB.put("aaa".getBytes());
				responseClient(socket, byteB, true);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void responseClient(Socket socket,ByteBuffer byteBuf, boolean finalFragment)
			throws IOException {
		OutputStream out = socket.getOutputStream();
		int first = 0x00;
		// 是否是输出最后的WebSocket响应片段
		if (finalFragment) {
			first = first + 0x80;
			first = first + 0x1;
		}
		out.write(first);

		if (byteBuf.limit() < 126) {
			out.write(byteBuf.limit());
		} else if (byteBuf.limit() < 65536) {
			out.write(126);
			out.write(byteBuf.limit() >>> 8);
			out.write(byteBuf.limit() & 0xFF);
		} else {
			// Will never be more than 2^31-1
			out.write(127);
			out.write(0);
			out.write(0);
			out.write(0);
			out.write(0);
			out.write(byteBuf.limit() >>> 24);
			out.write(byteBuf.limit() >>> 16);
			out.write(byteBuf.limit() >>> 8);
			out.write(byteBuf.limit() & 0xFF);

		}

		// Write the content
		out.write(byteBuf.array(), 0, byteBuf.limit());
		out.flush();
	}

}
