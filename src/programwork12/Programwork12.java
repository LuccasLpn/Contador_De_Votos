package programwork12;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Programwork12 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        System.out.println("Enter file full path: ");
        String path = sc.nextLine();
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            
            Map<String, Integer> votos = new TreeMap <> ();
            
            String line = br.readLine();
            while(line != null){
                
            String [] fields = line.split(",");
            String name = fields [0];
            int count = Integer.parseInt(fields[1]);
            
            
            if(votos.containsKey(name)){
                int votes = votos.get(name);
                votos.put(name, count + votes);
            }
            else{
                votos.put(name, count);
            }
            
            line = br.readLine();
            
            }
            
            votos.keySet().forEach(key -> {
                System.out.println(key + ": " + votos.get(key));
           });

        } catch (IOException e) {
            
            System.out.println("Error: " +  e.getMessage());
            
        }
        
        
        
        
}
}
