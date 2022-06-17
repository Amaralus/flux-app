package amaralus.apps.mongo.prototype.common;

import amaralus.apps.mongo.prototype.common.mapper.CrudMapper;
import amaralus.apps.mongo.prototype.common.model.BaseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class CrudService<E extends IdSource<I>, M extends BaseModel, I> {

    protected final MongoRepository<M, I> repository;
    protected final CrudMapper<E, M> mapper;

    public E save(E entity) {
        var founded = repository.findById(entity.getId());

        if (founded.isPresent()) {
            var model = founded.get();
            mapper.merge(model, entity);
            return save(model);
        } else
           return save(mapper.map(entity));
    }

    private E save(M model) {
        return mapper.map(repository.save(model));
    }

    public Optional<E> get(I id) {
        return repository.findById(id)
                .map(mapper::map);
    }

    public void delete(I id) {
        repository.deleteById(id);
    }
}
