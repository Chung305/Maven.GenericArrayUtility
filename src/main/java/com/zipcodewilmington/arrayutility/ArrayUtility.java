package com.zipcodewilmington.arrayutility;



import javax.xml.stream.StreamFilter;
import java.lang.reflect.Array;
import java.util.*;
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

        List<T> mergedArray = Stream.concat(Stream.of(data), Stream.of(arrayToMerge)).collect(Collectors.toList());

        Map<T , Long> map = mergedArray.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        long occurence = 0;
        T value = null;
        for(Map.Entry<T, Long>  each : map.entrySet()){
            if(each.getValue() > occurence){
                occurence = each.getValue();
                value = each.getKey();
            }
        }

        return value;
    }

    public T[] removeValue(T valueToRemove){

        List<T> array =  Arrays.stream(data).filter(i -> i != valueToRemove).collect(Collectors.toList());

        T[] result = Arrays.copyOf(this.data, array.size());

        for(int i = 0; i < array.size(); i++){
            result[i] = array.get(i);
        }

        return result;



    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){

        return Arrays.stream(data).filter(i -> i == valueToEvaluate).toArray(Object[]::new).length;
    }
}
