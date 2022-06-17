package amaralus.apps.mongo.prototype.country;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<CountryModel, String> {
}
