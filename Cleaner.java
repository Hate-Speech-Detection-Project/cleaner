import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Cleaner {
  public static void main(String[] args) throws Exception {
    try (
        Scanner sc = new Scanner(new FileInputStream(args[0]), "UTF-8").useDelimiter("\n");
    		PrintWriter writer = new PrintWriter(args[1], "UTF-8");
    		) {
      while (sc.hasNext()) {
        String line = sc.next();
        String[] split = line.split("\t", 8);
        for (int i = 0; i < split.length; i++) {
          split[i] = split[i].replaceAll("\"", "\"\"").replaceAll("\\\\[a-z]", " ").replaceAll("\r", "");
        }
        writer.println("\""+String.join("\",\"", split)+"\"");
      }
    }
  }
}