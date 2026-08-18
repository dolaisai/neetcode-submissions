class Solution {
    public int countSeniors(String[] details) {
        int counter = 0; 
        for(String senior : details){
            int age = Integer.valueOf(senior.substring(11,13));
            if(age > 60) counter++;
        }
        return counter; 
    }
}