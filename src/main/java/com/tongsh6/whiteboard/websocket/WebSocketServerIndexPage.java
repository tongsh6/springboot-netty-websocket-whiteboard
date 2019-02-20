package com.tongsh6.whiteboard.websocket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tongshuanglong
 */
public class WebSocketServerIndexPage {
    private static final String NEWLINE = "\r\n";

    public static ByteBuf getContent() throws IOException {
        ClassPathResource cpr = new ClassPathResource("static/index.html");
        byte[] indexHtml = FileCopyUtils.copyToByteArray(cpr.getInputStream());
        return Unpooled.copiedBuffer(indexHtml);
    }
    private WebSocketServerIndexPage() {
        // Unused
    }
}
