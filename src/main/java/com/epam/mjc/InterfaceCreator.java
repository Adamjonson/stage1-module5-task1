package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {

            for (String str : x){
                try {
                    Integer.parseInt(str);
                    return false;
                }
                catch (NumberFormatException e) {}
                char firstLetter = str.charAt(0);
                if (Character.isLowerCase(firstLetter)){
                    return false;
                }
            }
            return true;
        };
        // throw new UnsupportedOperationException("You should implement this method.");
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
          List<Integer> newList = new ArrayList<>();
          newList.addAll(x);
          for (Integer value : x){
              if (value % 2 == 0){
                  newList.add(value);
              }
          }
          x.clear();
          x.addAll(newList);
        };
        // throw new UnsupportedOperationException("You should implement this method.");
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> newValues = new ArrayList<>();
            for (String str : values){
                char firstLetter = str.charAt(0);
                if (Character.isUpperCase(firstLetter) && str.endsWith(".") && str.length()>3){
                    newValues.add(str);
                }
            }

            return newValues;
        };
        //throw new UnsupportedOperationException("You should implement this method.");
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> myMap = new HashMap<>();
            for (String str : x){
                myMap.put(str, str.length());
            }

            return myMap;
        };
        //throw new UnsupportedOperationException("You should implement this method.");
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> ints = new ArrayList<>();
            ints.addAll(list1);
            ints.addAll(list2);
            return ints;
        };
        //throw new UnsupportedOperationException("You should implement this method.");
    }
}
