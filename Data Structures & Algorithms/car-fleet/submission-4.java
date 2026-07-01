class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //sort car positions into descending order so that the car closest to the target is first. 
            //create an int[][] 
        //create stack to house fleets
        //iterate through position array
            //calculate time of car using T = (target - pos) / spd
            //if stack empty. push
            //else if(time >= stack(peek)) car behind one in stack will catchup and become fleet
                //pop old time, push new time. 
            //else car behind will not catch up. 
                //push time on stack to create new fleet. 
        //return stack.length

        int[][] pairs = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        
        Stack<Double> fleets = new Stack(); 

        if(position.length == 1){
            return 1; 
        }
        else if(position.length == 0){
            return 0;
        }
        else{
            fleets.push((double)(target - pairs[0][0]) / pairs[0][1]);
        }
        
        for(int i = 1; i < pairs.length; i++){
            double time = (double)(target - pairs[i][0]) / pairs[i][1];
            if(fleets.empty() || time > fleets.peek()){ 
                fleets.push(time);
            }
        } 

        return fleets.size(); 
    }
}
