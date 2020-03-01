package com.linhnguyen0911.campaign_manager.controller;

import com.linhnguyen0911.campaign_manager.model.Campaign;
import com.linhnguyen0911.campaign_manager.service.base.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/campaign")
public class CampaignAPI {

    private CampaignService campaignService;

    @Autowired
    public CampaignAPI(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Campaign>> findAllCampaign() {
        List<Campaign> campaigns = campaignService.findAllCampaign();
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) {
        campaignService.saveCampaign(campaign);
        return new ResponseEntity<>(campaign, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Campaign> findCampaignById(@PathVariable("id") Long id) {
        Optional<Campaign> campaign = campaignService.findCampaignById(id);
        return new ResponseEntity<>(campaign.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable("id") Long id,
                                                   @RequestBody Campaign campaign) {
        Optional<Campaign> currentCampaign = campaignService.findCampaignById(id);
        if(currentCampaign.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            currentCampaign.get().setTitle(campaign.getTitle());
            currentCampaign.get().setContent(campaign.getContent());
            campaignService.saveCampaign(currentCampaign.get());
            return new ResponseEntity<>(currentCampaign.get(), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCampaign(@PathVariable("id") Long id) {
        Optional<Campaign> currentCampaign = campaignService.findCampaignById(id);
        if(currentCampaign.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            campaignService.removeCampaign(currentCampaign.get());
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }
    }



}
