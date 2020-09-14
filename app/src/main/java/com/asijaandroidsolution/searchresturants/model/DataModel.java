package com.asijaandroidsolution.searchresturants.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {


    /**
     * location_suggestions : [{"id":11782,"name":"Tohana","country_id":1,"country_name":"India","country_flag_url":"https://b.zmtcdn.com/images/countries/flags/country_1.png","should_experiment_with":0,"has_go_out_tab":0,"discovery_enabled":0,"has_new_ad_format":0,"is_state":0,"state_id":0,"state_name":"","state_code":""}]
     * status : success
     * has_more : 0
     * has_total : 0
     * user_has_addresses : true
     */

    @SerializedName("status")
    private String status;
    @SerializedName("has_more")
    private int hasMore;
    @SerializedName("has_total")
    private int hasTotal;
    @SerializedName("user_has_addresses")
    private boolean userHasAddresses;
    @SerializedName("location_suggestions")
    private List<LocationSuggestionsBean> locationSuggestions;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHasMore() {
        return hasMore;
    }

    public void setHasMore(int hasMore) {
        this.hasMore = hasMore;
    }

    public int getHasTotal() {
        return hasTotal;
    }

    public void setHasTotal(int hasTotal) {
        this.hasTotal = hasTotal;
    }

    public boolean isUserHasAddresses() {
        return userHasAddresses;
    }

    public void setUserHasAddresses(boolean userHasAddresses) {
        this.userHasAddresses = userHasAddresses;
    }

    public List<LocationSuggestionsBean> getLocationSuggestions() {
        return locationSuggestions;
    }

    public void setLocationSuggestions(List<LocationSuggestionsBean> locationSuggestions) {
        this.locationSuggestions = locationSuggestions;
    }

    public static class LocationSuggestionsBean {
        /**
         * id : 11782
         * name : Tohana
         * country_id : 1
         * country_name : India
         * country_flag_url : https://b.zmtcdn.com/images/countries/flags/country_1.png
         * should_experiment_with : 0
         * has_go_out_tab : 0
         * discovery_enabled : 0
         * has_new_ad_format : 0
         * is_state : 0
         * state_id : 0
         * state_name :
         * state_code :
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("country_id")
        private int countryId;
        @SerializedName("country_name")
        private String countryName;
        @SerializedName("country_flag_url")
        private String countryFlagUrl;
        @SerializedName("should_experiment_with")
        private int shouldExperimentWith;
        @SerializedName("has_go_out_tab")
        private int hasGoOutTab;
        @SerializedName("discovery_enabled")
        private int discoveryEnabled;
        @SerializedName("has_new_ad_format")
        private int hasNewAdFormat;
        @SerializedName("is_state")
        private int isState;
        @SerializedName("state_id")
        private int stateId;
        @SerializedName("state_name")
        private String stateName;
        @SerializedName("state_code")
        private String stateCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCountryId() {
            return countryId;
        }

        public void setCountryId(int countryId) {
            this.countryId = countryId;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getCountryFlagUrl() {
            return countryFlagUrl;
        }

        public void setCountryFlagUrl(String countryFlagUrl) {
            this.countryFlagUrl = countryFlagUrl;
        }

        public int getShouldExperimentWith() {
            return shouldExperimentWith;
        }

        public void setShouldExperimentWith(int shouldExperimentWith) {
            this.shouldExperimentWith = shouldExperimentWith;
        }

        public int getHasGoOutTab() {
            return hasGoOutTab;
        }

        public void setHasGoOutTab(int hasGoOutTab) {
            this.hasGoOutTab = hasGoOutTab;
        }

        public int getDiscoveryEnabled() {
            return discoveryEnabled;
        }

        public void setDiscoveryEnabled(int discoveryEnabled) {
            this.discoveryEnabled = discoveryEnabled;
        }

        public int getHasNewAdFormat() {
            return hasNewAdFormat;
        }

        public void setHasNewAdFormat(int hasNewAdFormat) {
            this.hasNewAdFormat = hasNewAdFormat;
        }

        public int getIsState() {
            return isState;
        }

        public void setIsState(int isState) {
            this.isState = isState;
        }

        public int getStateId() {
            return stateId;
        }

        public void setStateId(int stateId) {
            this.stateId = stateId;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public String getStateCode() {
            return stateCode;
        }

        public void setStateCode(String stateCode) {
            this.stateCode = stateCode;
        }
    }
}
