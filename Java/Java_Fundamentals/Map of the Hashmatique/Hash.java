import java.util.HashMap;
public class Hash {
    public void mapOfHash() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Don't let me down", "I need a miracle");
        map.put("Into Your arms", "I'm out of my head");
        map.put("Drive", "I can't go fast enough");
        map.put("Blam", "Can't be sleepin");

        String title = map.get("Drive");
        System.out.println(title);

        for(String key : map.keySet()) {
            System.out.println(String.format("Track: %s: Lyrics %s", key, map.get(key)));
        }
        
    }
}