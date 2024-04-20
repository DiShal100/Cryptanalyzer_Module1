package Cryptanalyzer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;

public class UserInput {
    public static final ReadableByteChannel CHANNEL = Channels.newChannel(System.in);

    public static String getUserInput() {
        StringBuilder singleInputLine = new StringBuilder();
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (CHANNEL.read(buffer) != -1) {
                buffer.flip();
                String input = StandardCharsets.UTF_8.decode(buffer).toString();
                buffer.clear();
                singleInputLine.append(input);
                if (input.contains("\n")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return singleInputLine.toString().trim();
    }
}
