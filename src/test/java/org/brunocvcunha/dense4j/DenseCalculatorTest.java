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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Map;

import org.junit.Test;

public class DenseCalculatorTest {

    @Test
    public void simpleDensity() {
        String text = "Dense4j is an API developed by Bruno Candido Volpato da Cunha. " +
                "Bruno de to st Dense4j in 2015.";
                
        Map<String, Integer> density = DenseCalculator.getKeywordsMap(text);
        assertEquals(8, density.size());
        
        System.out.println(density);
        
        assertFalse(density.containsKey("is"));
        assertFalse(density.containsKey("an"));
        assertEquals(2, density.get("dense4j").intValue());
        assertEquals(1, density.get("api").intValue());
        assertEquals(1, density.get("developed").intValue());
        assertEquals(2, density.get("Bruno").intValue());
        assertEquals(1, density.get("candido").intValue());
        assertEquals(1, density.get("volpato").intValue());
        assertEquals(1, density.get("cunha").intValue());
        assertEquals(1, density.get("2015").intValue());
        
        Map<String, Integer> percentDensity = DenseCalculator.changeValueToPercent(density);
        assertEquals(20, percentDensity.get("dense4j").intValue());
        assertEquals(10, percentDensity.get("api").intValue());
        assertEquals(10, percentDensity.get("developed").intValue());
        assertEquals(20, percentDensity.get("Bruno").intValue());
        assertEquals(10, percentDensity.get("candido").intValue());
        assertEquals(10, percentDensity.get("volpato").intValue());
        assertEquals(10, percentDensity.get("cunha").intValue());
        assertEquals(10, percentDensity.get("2015").intValue());

    }
}
