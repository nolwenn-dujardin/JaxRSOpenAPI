package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.RDV;

public class DaoRDV extends AbstractJpaDao<Long, RDV>{

    public DaoRDV(){
        super();
        this.setClazz(RDV.class);
    }
}
