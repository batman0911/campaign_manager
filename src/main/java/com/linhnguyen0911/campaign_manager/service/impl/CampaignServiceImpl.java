package com.linhnguyen0911.campaign_manager.service.impl;

import com.linhnguyen0911.campaign_manager.model.Campaign;
import com.linhnguyen0911.campaign_manager.repository.CampaignRepository;
import com.linhnguyen0911.campaign_manager.service.base.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignServiceImpl implements CampaignService {

    private CampaignRepository campaignRepository;

    @Autowired
    public CampaignServiceImpl (CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public List<Campaign> findAllCampaign() {
        return (List<Campaign>) campaignRepository.findAll();
    }

    @Override
    public Optional<Campaign> findCampaignById(Long id) {
        return (Optional<Campaign>) campaignRepository.findById(id);
    }

    @Override
    public void saveCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
    }

    @Override
    public void removeCampaign(Campaign campaign) {
        campaignRepository.delete(campaign);
    }
}
