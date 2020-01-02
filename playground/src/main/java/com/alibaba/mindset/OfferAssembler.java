package com.alibaba.mindset;

/**
 * OfferAssembler
 *
 * @author Frank Zhang
 * @date 2019-11-18 12:57
 */
public class OfferAssembler {

    public Offer assembleOffer(){
        Offer offer = new Offer();
        // 1. 核心商品信息
        assembleCoreInfo(offer);

        // 2. 产品属性信息
        assembleProductInfo(offer);

        // 3. 商品描述信息
        assembleOfferDescInfo(offer);

        // 4. 商品销售信息
        assembleOfferSaleInfo(offer);
        
        // 5. 商品系统属性
        assembleOfferSysInfo(offer);

        // 6. 商品扩展属性
        assembleOfferExtInfo(offer);
        
        return offer;
    }

    private void assembleOfferExtInfo(Offer offer) {
        // 1. 产品扩展信息
        assembleProductExtInfo(offer);

        // 2. 销售扩展信息
        assembleSaleExtInfo(offer);

        // 3. 供应链扩展信息
        assembleSupplyChainExtInfo(offer);
    }

    private void assembleSupplyChainExtInfo(Offer offer) {
    }

    private void assembleSaleExtInfo(Offer offer) {
    }

    private void assembleProductExtInfo(Offer offer) {
    }

    private void assembleOfferSysInfo(Offer offer) {
    }

    private void assembleOfferSaleInfo(Offer offer) {
    }

    private void assembleOfferDescInfo(Offer offer) {
    }

    private void assembleProductInfo(Offer offer) {
    }

    private void assembleCoreInfo(Offer offer) {
    }
}


class Offer{

}
