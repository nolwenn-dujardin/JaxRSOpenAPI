package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.User;

public class DaoClient extends AbstractJpaDao<Long, Client>{

    public DaoClient(){
        super();
        this.setClazz(Client.class);
    }

}
