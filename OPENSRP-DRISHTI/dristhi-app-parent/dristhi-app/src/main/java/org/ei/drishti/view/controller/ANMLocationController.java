package org.ei.drishti.view.controller;

import org.ei.drishti.repository.AllSettings;
import org.ei.drishti.util.Cache;
import org.ei.drishti.util.CacheableData;
import org.ei.drishti.view.contract.ANMLocation;

import com.google.gson.Gson;

public class ANMLocationController {
    private static final String ANM_LOCATION = "anmLocation";
    private static final String ANM_LOCATION_JSON = "anmLocationJSON";
    private AllSettings allSettings;
    private Cache<String> cache;

    public ANMLocationController(AllSettings allSettings, Cache<String> cache) {
        this.allSettings = allSettings;
        this.cache = cache;
    }

    public String get() {
        return cache.get(ANM_LOCATION, new CacheableData<String>() {
            @Override
            public String fetch() {
                return allSettings.fetchANMLocation();
            }
        });
    }

    public String getLocationJSON() {
        return cache.get(ANM_LOCATION_JSON, new CacheableData<String>() {
            @Override
            public String fetch() {
                return new Gson().fromJson(allSettings.fetchANMLocation(), ANMLocation.class).asJSONString();
            }
        });
    }
}
