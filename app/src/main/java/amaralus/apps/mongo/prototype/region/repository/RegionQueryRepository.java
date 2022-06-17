package amaralus.apps.mongo.prototype.region.repository;

import amaralus.apps.mongo.prototype.region.model.RegionQueryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionQueryRepository extends MongoRepository<RegionQueryModel, String> {
}
