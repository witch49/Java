package practice;

public class SongLyricsExample {
	public static void main(String[] args) {
		String[] composerArray = { "Freddie Mercury", "Brian May", "Roger Taylor", "John Deacon" };
		String str = "Love of my life, you've hurt me\n" + "You've broken my heart and now you leave me\n"
				+ "Love of my life, can't you see?\n" + "Bring it back, bring it back\n"
				+ "Don't take it away from me, because you don't know\n" + "What it means to me";
		SongLyrics songLyrics = new SongLyrics("Love of My Life", "Queen", "LoveofMyLife", composerArray, 1975, 0, str);
		songLyrics.show();
	}
}
