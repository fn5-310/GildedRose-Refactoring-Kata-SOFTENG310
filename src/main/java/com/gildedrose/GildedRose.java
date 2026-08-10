package com.gildedrose;

class GildedRose {
    private static final String BRIE = "Aged Brie";
    private static final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int zeroQuality = 0;
    private static final int fiftyQuality = 50;
    private static final int sellInZero = 0;
    private static final int sellInHigh = 11;
    private static final int sellInLow = 6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(BRIE)
                    && !item.name.equals(PASSES)) {
                if (item.quality > zeroQuality) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < fiftyQuality) {
                    item.quality = item.quality + 1;
                    if (item.name.equals(PASSES)) {
                        // Increase quality by 1 if sellIn is less than 11 and quality is below 50
                        // If sellIn is below 6 and quality is still below 50, increase quality by 1 again
                        if (item.sellIn < sellInHigh && item.quality < fiftyQuality) {
                            item.quality = item.quality + 1;
                            if (item.sellIn < sellInLow && item.quality < fiftyQuality) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < sellInZero) {
                if (!item.name.equals(BRIE)) {
                    if (!item.name.equals(PASSES)) {
                        if (item.quality > zeroQuality) {
                            if (!item.name.equals(SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < fiftyQuality) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}