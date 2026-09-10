class Twitter {

    // Simple Tweet object storing the tweet ID and the time it was posted
    private static class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    // A global time counter used to give each tweet a strictly increasing timestamp
    private static int time;

    // Max number of tweets we want in the news feed
    private static final int FEED_SIZE = 10;

    // Maps a user to the set of people they follow
    private Map<Integer, Set<Integer>> follows;

    // Maps a user to the list of tweets they have posted
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        time = 0;
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    // Post a new tweet for the given user
    public void postTweet(int userId, int tweetId) {

        // Ensure user has a tweet list
        tweets.putIfAbsent(userId, new ArrayList<>());

        // Ensure user has a follow set
        follows.putIfAbsent(userId, new HashSet<>());

        // User always follows themselves so they see their own tweets
        follows.get(userId).add(userId);

        // Add the new tweet with the current timestamp then increment time
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    // Build and return the newest 10 tweets visible to userId
    public List<Integer> getNewsFeed(int userId) {

        // If this user follows nobody, return an empty feed
        Set<Integer> fset = follows.get(userId);
        if (fset == null) return new ArrayList<>();

        // Max heap sorted by tweet time (latest tweet comes first)
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Add only the latest few tweets from each followee
        for (int f : fset) {
            List<Tweet> list = tweets.get(f);
            if (list == null) continue;

            // Start from the end since tweets are stored oldest to newest
            int start = Math.max(0, list.size() - FEED_SIZE);

            // Push the last few tweets into the priority queue
            for (int i = list.size() - 1; i >= start; i--) {
                pq.offer(list.get(i));
            }
        }

        // Extract the top 10 tweets from the heap
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < FEED_SIZE) {
            ans.add(pq.poll().id);
        }

        return ans;
    }

    // Make followerId follow followeeId
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    // Make followerId unfollow followeeId
    public void unfollow(int followerId, int followeeId) {
        // Cannot unfollow yourself
        if (followerId == followeeId) return;

        Set<Integer> s = follows.get(followerId);
        if (s != null) s.remove(followeeId);
    }
}