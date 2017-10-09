package com.netty4;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * Handles handshakes and messages
 */
public class WebSocketRequestHandler extends WebSocketServerProtocolHandler {

	public WebSocketRequestHandler(String websocketPath) {
		super(websocketPath);
		// TODO Auto-generated constructor stub
	}

	/** 未能覆盖 */
//	static ChannelHandler forbiddenHttpRequestResponder() {
//        return new ChannelInboundHandlerAdapter() {
//            @Override
//            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                if (msg instanceof FullHttpRequest) {
//                    ((FullHttpRequest) msg).release();
//                    FullHttpResponse response =
//                            new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.FORBIDDEN);
//                    ctx.channel().writeAndFlush(response);
//                } else {
//                    ctx.fireChannelRead(msg);
//                }
//            }
//        };
//    }

}