package challenge;

import java.util.Arrays;

public class Song {
	String title;
	String artist;
	String album;
	String[] composer;
	int year;
	int track;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String[] getComposer() {
		return composer;
	}

	public void setComposer(String[] composer) {
		this.composer = composer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public void show() {
		System.out.println("Song [title=" + title + ", artist=" + artist + ", album=" + album + ", composer="
				+ Arrays.toString(composer) + ", year=" + year + ", track=" + track + "]");

	}

	public static void main(String[] args) {
		Song song = new Song();
		String[] com = { "Freddie Mercury", "Brian May", "Roger Taylor", "John Deacon" };
		song.setTitle("Love of My Life");
		song.setArtist("Queen");
		song.setAlbum("Love of My Life");
		song.setComposer(com);
		song.setYear(1975);
		song.setTrack(0);
		song.show();
	}

}
