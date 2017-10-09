package netty4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;

import java.net.InetSocketAddress;

public class ChatServer {
    private final ChannelGroup group = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    private Channel channel;

    public ChannelFuture start(InetSocketAddress address) {
        ServerBootstrap boot = new ServerBootstrap();
        boot.group(workerGroup);
        boot.channel(NioServerSocketChannel.class);
        boot.childHandler(createInitializer(group));

        ChannelFuture f = boot.bind(address).syncUninterruptibly();
        channel = f.channel();
        return f;
    }

    protected ChannelHandler createInitializer(ChannelGroup group2) {
        return new ChatServerInitializer(group2);
    }

    public void destroy() {
        if (channel != null) {
            channel.close();
        }
        group.close();
        workerGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        final ChatServer server = new ChatServer();
        ChannelFuture f = server.start(new InetSocketAddress(2048));// 端口2048
        System.out.println("server start................");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                server.destroy();
            }
        });
        f.channel().closeFuture().syncUninterruptibly();
    }

}