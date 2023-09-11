package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.User;

public class DaoUser extends AbstractJpaDao<Long, User>{
    public DaoUser(){
        super();
        this.setClazz(User.class);
    }

}
