package business;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import beans.Album;

@Startup;
@Singleton;

public class Cache {
	
	public void init() {
		System.out.println("init method");
	}
	
	public Album getObject(Album album) {
		System.out.println("getObject method");
	}
	
	public void putObject(Album album) {
		System.out.println("putObject method");
	}

}
