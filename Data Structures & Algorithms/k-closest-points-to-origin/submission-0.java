class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Triple> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.dist, b.dist));
        int[][] res = new int[k][2];

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            double dist = Triple.calcDist(x, y);
            Triple tmp = new Triple(dist, x, y);
            minHeap.add(tmp); 
        }

        for(int i = 0; i < k; i++){
            Triple tmp = minHeap.poll();
            res[i] = new int[]{tmp.x, tmp.y};
        }
        
        return res; 
    }

    public class Triple{
        private double dist; 
        private int x; 
        private int y; 

        public Triple(double dist, int x, int y){
            this.dist = dist; 
            this.x = x; 
            this.y = y; 
        }

        public static double calcDist(int x, int y){
            return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        }
    }
}
