package com.cutconnect.apifirebase.domains.dto;

import java.util.List;

public class CostDTO {

    private String object;
    private String url;
    private Boolean hasMore;
    private List<PriceDataDTO> priceData;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<PriceDataDTO> getPriceData() {
        return priceData;
    }

    public void setPriceData(List<PriceDataDTO> priceData) {
        this.priceData = priceData;
    }
}
