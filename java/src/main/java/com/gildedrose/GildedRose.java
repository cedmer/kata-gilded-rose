package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    /*
     /!\ Do not change code above this line /!\
     */

    public void updateQuality() {
        for (Item item: items) {
            if (!CheckNotAgedBrieANDTAFKAL80ETCConcert(item)) {
                CheckQuality(item);
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    handleSellInQuality(item, 11);
                    handleSellInQuality(item, 6);
                }
            }

            handleSulfuras(item, "sellIn");

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!CheckNotAgedBrieANDTAFKAL80ETCConcert(item)) {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    CheckQuality(item);
                }
            }
        }
    }

    private Boolean CheckNotAgedBrieANDTAFKAL80ETCConcert(Item item){
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
        {
            if (item.quality > 0) {
                handleSulfuras(item,"quality");
            }
            return true;
        }

        return false;
    }

    private void handleSellInQuality(Item item,int sellInRemain) {
        if (item.sellIn < sellInRemain) {
            CheckQuality(item);
        }
    }

    private void CheckQuality(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void handleSulfuras(Item item,String itemOption) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            if(itemOption.equals("quality")){
                item.quality = item.quality - 1;
                //checkConjured(i);
            }
            else {
                item.sellIn = item.sellIn - 1;
            }
        }
    }

    private void checkConjured(Item item)
    {
        if(item.sellIn < 0)
        {
            item.quality = item.quality - 1;
        }
    }
}


