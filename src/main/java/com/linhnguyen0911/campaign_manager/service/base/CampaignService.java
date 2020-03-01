package com.linhnguyen0911.campaign_manager.service.base;

import com.linhnguyen0911.campaign_manager.model.Campaign;

import java.util.List;
import java.util.Optional;

public interface CampaignService  {
    List<Campaign> findAllCampaign();
    Optional<Campaign> findCampaignById(Long id);
    void saveCampaign(Campaign campaign);
    void removeCampaign(Campaign campaign);
//    List<Campaign> allCampaign();
}
