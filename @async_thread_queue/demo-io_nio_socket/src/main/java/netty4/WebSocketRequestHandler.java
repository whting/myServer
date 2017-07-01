package netty4;

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