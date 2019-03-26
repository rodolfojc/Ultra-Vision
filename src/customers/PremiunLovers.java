package customers;

import customer.interfaces.BoxSets;
import customer.interfaces.LiveConcert;
import customer.interfaces.Movies;
import customer.interfaces.MusicCds;

public class PremiunLovers extends Customer implements MusicCds, LiveConcert, Movies, BoxSets{

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

}
