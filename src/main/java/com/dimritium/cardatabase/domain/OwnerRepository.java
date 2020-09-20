package com.dimritium.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "owners", path = "owners")
public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
}
