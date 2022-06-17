package amaralus.apps.mongo.prototype.city;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<CityModel, String> {
}
