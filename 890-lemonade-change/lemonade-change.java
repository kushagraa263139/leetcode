class Solution {
    public boolean lemonadeChange(int[] bills) {
    // maintain three differnt notes

    int note5=0;
    int note10=0;
    int note20=0;

    for(int i:bills){
        if(i==5) note5++;
        else if(i==10) note10++;
        else note20++;

        int change=i-5;
        if(change!=0){
            // check if note exist

            if(change==5){
                if(note5==0) return false;
                else note5--;
            }
            else{
                // change is 15 canbe given iun trwo ways 
                // 10+5 ansd 5+5+5
                if(note5==0) return false;
                else{
                   if(note10>=1){
                    note5--;
                    note10--;
                   }
                   else{
                        if(note5>=3) note5=note5-3;
                        else return false;
                   }
                }
            }
        }
    }

    return true;

     
    }
}