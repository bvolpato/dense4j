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
import java.util.Map;

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
        String textLc = text.toLowerCase();
        String[] words = textLc.split("\\W");
        Map<String, Integer> uniques = new HashMap<String, Integer>();
        for (String word : words) {
            // ignore words 2 or less characters long
            if (word.length() <= 2) {
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
}
