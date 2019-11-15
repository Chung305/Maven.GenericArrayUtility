package com.zipcodewilmington.arrayutility;



import javax.xml.stream.StreamFilter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T>  {

    private T[] data;

    public ArrayUtility(T[] data) {
        this.data = data;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){

        return Stream.concat(Stream.of(data),Stream.of(arrayToMerge)).collect(Collectors.toList()).stream()
                .filter(i -> i == valueToEvaluate).collect(Collectors.toList()).size();
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){

        return null;
    }

    public T[] removeValue(T valueToRemove){

        return null;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){

        return null;
    }
}
