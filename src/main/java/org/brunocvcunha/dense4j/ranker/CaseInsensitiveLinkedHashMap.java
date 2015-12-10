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
