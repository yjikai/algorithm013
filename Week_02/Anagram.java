/**
 * 有效的字母异位词
 * leetcode 242
 */
public class Anagram{
    public boolean isAnagram(String s, String t) {

        // 创建一个hashMap ,遍历第一个数组，然后将每个字符为key,出现的次数为value,进行保存。
        // 然后遍历第二个数组，如果hashMap中存在字符则value减一，不存在则直接返回，
        // 最后直接遍历hashMap，看是否存在不为0的value，如果存在，则返回false，反之返回true.
        HashMap<Character,Integer> buffMap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(buffMap.containsKey(s.charAt(i))){
                buffMap.put(s.charAt(i),buffMap.get(s.charAt(i))+1);
            }else{
                buffMap.put(s.charAt(i),1);
            }
        }

        for(int j = 0;j<t.length();j++){
            if(buffMap.containsKey(t.charAt(j))){
                buffMap.put(t.charAt(j),buffMap.get(t.charAt(j))-1);
            }else{
                return false;
            }
        }

        for(Character key:buffMap.keySet()){
            if(buffMap.get(key) != 0){
                return false;
            }
        }

        return true;
    }
}