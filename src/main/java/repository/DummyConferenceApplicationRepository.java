package repository;

import java.util.ArrayList;
import java.util.List;

import domain.ConferenceApplication;

public class DummyConferenceApplicationRepository implements ConferenceApplicationRepository {
	private static List<ConferenceApplication> db = new ArrayList<ConferenceApplication>();
	
	@Override
	public ConferenceApplication getApplicationByEmailAddress(String email) {
		for(ConferenceApplication app: db) {
			if (app.getEmail().equalsIgnoreCase(email))
				return app;
		}
		return null;
	}

	@Override
	public void add(ConferenceApplication app) {
		db.add(app);
	}

	@Override
	public int count() {
		return db.size();
	}

}
