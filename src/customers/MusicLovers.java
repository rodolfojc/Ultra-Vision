package customers;

import customer.interfaces.LiveConcert;
import customer.interfaces.MusicCds;

public class MusicLovers extends Customer implements MusicCds, LiveConcert {

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

}
