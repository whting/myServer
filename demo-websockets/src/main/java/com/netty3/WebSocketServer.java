package com.netty3;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class WebSocketServer {  
  
    private final int port;  
    public static ChannelHandlerContext ctx = null;  
      
    public WebSocketServer(int port) {  
        this.port = port;  
    }  
  
    public void run() {  
        // Configure the server.  
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(  
                Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));  
  
        // Set up the event pipeline factory.  
        bootstrap.setPipelineFactory(new WebSocketServerPipelineFactory());  
  
        // Bind and start to accept incoming connections.  
        bootstrap.bind(new InetSocketAddress(port));  
  
        System.out.println("Web socket server started at port " + port + '.');  
        System.out.println("Open your browser and navigate to http://localhost:" + port + '/');  
    }  
  
    public static void main(String[] args) {  
        int port;  
        if (args.length > 0) {  
            port = Integer.parseInt(args[0]);  
        } else {  
            port = 8080;  
        }  
        new WebSocketServer(port).run();  
          
          
        try {  
            Thread.sleep(30000);  
              
            while(true) {  
                  
                if (ctx != null && ctx.getChannel().isWritable()) {  
                    ctx.getChannel().write(new TextWebSocketFrame("1"));  
                }  
                  
                Thread.sleep(3000);  
                if (ctx != null && ctx.getChannel().isWritable()) {  
                    ctx.getChannel().write(new TextWebSocketFrame("2"));  
                }  
                  
                Thread.sleep(3000);  
                if(ctx != null && ctx.getChannel().isWritable()) {  
                    ctx.getChannel().write(new TextWebSocketFrame("3"));  
                    Thread.sleep(3000);  
                }  
            }  
        } catch(Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  