package io.github.willerlucas.dws.utils;

import io.github.willerlucas.dws.model.Band;

import java.util.Comparator;

public class SortBandByName implements Comparator<Band> {
    @Override
    public int compare(Band band1, Band band2) {
        return band1.getName().compareTo(band2.getName());
    }
}
