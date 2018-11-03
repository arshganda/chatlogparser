import com.google.gson.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            JsonParser parser = new JsonParser();
            BufferedWriter out = new BufferedWriter(new FileWriter("chatLogs.txt"));
            File dir = new File("C:\\Users\\Arshdeep Ganda\\Desktop\\NA-arshganda\\chatLogs");
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File child : directoryListing) {
                    out.write(child.getName().substring(0, child.getName().length() - 5) + "\n\n");
                    JsonElement tree = parser.parse(new FileReader("C:\\Users\\Arshdeep Ganda\\Desktop\\NA-arshganda\\chatLogs\\" + child.getName()));
                    JsonObject obj = tree.getAsJsonObject();
                    JsonArray text = obj.getAsJsonArray("text");
                    for (JsonElement e : text) {
                        JsonObject eo = e.getAsJsonObject();
                        JsonElement p = eo.get("chat");
                        JsonPrimitive chatMessage = p.getAsJsonPrimitive();
                        out.write(chatMessage.getAsString() + "\n");
                    }
                    out.write("\n");
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
