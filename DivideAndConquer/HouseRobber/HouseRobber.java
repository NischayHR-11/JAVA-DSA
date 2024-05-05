package DivideAndConquer.HouseRobber;

public class HouseRobber {

    private static int maxHouseRobery(int houses[],int index){

        if(index>=houses.length)
        return 0;

        int FirstHouse=houses[index]+maxHouseRobery(houses, index+2);
        int SkipFirstHouse=maxHouseRobery(houses, index+1);

        return Math.max(FirstHouse, SkipFirstHouse);
    }

    public static int maxHouseRobery(int houses[]){

        return maxHouseRobery(houses,0);
    }
    public static void main(String[] args) {
        

        int housesWorth[]={6,7,1,30,8,2,4};

        System.out.println("MAXIMUM ROBBERY AMOUNT BY NOT ROBBING ADJACENT HOUSES IS : "+maxHouseRobery(housesWorth));
    }
    
}
