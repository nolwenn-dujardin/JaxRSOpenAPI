package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Professional;

public class DaoProfessional extends AbstractJpaDao<Long, Professional>{
    public DaoProfessional(){
        super();
        this.setClazz(Professional.class);
    }

}
