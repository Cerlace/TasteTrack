package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.DAO;
import cerlace.tastetrack.mapper.IMapper;
import cerlace.tastetrack.service.CrudService;

import java.util.List;

public abstract class AbstractService<T, E> implements CrudService<T> {

    private final DAO<E> dao;
    private final IMapper<T, E> mapper;

    protected AbstractService(DAO<E> dao, IMapper<T, E> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    protected DAO<E> getDao() {
        return this.dao;
    }

    protected IMapper<T, E> getMapper() {
        return this.mapper;
    }

    @Override
    public T save(T dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDTO(dao.save(entity));
    }

    @Override
    public T get(Long id) {
        return mapper.toDTO(dao.get(id));
    }

    @Override
    public List<T> getAll() {
        return mapper.toDTOList(dao.getAll());
    }

    @Override
    public T update(Long id, T dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDTO(dao.update(id, entity));
    }

    @Override
    public boolean delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public void closeDao() {
        dao.close();
    }
}
