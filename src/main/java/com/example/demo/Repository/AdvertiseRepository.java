package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Advertise;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise,Integer> {

	@Query(value="SELECT a.name FROM `olx-masterdata`.`categories` a WHERE id=:id", nativeQuery = true)
	String findCustomerById(@Param("id") int id);
	
	@Query(value="SELECT b.status FROM `olx-masterdata`.`categories` a left join `olx-masterdata`.`adv_status` b on a.status=b.id WHERE a.id=:id", nativeQuery = true)
	String findCustomerStatusById(@Param("id") int id);

	@Query(value="SELECT * FROM `olx-advertises`.`advertises` WHERE `category_name`=:categoryName", nativeQuery=true)
	List<Advertise> getSearchByName(@Param("categoryName") String categoryName);
}
