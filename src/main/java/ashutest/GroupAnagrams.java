package ashutest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public static final HashMap<CharSequence, List<String>> map = new HashMap<>();
    static public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> llstr = new ArrayList<>();
        for(String str: strs )
        {
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (!map.containsKey(key))
            {
                List<String > lstr = new ArrayList<String>();
                lstr.add(str);
                map.put(key,lstr);
            }
            else
            {
                map.get(arr).add(str);
            }
            //System.out.println("Key:" + str + ":" + code);
        }
        return new ArrayList(map.values());

    }
    public static void main(String [] args )
    {
        String [] strs = {"ate","eat","nest","west"};
        groupAnagrams(strs);
    }
}