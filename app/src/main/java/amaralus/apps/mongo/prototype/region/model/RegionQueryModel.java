package amaralus.apps.mongo.prototype.region.model;

import amaralus.apps.mongo.prototype.common.model.BaseModel;
import amaralus.apps.mongo.prototype.country.CountryModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("region")
@Getter
@Setter
@FieldNameConstants
@ToString
public class RegionQueryModel extends BaseModel {

    @Id
    @Indexed
    private String name;
    private String code;

    @DBRef
    private CountryModel country;
}
