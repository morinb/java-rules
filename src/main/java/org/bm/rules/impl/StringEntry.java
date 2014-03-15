package org.bm.rules.impl;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.bm.rules.Entry;

import java.util.Map;

/**
 * @author Baptiste Morin
 */
public class StringEntry implements Entry {
    private final String entry;
    private final Map<String, Object> metaDatas ;

    public StringEntry(final String entry) {
        this.entry = entry;
        metaDatas = Maps.newHashMap();
    }

    @Override
    public String getContent() {
        return entry;
    }

    @Override
    public Map<String, Object> getMetaDatas() {
        return metaDatas;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + StringUtils.abbreviate(entry, 25) + '}';
    }
}
