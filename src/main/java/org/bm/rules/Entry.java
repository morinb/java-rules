package org.bm.rules;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * The Entry interface, represents the object on which the Rule will be applied.
 *
 * @author Baptiste Morin
 */
public interface Entry {
    Logger LOG = Logger.getLogger(Entry.class);

    /**
     * Gets the Entry's content that will be checked by the Rule.
     *
     * @return the Entry's content.
     */
    String getContent();

    /**
     * Gets the Entry's metadatas map, that will contains
     * additional informations usable while checking the Entry's validity.
     *
     * @return metadata map.
     */
    Map<String, Object> getMetaDatas();

}
