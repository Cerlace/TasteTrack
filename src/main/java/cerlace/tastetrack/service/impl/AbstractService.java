package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.DAO;
import cerlace.tastetrack.mapper.IMapper;
import cerlace.tastetrack.service.CrudService;

import java.util.List;

public abstract class AbstractService<DtoT, EntityT, DaoT extends DAO<EntityT>>
        implements CrudService<DtoT> {

    private final DaoT dao;
    private final IMapper<DtoT, EntityT> mapper;

    protected AbstractService(DaoT dao, IMapper<DtoT, EntityT> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    protected DaoT getDao() {
        return this.dao;
    }

    protected IMapper<DtoT, EntityT> getMapper() {
        return this.mapper;
    }

    @Override
    public DtoT save(DtoT dto) {
        EntityT entity = mapper.toEntity(dto);
        return mapper.toDTO(dao.save(entity));
    }

    @Override
    public DtoT get(Long id) {
        return mapper.toDTO(dao.get(id));
    }

    @Override
    public List<DtoT> getAll() {
        return mapper.toDTOList(dao.getAll());
    }

    @Override
    public DtoT update(Long id, DtoT dto) {
        EntityT entity = mapper.toEntity(dto);
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
