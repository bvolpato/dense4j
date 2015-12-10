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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Case insensitive LinkedHashMap
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 * @param <V>
 *            The type of values
 */
public class CaseInsensitiveLinkedHashMap<V> extends LinkedHashMap<String, V> {

    /**
     * 
     */
    private static final long serialVersionUID = -3636811866458661418L;


    /**
     * Default Constructor
     */
    public CaseInsensitiveLinkedHashMap() {
        super();
    }
    
    /**
     * Constructor
     * @param newMap Map to use the values
     */
    public CaseInsensitiveLinkedHashMap(Map<String, V> newMap) {
        super(newMap);
    }

    @Override
    public V get(Object key) {
        return super.get(key.toString().toLowerCase());
    }

}
