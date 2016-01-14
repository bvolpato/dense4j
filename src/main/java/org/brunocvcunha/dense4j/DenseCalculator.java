/**
 * Copyright (C) 2015 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brunocvcunha.dense4j;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.brunocvcunha.dense4j.ranker.CaseInsensitiveLinkedHashMap;
import org.brunocvcunha.dense4j.ranker.DenseRankerUtils;

/**
 * Main Class for the Dense4J Calculator
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class DenseCalculator {

    /**
     * Get keywords map based on the repetitions
     * 
     * @param text
     *            text to calculate density
     * @return map
     */
    public static Map<String, Integer> getKeywordsMap(String text) {
        return getKeywordsMap(text, 2);
    }
    
    /**
     * Get keywords map based on the repetitions
     * 
     * @param text
     *            text to calculate density
     * @param minLength
     *            min length of tokens
     * @return map
     */
    public static Map<String, Integer> getKeywordsMap(String text, int minLength) {
        String textLc = text.toLowerCase();
        String[] words = textLc.split("\\W");
        Map<String, Integer> uniques = new HashMap<String, Integer>();
        for (String word : words) {
            // ignore words 2 or less characters long
            if (word.length() <= minLength) {
                continue;
            }

            if (uniques.containsKey(word)) {
                uniques.put(word, uniques.get(word) + 1);
            } else {
                uniques.put(word, 1);
            }
        }

        return DenseRankerUtils.rank(uniques);
    }
    
    
    /**
     * Change actual number of repetitions score to percent
     * @param rank The ranked map
     * @return new map based on the percentage
     */
    public static Map<String, Integer> changeValueToPercent(Map<String, Integer> rank) {
        int total = 0;
        
        for (Integer rankValue : rank.values()) {
            total += rankValue.intValue();
        }
        
        Map<String, Integer> newMap = new CaseInsensitiveLinkedHashMap<Integer>();
        
        for (Entry<String, Integer> entry : rank.entrySet()) {
            newMap.put(entry.getKey(), (entry.getValue() * 100) / total);
        }
        
        return newMap;
        
    }
}
