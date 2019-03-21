package practice;

import java.util.Arrays;

public class Song {
	public String title;
	public String artist;
	public String album;
	public String[] composer;
	public int year;
	public int track;

	public Song(String title, String artist, String album, String[] composer, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
	}

	public void show() {
		System.out.println("Song [title=" + title + ", artist=" + artist + ", album=" + album + ", composer="
				+ Arrays.toString(composer) + ", year=" + year + ", track=" + track + "]");
	}

}
