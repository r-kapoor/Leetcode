package java1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Follow{
	public int user1;
	public int user2;
}

class Like{
	public int user;
	public int tweet;
}

class TweetLikes implements Comparable<TweetLikes>{
	public Integer tweet;
	public Integer likes;
	public TweetLikes(int tweet, int likes){
		this.tweet = tweet;
		this.likes = likes;
	}

	@Override
	public int compareTo(TweetLikes o) {
		return this.likes.compareTo(o.likes);
	}
}

public class RecommendedTweets {
	
	public static List<Integer> getRecommendedTweets(Follow[] followGraph_edges, Like[] likeGraph_edges, int targetUser, int minLikeThreshold){
		HashSet<Integer> follows = new HashSet<Integer>();
		
		// Get all people being followed by user
		for(int i = 0; i < followGraph_edges.length; i++){
			if(followGraph_edges[i].user1 == targetUser){
				//Follows other user
				follows.add(followGraph_edges[i].user2);
			}
		}
		
		
		HashMap<Integer, Integer> tweetLikes = new HashMap<Integer, Integer>();
		List<TweetLikes> tweetLikesList = new ArrayList<TweetLikes>();
		
		// Add likes of tweets of all the people being followed by the user
		for(int i = 0; i < likeGraph_edges.length; i++){
			if(follows.contains(likeGraph_edges[i].user)){
				int likes = 1;
				if(tweetLikes.containsKey(likeGraph_edges[i].tweet)){
					likes += tweetLikes.get(likeGraph_edges[i].tweet);
				}
				tweetLikes.put(likeGraph_edges[i].tweet, likes);
			}
		}
		
		Set<Integer> tweets = tweetLikes.keySet();
		
		// Filter all tweets above like threshold
		for(int tweet : tweets){
			int likes = tweetLikes.get(tweet);
			if(likes >= minLikeThreshold){
				tweetLikesList.add(new TweetLikes(tweet, likes));
			}
		}
		
		// Sort by likes
		Collections.sort(tweetLikesList);
		List<Integer> recommendedTweets = new ArrayList<Integer>();
		
		// Get the tweet ids from sorted list and return 
		for(TweetLikes tweetLike:tweetLikesList){
			recommendedTweets.add(tweetLike.tweet);
		}
		
		return recommendedTweets;
	}
	
	public static void main(String args[]){
		
	}

}
