package org.example.repository;

import jakarta.transaction.Transactional;
import org.example.entity.MailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MailAddressRepository extends JpaRepository<MailAddress, String> {

    @Query("Select mailAddress from MailAddress")
    String[] findAllAddresses();

    @Transactional
    @Modifying
    @Query("Delete MailAddress ad where ad.mailAddress = :addressName")
    int deleteMailAddress(@Param("addressName") String addressName);

    @Modifying
    @Transactional
    @Query("Update MailAddress ad set ad.mailAddress = :newAddressName where ad.mailAddress = :addressName")
    int updateMailAddress(@Param("addressName") String addressName, @Param("newAddressName") String newAddressName);

}
