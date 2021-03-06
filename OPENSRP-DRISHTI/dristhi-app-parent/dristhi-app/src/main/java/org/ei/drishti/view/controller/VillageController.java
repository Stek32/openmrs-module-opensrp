package org.ei.drishti.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.ei.drishti.repository.AllEligibleCouples;
import org.ei.drishti.util.Cache;
import org.ei.drishti.util.CacheableData;
import org.ei.drishti.view.contract.Village;
import org.ei.drishti.view.contract.Villages;

import com.google.gson.Gson;

public class VillageController {
    private static final String VILLAGE_LIST = "VILLAGE_LIST";
    private AllEligibleCouples allEligibleCouples;
    private Cache<String> cache;
    private Cache<Villages> villagesCache;

    public VillageController(AllEligibleCouples allEligibleCouples, Cache<String> cache,
                             Cache<Villages> villagesCache) {
        this.allEligibleCouples = allEligibleCouples;
        this.cache = cache;
        this.villagesCache = villagesCache;
    }

    public String villages() {
        return cache.get(VILLAGE_LIST, new CacheableData<String>() {
            @Override
            public String fetch() {
                List<Village> villagesList = new ArrayList<Village>();
                List<String> villages = allEligibleCouples.villages();
                for (String village : villages) {
                    villagesList.add(new Village(village));
                }
                return new Gson().toJson(villagesList);
            }
        });
    }

    public Villages getVillages() {
        return villagesCache.get(VILLAGE_LIST, new CacheableData<Villages>() {
            @Override
            public Villages fetch() {
                Villages villagesList = new Villages();
                List<String> villages = allEligibleCouples.villages();
                for (String village : villages) {
                    villagesList.add(new Village(village));
                }
                return villagesList;
            }
        });
    }
}
