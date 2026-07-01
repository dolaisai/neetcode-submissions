class Twitter {
    int time; 
    HashMap<Integer, HashSet<Integer>> followerMap; 
    HashMap<Integer, List<int[]>> tweetMap; 

    public Twitter() {
        time = 0; 
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>(); 
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(
            tweetMap.getOrDefault(userId, new ArrayList<>())
        ); 
        for(int followeeId : followerMap.getOrDefault(userId, new HashSet<>())){
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }
        feed.sort((a, b) -> b[0] - a[0]);
        List<Integer> res = new ArrayList<>(); 
        for(int i = 0; i < Math.min(10, feed.size()); i++){
            res.add(feed.get(i)[1]);
        }
        return res; 
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followerMap.putIfAbsent(followerId, new HashSet<>());

            followerMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        followerMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
