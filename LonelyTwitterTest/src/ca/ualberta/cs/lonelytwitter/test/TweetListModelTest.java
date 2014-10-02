package ca.ualberta.cs.lonelytwitter.test;

import java.sql.Date;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

public class TweetListModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
		// TODO Auto-generated constructor stub
	}

	public void testAddTweet() throws Exception {
		TweetListModel tlm = new TweetListModel();

		Tweet tweet1 = new Tweet("Hello");
		tlm.addTweet(tweet1);

		try {
			Tweet tweet2 = new Tweet("Hello");
			tlm.addTweet(tweet2);

			fail();
		} catch (Exception e) {

			assertEquals("Exception message", "Tweets already exists.",
					e.getMessage());
		}
	}

	public void testGetCount() throws Exception {
		TweetListModel tlm = new TweetListModel();

		Tweet tweet1 = new Tweet("Hello");
		Tweet tweet2 = new Tweet("Hello1");

		tlm.addTweet((AbstractTweet) tweet1);
		tlm.addTweet((AbstractTweet) tweet2);

		assertEquals("Test count", tlm.getCount(), 2);

	}

	public void testHasTweet() throws Exception {
		// Checks if list has a tweet already exists

		TweetListModel tlm = new TweetListModel();
		Tweet tweet1 = new Tweet("Hello");

		tlm.addTweet((AbstractTweet) tweet1);

		assertTrue("Has tweet?", tlm.hasTweet(tweet1));

	}

	public void testRemoveTweet() throws Exception {
		TweetListModel tlm = new TweetListModel();
		Tweet tweet1 = new Tweet("Hello");

		tlm.addTweet((AbstractTweet) tweet1);

		assertTrue("Has tweet?", tlm.hasTweet(tweet1));

		tlm.removeTweet(tweet1);
		assertEquals("Not there", tlm.getCount(), 0);

	}
	
	public void testGetTweets() throws Exception {
		TweetListModel tlm1 = new TweetListModel();
		TweetListModel tlm2 = new TweetListModel();
		
		Tweet tweet1 = new Tweet("a");
		Tweet tweet2 = new Tweet("z");
		
		tlm1.addTweet(tweet1);
		tlm1.addTweet(tweet2);
		
		tlm2.addTweet(tweet2);
		tlm2.addTweet(tweet1);
		
		assertEquals("Compare Lists", tlm2.getTweets(), tlm1.getTweets());
		
		
	}
	
	

}
