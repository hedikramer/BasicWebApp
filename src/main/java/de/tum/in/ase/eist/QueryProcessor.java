package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "hedi";
        } else if(query.contains("which of the following numbers is the largest:")) {
            String[] split = query.split(":");
            String numbers = split[1];
            String[] numbersOnly = numbers.split(",");
            int min = Integer.parseInt(numbersOnly[0]);
            int index = 0;
            for (int i = 0; i < numbersOnly.length; i++) {
                if (Integer.parseInt(numbersOnly[index]) > min) {
                    min = Integer.parseInt(numbersOnly[index]);
                    index++;
                }
            }
            return String.valueOf(min);
        }else if (query.contains("what is")) {
            String[] split = query.split("\\s+");
            int firstNumber = Integer.parseInt(split[2]) + Integer.parseInt(split[4]);
            return String.valueOf(firstNumber);
        }
            return "";
        }
}
