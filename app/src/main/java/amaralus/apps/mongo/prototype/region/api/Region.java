package amaralus.apps.mongo.prototype.region.api;

import amaralus.apps.mongo.prototype.common.IdSource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Region implements IdSource<String> {

    private String name;
    private String code;
    private String country;

    @Override
    public String getId() {
        return name;
    }
}
