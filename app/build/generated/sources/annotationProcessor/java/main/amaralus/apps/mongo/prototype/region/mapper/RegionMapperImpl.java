package amaralus.apps.mongo.prototype.region.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import amaralus.apps.mongo.prototype.common.mapper.DBRefMapper;
import amaralus.apps.mongo.prototype.region.model.RegionModel;
import amaralus.apps.mongo.prototype.region.api.Region;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T14:41:45+0300",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 11.0.14 (Eclipse Adoptium)"
)
@Component
public class RegionMapperImpl implements RegionMapper {

    @Autowired
    private DBRefMapper dBRefMapper;

    @Override
    public Region map(RegionModel regionModel) {
        if ( regionModel == null ) {
            return null;
        }

        Region region = new Region();

        region.setName( regionModel.getName() );
        region.setCode( regionModel.getCode() );
        region.setCountry( dBRefMapper.dbRefToString( regionModel.getCountry() ) );

        return region;
    }

    @Override
    public RegionModel map(Region region) {
        if ( region == null ) {
            return null;
        }

        RegionModel regionModel = new RegionModel();

        regionModel.setName( region.getName() );
        regionModel.setCode( region.getCode() );
        regionModel.setCountry( countyToDBRef( region.getCountry() ) );

        return regionModel;
    }

    @Override
    public void merge(RegionModel regionModel, Region region) {
        if ( region == null ) {
            return;
        }

        regionModel.setName( region.getName() );
        regionModel.setCode( region.getCode() );
        regionModel.setCountry( countyToDBRef( region.getCountry() ) );
    }
}
