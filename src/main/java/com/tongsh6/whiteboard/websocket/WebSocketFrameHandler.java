package com.tongsh6.whiteboard.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.Collection;
import java.util.Locale;

/**
 * @author tongshuanglong
 */
public class WebSocketFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        // ping and pong frames already handled
        System.out.println("log:" + this.getClass().getSimpleName() + ">>>" + "channelRead0");
        if (frame instanceof TextWebSocketFrame) {
            // Send the uppercase string back.
            String request = ((TextWebSocketFrame) frame).text();
            System.out.println("request:" + request);
            Collection<Channel> channels = WhiteBoardContext.getAllChannel();
            for (Channel channel : channels) {
                channel.writeAndFlush(new TextWebSocketFrame(request));
            }
        } else {
            String message = "unsupported frame type: " + frame.getClass().getName();
            throw new UnsupportedOperationException(message);
        }
    }
}
