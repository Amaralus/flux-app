package amaralus.apps.mongo.prototype.region.model;

import amaralus.apps.mongo.prototype.common.model.BaseModel;
import com.mongodb.DBRef;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("region")
@Getter
@Setter
@FieldNameConstants
@ToString
public class RegionModel extends BaseModel {

    @Id
    @Indexed
    private String name;
    private String code;

    private DBRef country;
}
