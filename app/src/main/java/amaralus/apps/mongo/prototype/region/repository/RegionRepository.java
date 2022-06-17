package amaralus.apps.mongo.prototype.region.repository;

import amaralus.apps.mongo.prototype.region.model.RegionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepository extends MongoRepository<RegionModel, String> {
}
