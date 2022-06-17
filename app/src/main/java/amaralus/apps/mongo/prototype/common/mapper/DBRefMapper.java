package amaralus.apps.mongo.prototype.common.mapper;

import com.mongodb.DBRef;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DBRefMapper {

    default String dbRefToString(DBRef dbRef) {
        return (String) dbRef.getId();
    }

    default ObjectId dbRefToObjectId(DBRef dbRef) {
        return (ObjectId) dbRef.getId();
    }
}
