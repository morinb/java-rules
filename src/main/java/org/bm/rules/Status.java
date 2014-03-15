package org.bm.rules;

/**
 * @author Baptiste Morin
 */
public interface Status {
    /**
     * The status' severity represents a degree of importance.
     * <p/>
     * The smallest number represents the smallest priority.
     *
     * @return the severity number.
     */
    int getSeverity();

    /**
     * Gets a codename for this status.
     * @return the status' code.
     */
    String getCode();


    /**
     * The status description.
     *
     * @return String
     */
    String getDescription();

    /**
     * A possible way to repair the Entry to make it match the Rule.
     *
     * @return String or null.
     */
    String getPossibleResolution();

    /**
     *
     * @return true if the status represents an Error status.
     */
    boolean isErrorStatus();
}
