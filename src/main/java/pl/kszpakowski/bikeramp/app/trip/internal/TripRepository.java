package pl.kszpakowski.bikeramp.app.trip.internal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.kszpakowski.bikeramp.app.trip.Trip;

@Repository
interface TripRepository extends MongoRepository<Trip,String> {
}
