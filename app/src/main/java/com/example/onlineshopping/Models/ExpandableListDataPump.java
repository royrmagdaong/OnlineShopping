package com.example.onlineshopping.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData(){
        HashMap<String,List<String>> expandableListDetail = new HashMap<>();

        List technology = new ArrayList();
        technology.add("Beats sued for noise-cancelling tech");
        technology.add("Wikipedia blocks US Congress edits");
        technology.add("Google quizzed over deleted links");
        technology.add("Nasa seeks aid with Earth-Mars links");
        technology.add("The Good, the Bad and the Ugly");

        List sell_center = new ArrayList();
        sell_center.add("How to be a Merchant?");
        sell_center.add("How do i earn?");
        sell_center.add("Register as Merchant");

        List settings = new ArrayList();
        settings.add("Settings 1");
        settings.add("Settings 2");
        settings.add("Settings 3");

        expandableListDetail.put("TECHNOLOGY NEWS", technology);
        expandableListDetail.put("SELL CENTER", sell_center);
        expandableListDetail.put("General Settings", settings);
        return expandableListDetail;
    }
}
