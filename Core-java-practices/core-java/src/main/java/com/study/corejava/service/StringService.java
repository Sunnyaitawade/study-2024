package com.study.corejava.service;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Avaruus Studios
 * @name StringService
 * @date 7/11/2024
 */
@Service
public class StringService {

public String findRepeatedStrCount(String inputStr){
    Map<Character, Long> duplicateCharacters =  inputStr
            .chars()
            .mapToObj(value -> (char) value)
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .entrySet()
            .stream()
          .filter(characterLongEntry -> !Character.isWhitespace(characterLongEntry.getKey()) && characterLongEntry.getValue() > 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ));

   return duplicateCharacters
           .entrySet()
           .stream()
           .map(characterLongEntry-> characterLongEntry.getKey() +":"+characterLongEntry.getValue())
           .collect(Collectors.joining(", "));

}
public String findDuplicateString(String inputStr){

     return "";
}
}
