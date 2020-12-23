package com.derivedquery.repository;

import com.derivedquery.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {

    // display all regions in Canada
    List<Region> findByCountry(String country);


    // display all regions in Canada without duplicate
    List<Region> findDistinctByCountry(String country);

    // display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String country);

    // displays all regions with country name includes 'United' in order
    List<Region> findByCountryContainingOrderByRegion(String country);

    // displays Top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);

}
