import java.io.*;

/**
 * Created by chien on 7/20/2017.
 */
public class ReadFile {
    private static final String FILENAME = "F:\\Chiennv\\KI4\\LearnTreeHouse\\gitVideo1.txt";
    public static void main(String[] args){
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            //Ghi kết quả ra file
            Writer writer = new FileWriter("F:\\Chiennv\\KI4\\LearnTreeHouse\\gitVideo1Convert.txt");
            BufferedWriter bw=new BufferedWriter(writer);
            String sCurrentLine;
            String sentence="";
            while((sCurrentLine = br.readLine()) != null){
                String[] word = sCurrentLine.split("\\s");
                for(String w: word){
                    boolean isWord = filterWord(w);
                    boolean isEndSen = filterEndSen(w);
                    if(isWord){
                        sentence += w + " ";
                    }
                    if(isEndSen){
                        bw.write(sentence);
                        bw.newLine();
                        bw.newLine();
                        sentence ="";
                    }

                }
            }
            bw.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static boolean filterWord(String s){
        if(s.charAt(0) >=48 && s.charAt(0) <=57){
            return false;
        }
        return true;
    }
    public static boolean filterEndSen(String s){
        int length = s.length();
        if(s.charAt(length -1) == (int) '.'){
            return true;
        }
        return false;
    }
}
