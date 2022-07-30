package io.github.willerlucas.dws.utils;

import io.github.willerlucas.dws.model.Band;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static void orderBandList(String order, List<Band> bandList) {
        //A = ALPHABETICAL ORDER
        //P = POPULARITY ORDER
        if(order.equals("A"))
            Collections.sort(bandList, new SortBandByName());
        if(order.equals("P"))
            Collections.sort(bandList, new SortBandByPopularity());
    }
}
