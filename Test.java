import java.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.*;

public class Test {

  public static void main(String[] args) {
    ArrayList<String> lines = new ArrayList<>();
    try {
      FileReader fr = new FileReader(args[0]);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while((line = br.readLine()) != null) {
        lines.add(line);
      }
      br.close();
    } catch(Exception e) {}


    ArrayList<ArrayList<Integer>> data = new ArrayList<>();
    for(String line : lines) {
      ArrayList<Integer> a = new ArrayList<>();
      for(String s : line.split(" ")) {
        a.add(Integer.parseInt(s));
      }
      data.add(a);
    }

    System.out.println(data);

  }

}
