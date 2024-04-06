package GreedyAlgorithm.ActivitySelectionProblem;
import java.util.*;

// Time complexity : O(nlog(n));     Space complexity : O(1);

class Activity implements Comparable<Activity>{

    private String name;
    private int StartTime;
    private int EndTime;

    public Activity(String name,int st,int et){

        this.name=name;
        this.StartTime=st;
        this.EndTime=et;
    }

    @Override

    public int compareTo(Activity o){

        return this.EndTime-o.EndTime;
    }

    @Override

    public String toString(){

        return "ACTIVITY : "+this.name+" ( START TIME : "+this.StartTime+" , END TIME : "+this.EndTime+" )";
    }

    public static void Solution(ArrayList<Activity> activitylist){

        ArrayList<Activity> List=activitylist;

        Collections.sort(List);
        Activity prev=List.get(0);
        System.out.println("BEST ORDER TO COVER MORE ACTIVITY : \n"+List.get(0));

        for(int i=1;i<List.size();i++){

            if(List.get(i).StartTime>=prev.EndTime){
                System.out.println(List.get(i));
                prev=List.get(i);
            }
        }
    }

}

public class ActivitySelection {
    public static void main(String[] args) {
        
        ArrayList<Activity> activityList=new ArrayList<>();

        activityList.add(new Activity("Runing",0,6));
        activityList.add(new Activity("Drinking Water",3,4));
        activityList.add(new Activity("Dancing",1,2));
        activityList.add(new Activity("Swimming",5,8));
        activityList.add(new Activity("Cricket",5,7));
        activityList.add(new Activity("VolleyBall",8,9));

        Activity.Solution(activityList);
    }
    
}
