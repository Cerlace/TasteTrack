package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.UserDetailsDAO;
import cerlace.tastetrack.dao.impl.UserDetailsDAOImpl;
import cerlace.tastetrack.dto.UserDetailsDTO;
import cerlace.tastetrack.entity.UserDetailsEntity;
import cerlace.tastetrack.mapper.UserDetailsMapper;
import cerlace.tastetrack.service.UserDetailsService;

public class UserDetailsServiceImpl extends AbstractService<UserDetailsDTO, UserDetailsEntity, UserDetailsDAO>
        implements UserDetailsService {

    public UserDetailsServiceImpl() {
        super(new UserDetailsDAOImpl(), UserDetailsMapper.INSTANCE);
    }
}
