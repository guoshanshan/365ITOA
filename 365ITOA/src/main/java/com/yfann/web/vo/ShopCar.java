package com.yfann.web.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2015/4/4.
 */
public class ShopCar {
    private String id;
    private List<ShopCarItem> shopCarItems = new ArrayList<ShopCarItem>();
    private BigDecimal countPrice = new BigDecimal(0);


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ShopCarItem> getShopCarItems() {
        return shopCarItems;
    }

    public void setShopCarItems(List<ShopCarItem> shopCarItems) {
        this.shopCarItems = shopCarItems;
    }

    /**
     * 总价
     * @return
     */
    public BigDecimal getCountPrice() {
        //避免刷新的时候价格一直累加
        countPrice = new BigDecimal(0);
        for (ShopCarItem shopCarItem : shopCarItems){
            countPrice = countPrice.add(shopCarItem.getSubCount());
        }
        return countPrice;
    }

    public void setCountPrice(BigDecimal countPrice) {
        this.countPrice = countPrice;
    }
}
