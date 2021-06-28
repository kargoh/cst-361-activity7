package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import beans.Album;
import beans.Track;
import exception.TracksNotFoundException;

@Stateless
@Local(MusicManagerInterface.class)
@LocalBean
public class MusicManager implements MusicManagerInterface {
	HashMap<String, List<Track>> trackInfo;

	/**
	 * Default constructor.
	 */
	public MusicManager() {
		// Initialize the Track Info
		trackInfo = new HashMap<String, List<Track>>();
		List<Track> tracks1 = new ArrayList<Track>();
		tracks1.add(new Track("Brick Wall", 1));
		tracks1.add(new Track("Mindreader", 2));
		tracks1.add(new Track("Bloodsucker", 3));
		tracks1.add(new Track("Last Chance to Dance (Bad Friend)", 4));
		tracks1.add(new Track("F.Y.M.", 5));
		tracks1.add(new Track("High Diving", 6));
		tracks1.add(new Track("Resentment", 7));
		tracks1.add(new Track("Looks Like Hell", 8));
		tracks1.add(new Track("Viva La Mexico", 9));
		tracks1.add(new Track("Only Money", 10));
		tracks1.add(new Track("Degenerates", 11));
		tracks1.add(new Track("Permanent", 12));
		tracks1.add(new Track("Re-Entry", 13));
		trackInfo.put("A Day To Remember - You're Welcom - 2021", tracks1);
	}

	@Override
	public Album addAlbum(Album album) {
		// Discussion: How does the the MusicManager class and this method demonstrate
		// the use of the Facade Design Pattern?

		// Step 1: Get the Tracks for the specified Album
		album.setTracks(getTracks(album));

		// Step 2: Validate that Tracks were populated for the Album
		if (album.getNumberTracks() == 0)
			throw new TracksNotFoundException();

		// Step 3: Persist the Album in the database
		// TODO: will do this in a later In-Class Activity

		// Return Album
		return album;
	}

	private List<Track> getTracks(Album album) {
		String key = album.getArtist() + " - " + album.getTitle() + " - " + album.getYear();
		if (trackInfo.containsKey(key)) {
			return trackInfo.get(key);
		} else {
			return new ArrayList<Track>();
		}
	}
}
