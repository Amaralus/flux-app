package amaralus.apps.mongo.prototype.city;

import amaralus.apps.mongo.prototype.common.model.BaseModel;
import com.mongodb.DBRef;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("city")
@Getter
@Setter
@FieldNameConstants
@RequiredArgsConstructor
public class CityModel extends BaseModel {

    @Id
    @Indexed
    private String name;

    private DBRef region;
    private DBRef country;
}
