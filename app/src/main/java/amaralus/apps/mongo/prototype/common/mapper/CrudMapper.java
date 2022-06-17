package amaralus.apps.mongo.prototype.common.mapper;

import amaralus.apps.mongo.prototype.common.model.BaseModel;

public interface CrudMapper<E, M extends BaseModel> {

    E map(M model);

    M map(E entity);

    void merge(M target, E source);
}
