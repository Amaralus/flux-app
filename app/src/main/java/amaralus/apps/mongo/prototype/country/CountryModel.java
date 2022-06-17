package amaralus.apps.mongo.prototype.country;

import amaralus.apps.mongo.prototype.common.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("country")
@Getter
@Setter
@FieldNameConstants
@ToString(callSuper = true)
public class CountryModel extends BaseModel {

    @Id
    @Indexed
    private String name;

    public CountryModel(String name) {
        this.name = name;
    }
}
