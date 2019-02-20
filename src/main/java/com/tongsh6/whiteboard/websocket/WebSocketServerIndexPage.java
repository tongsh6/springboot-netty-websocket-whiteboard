package com.tongsh6.whiteboard.websocket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tongshuanglong
 */
public class WebSocketServerIndexPage {
    private static final String NEWLINE = "\r\n";

    public static ByteBuf getContent() throws IOException {
        InputStream is = WebSocketServerIndexPage.class.getClass().getResourceAsStream("/static/index.html");
        return Unpooled.copiedBuffer(readFully(is));
    }

    private static byte[] readFully(InputStream input) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
    }

    private WebSocketServerIndexPage() {
        // Unused
    }
}
