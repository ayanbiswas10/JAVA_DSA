import java.util.HashMap;
import java.util.Map;

public class basic {
    public static void main(String[] args) {
        //Syntax
        Map<String, Integer> mp=new HashMap<>();
        //Adding Elements
        mp.put("Akash",21);
        mp.put("Yash",16);
        mp.put("Lav",17);
        mp.put("Rishika",19);
        mp.put("Harry",18);
        //Getting value of a key from hashmap
        System.out.println(mp.get("Lav"));      //16
        System.out.println(mp.get("Rahul"));    //null
        //Changing/ Updating value of a key from hashmap
        mp.put("Akash",25);
        //Removing a pair from HashMap
        mp.remove("Akash");
        mp.remove("Riya");
        //Checking a key is in HashMap
        System.out.println(mp.containsKey("Akash"));
        System.out.println(mp.containsKey("Lav"));

        mp.putIfAbsent("Yamini",30);
        mp.putIfAbsent("Yash",30);

        System.out.println(mp.keySet());

        System.out.println(mp.values());

        System.out.println(mp.entrySet());

        for(String key:mp.keySet()){
            System.out.printf("Age of %s is %d\n",key,mp.get(key));
        }
        System.out.println("");
        for (Map.Entry<String,Integer> e:mp.entrySet()){
            System.out.printf("Age of %s is %d\n",e.getKey(),e.getValue());
        }
        System.out.println("");
        for (var e:mp.entrySet()){
            System.out.printf("Age of %s is %d\n",e.getKey(),e.getValue());
        }
    }
}
