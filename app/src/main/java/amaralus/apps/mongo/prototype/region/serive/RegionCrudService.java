package amaralus.apps.mongo.prototype.region.serive;

import amaralus.apps.mongo.prototype.common.CrudService;
import amaralus.apps.mongo.prototype.common.mapper.CrudMapper;
import amaralus.apps.mongo.prototype.region.api.Region;
import amaralus.apps.mongo.prototype.region.model.RegionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class RegionCrudService extends CrudService<Region, RegionModel, String> {

    public RegionCrudService(MongoRepository<RegionModel, String> repository, CrudMapper<Region, RegionModel> mapper) {
        super(repository, mapper);
    }
}
