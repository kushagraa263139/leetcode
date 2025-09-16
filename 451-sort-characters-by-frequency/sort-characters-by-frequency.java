class Element implements Comparable<Element>{
    char ch;
    int fre;

    public Element(char ch,int fre){
        this.ch=ch;
        this.fre=fre;
    }

  // override

  public int compareTo(Element other){
    return Integer.compare(other.fre,this.fre);
  }

}

class Solution {
    public String frequencySort(String s) {


    // create a map and fill it
    HashMap<Character,Integer> mp = new HashMap<>();
    for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(mp.containsKey(ch)) mp.put(ch,mp.get(ch)+1);
        else mp.put(ch,1);
    }

    // traverse map ,  use a priority queue and fill that queue
    PriorityQueue<Element> pq = new PriorityQueue<>();
    for(Map.Entry<Character,Integer> ee :mp.entrySet()){
        Element e = new Element(ee.getKey(),ee.getValue());
        pq.add(e);
    }

    // traverse queuee and create the ans

    StringBuilder  ans = new StringBuilder();
    while(pq.size()>0){
        Element top = pq.poll();
        while(top.fre>0){
            ans.append(top.ch);
            top.fre--;
        }
    }

    return ans.toString();

       
        
    }
}