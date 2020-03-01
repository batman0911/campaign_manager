package com.linhnguyen0911.campaign_manager.repository;

import com.linhnguyen0911.campaign_manager.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    @Query(nativeQuery = true,
    value = "select * from campaign")
    List<Campaign> allCampaign();
}
