package amaralus.apps.mongo.prototype.region.mapper;

import amaralus.apps.mongo.prototype.common.mapper.CrudMapper;
import amaralus.apps.mongo.prototype.common.mapper.DBRefMapper;
import amaralus.apps.mongo.prototype.region.api.Region;
import amaralus.apps.mongo.prototype.region.model.RegionModel;
import com.mongodb.DBRef;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, uses = DBRefMapper.class, unmappedTargetPolicy = IGNORE)
public interface RegionMapper extends CrudMapper<Region, RegionModel> {

    @Override
    Region map(RegionModel regionModel);

    @Override
    RegionModel map(Region region);

    @Override
    void merge(@MappingTarget RegionModel regionModel, Region region);

    default DBRef countyToDBRef(String id) {
        return new DBRef("country", id);
    }
}
