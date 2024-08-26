package com.study.corejava.service;

import com.study.corejava.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @name NumberService
 * @author NSA Studios
 * @date 8/24/2024
 */
@Service
public class NumberService {

    /**
     * Method:     1- Check if a list of integers contains a prime number using Java streams
     */
    public List<Integer> getPrimeNumbers(Integer inputNumber) {

        return IntStream.rangeClosed(1,inputNumber).map(operand -> {
            boolean isPrime =true;

            if (operand <= 1) {
                isPrime =false;
            }
            for (int i = 2; i <= Math.sqrt(operand); i++) {
                if (operand % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                return operand;
            }
            return 0;
        }).filter(value -> value!=0).boxed().toList() ;
    }

}
