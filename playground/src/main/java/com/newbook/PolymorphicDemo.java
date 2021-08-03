package com.newbook;

/**
 * PolymorphicDemo
 *
 * @author Frank Zhang
 * @date 2020-09-04 8:28 PM
 */
public class PolymorphicDemo implements PolymorphicDemoInterface {

    public void checkSellable(Item item){
/*        if (item.isNormal()){
            item.isSellable();
        }
        else{
            List<Item> childItems = getChildItems();
            childItems.forEach(childItem -> childItem.isSellable());
        }*/

    }

    /**
     * 普通商品上架
     */
    @Override
    public void itemOnSale(){
  /*      checkItemStock();//检查库存
        checkItemSellable();//检查可售状态
        checkItemPurchaseLimit();//检查限购
        checkItemFreight();//检查运费
        checkItemCommission();//检查佣金
        checkItemActivityConflict();//检查活动冲突

        generateCspuGroupNo();//生成单品组号
        publishItem();//发布商品*/
    }

    /**
     * 组合商品上架
     */
    @Override
    public void combineItemOnSale(){
/*        checkCombineItemStock();//检查库存
        checkCombineItemSellable();//检查可售状态
        checkCombineItemPurchaseLimit();//检查限购
        checkCombineItemFreight();//检查运费
        checkCombineItemCommission();//检查佣金
        checkCombineItemActivityConflict();//检查活动冲突

        generateCspuGroupNo();//生成单品组号
        publishCombineItem();//发布商品*/
    }

    /**
     * 赠品上架
     */
    @Override
    public void giftItemOnSale(){
/*        checkGiftItemSellable();//检查可售状态
        publishCombineItem();//发布商品*/
    }

}

class Item{

}
