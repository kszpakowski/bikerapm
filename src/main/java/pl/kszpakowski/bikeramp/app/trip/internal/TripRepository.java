package pl.kszpakowski.bikeramp.app.trip.internal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.kszpakowski.bikeramp.app.trip.Trip;

import java.time.Instant;
import java.util.List;

@Repository
interface TripRepository extends MongoRepository<Trip,String> {

    List<Trip> findAllByDateAfter(Instant after);
}
