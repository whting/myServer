package netty4;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class ChatServerInitializer extends ChannelInitializer<Channel> {
 
    private final ChannelGroup group;
    public ChatServerInitializer(ChannelGroup group) {
        super();
        this.group = group;
    }
 
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
         
        pipeline.addLast(new HttpServerCodec());
         
        pipeline.addLast(new ChunkedWriteHandler());
         
        pipeline.addLast(new HttpObjectAggregator(64*1024));
         
        pipeline.addLast(new HttpRequestHandler("/ws"));// TODO http://localhost:2048/ws
        
        // 需要自定义管道pipeline
        // pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(new WebSocketRequestHandler("/ws"));// TODO [http,ws]都经过此Handler

        pipeline.addLast(new TextWebSocketFrameHandler(group));// TODO ws://localhost:2048/ws
    }
 
}