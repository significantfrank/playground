package com.alibaba.mindset;


/**
 * BadOfferAssembler
 *
 * @author Frank Zhang
 * @date 2019-12-11 17:51
 */
public class BadOfferAssembler {
//    public Offer assembleOffer(Context context){
//        Offer offer = new Offer();
//
//        // 1. 核心商品信息
//        MyCspu myCspu = context.getMyCspu();
//        MySpu mySpu = context.getMySpu();
//        SupplierItem supplierItem = context.getNormalItemAggregateRoot().getSupplierItem();
//        ProductAttributeParam productAttributeParam = new ProductAttributeParam();
//        try {
//            List<AttributeParam> productAttrList = OfferPostBiz.buildAttributeParamList(myCspu,
//                    supplierItem.getCargoNumber());
//
//            productAttributeParam.setAttributes(productAttrList);
//
//        } catch (ArrayIndexOutOfBoundsException ex) {
//            throw new ServiceException("CSPU_CHECK_ERROR",
//                    "Sku规格属性不一致，请检查sku规格数据. [id:" + supplierItem.getId() + "]");
//        }
//
//        offer.setProductAttributeParam(productAttributeParam);
//
//        // 2. 产品属性信息
//        DescParam descParam = new DescParam();
//        // offer标题
//        descParam.setSubject(myCspu.getTitle());
//        // offer图片
//        if (CollectionUtils.isNotEmpty(myCspu.getImgList())) {
//            List<String> cspuImgUrl = Lists.newArrayList();
//            for (String img : myCspu.getImgList()) {
//                cspuImgUrl.add(serverImgUrl + img);
//            }
//            PictureParam pictureParam = new PictureParam();
//            pictureParam.setPictures(cspuImgUrl);
//            descParam.setPictureParam(pictureParam);
//        }
//        // offer详情
//        DetailParam detailParam = new DetailParam();
//        String detailDesc = null;
//        if (!StringUtil.isEmpty(myCspu.getBigTextUrl())) {
//            detailDesc = bigTextBiz.get(myCspu.getBigTextUrl());
//        }
//
//        //...此处省略一万字
//
//        return offer;
//    }
}
