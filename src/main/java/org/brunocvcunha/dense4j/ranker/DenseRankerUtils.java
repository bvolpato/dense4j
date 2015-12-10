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
package org.brunocvcunha.dense4j.ranker;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map utilities
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class DenseRankerUtils {

    /**
     * Rank Map based on the value
     * 
     * @param inputMap the map to rank
     * @return new ranked map
     */
    public static Map<String, Integer> rank(Map<String, Integer> inputMap) {
        Map<String, Integer> newMap = new TreeMap<String, Integer>(new IntegerValueComparator(inputMap));
        newMap.putAll(inputMap);

        
        Map<String, Integer> linkedMap = new CaseInsensitiveLinkedHashMap<Integer>(newMap);
        return linkedMap;
    }

}

