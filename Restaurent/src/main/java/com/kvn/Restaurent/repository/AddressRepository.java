package com.kvn.Restaurent.repository;

import com.kvn.Restaurent.model.Address;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address,Long> {

}
