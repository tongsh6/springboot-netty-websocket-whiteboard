package com.tongsh6.whiteboard.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tongshuanglong
 */
public class WhiteBoardContext {
    private static final ConcurrentHashMap<ChannelId, Channel> channelContext = new ConcurrentHashMap<>();

    public static Channel getChannel(ChannelId id) {
        return channelContext.get(id);
    }

    public static void putChannel(ChannelId id, Channel channel) {
        channelContext.put(id, channel);
    }

    public static Collection<Channel> getAllChannel() {
        return channelContext.values();
    }

    public static void removeChannel(ChannelId id) {
        channelContext.remove(id);
    }
}
