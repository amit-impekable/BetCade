package com.betcade.android.market.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sandwyrm on 4/16/15.
 */
public class Placeholder {

    /**
     * An array of sample (dummy) items.
     */
    public static List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    static {
        // Add 3 sample items.
        addItem(new PlaceholderItem("1", "Item 1"));
        addItem(new PlaceholderItem("2", "Item 2"));
        addItem(new PlaceholderItem("3", "Item 3"));
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class PlaceholderItem {
        public String id;
        public String content;

        public PlaceholderItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
