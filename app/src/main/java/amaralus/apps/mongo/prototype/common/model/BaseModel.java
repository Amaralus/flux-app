package amaralus.apps.mongo.prototype.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

@Getter
@Setter
@FieldNameConstants
@ToString
public abstract class BaseModel {

    private String type;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
    @Version
    private Integer version;

    protected BaseModel(String type) {
        this.type = type;
    }

    protected BaseModel() {
        this("default");
    }
}
