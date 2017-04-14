package repository;

import domain.ConferenceApplication;

public interface ConferenceApplicationRepository {
	
	ConferenceApplication getApplicationByEmailAddress(String email);
	void add(ConferenceApplication app);
	int count();
}
