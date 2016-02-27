/**this program counts and outputs the top 10 words that are repeated in a txt file*/
import java.io.*;
import java.util.*; 

public class wordCount 
{
   public static void main (String[] args) throws FileNotFoundException 
   {
      Scanner in = new Scanner(new File("hamlet.txt"));
   
      HashMap<String, Integer> count = new HashMap<>();
   
      while (in.hasNext()) 
      {
         String word = in.next();
         word = strip(word);
         
         if(count.containsKey(word))//checks if word is alredy in hashmap
         {
            int num = count.get(word);//gets the number of times word was seen
              
            count.put(word, num+1);//increment word count
         }
         else
         {
            count.put(word, 1);
         }   
      } 
   
      ArrayList<WordElem> sortedHashMap = new ArrayList<>();
   
      Iterator<String> itr = count.keySet().iterator();
      String temp = "";
   
      while (itr.hasNext()) 
      {
         temp = itr.next();
      
         //puts everything into an arraylist
         sortedHashMap.add(new WordElem(temp, count.get(temp)));
      }
      
      Collections.sort(sortedHashMap);
      
      for(int i = sortedHashMap.size()-1; i>=sortedHashMap.size()-10; i--)
      {
         System.out.println(sortedHashMap.get(i));
      }
   }
 
   public static String strip(String s) 
   {
      String  res = "";
      s = s.toUpperCase();
   
      for (int i = 0; i < s.length(); i++) 
      {
         char c = s.charAt(i); 
         if (Character.isLetter(c)){   
            res= res+c;
         }
      }
      return res;   
   }   
}
