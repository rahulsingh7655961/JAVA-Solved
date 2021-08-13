import java.util.ArrayList;

public class MergeInterval {
    public static void main(String[] args) {
      
        //Solution sol= new Solution();
    }


  //Definition for an interval.
  public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 
public static class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        Interval toInsert = newInterval;
        
        if(intervals == null){
           intervals= new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }if(intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }
        int i =0;
        
        while(i < intervals.size()){
            Interval current = intervals.get(i);
            if(current.end<toInsert.start){
                i++;
                continue;
            }else if(current.start>toInsert.end){
                intervals.add(i,toInsert);
                break;
            }else{
                toInsert.start = Math.min(current.start,toInsert.start);
                toInsert.end = Math.max(current.end,toInsert.end);
                intervals.remove(i);
            }
        }
        if(i == intervals.size()){
            intervals.add(toInsert);
        }
        return intervals;
        
    }
}
}