package singleton;

import model.HighScore;

public class HighScoreSingleton {
	private static HighScore instance;
	public static HighScore getInstance() {
		if(instance == null) {
			instance = new HighScore();
		}
		return instance;
	}
}
