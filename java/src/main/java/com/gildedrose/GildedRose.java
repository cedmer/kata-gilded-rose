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
        for (int i = 0; i < items.length; i++) {
            if (!CheckNotAgedBrieANDTAFKAL80ETCConcert(i)){
                CheckQuality(i);
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    handleSellInQuality(i,11);
                    handleSellInQuality(i,6);
                }
            }

            handleSulfuras(i,"sellIn");

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!CheckNotAgedBrieANDTAFKAL80ETCConcert(i)){
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                }
                else{
                    CheckQuality(i);
                }
            }
        }
    }

    private Boolean CheckNotAgedBrieANDTAFKAL80ETCConcert(int i){
        if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
        {
            if (items[i].quality > 0) {
                handleSulfuras(i,"quality");
            }
            return true;
        }

        return false;
    }

    private void handleSellInQuality(int i,int sellInRemain) {
        if (items[i].sellIn < sellInRemain) {
            CheckQuality(i);
        }
    }

    private void CheckQuality(int i) {
        if (items[i].quality < 50) {
            increaseQuality(i);
        }
    }

    private void increaseQuality(int i) {
        items[i].quality = items[i].quality + 1;
    }

    private void handleSulfuras(int i,String itemOption) {
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            if(itemOption.equals("quality")){
                items[i].quality = items[i].quality - 1;
            }
            else {
                items[i].sellIn = items[i].sellIn - 1;
            }
        }
    }
}

