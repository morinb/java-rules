package org.bm.rules;

/**
 * @author Baptiste Morin
 */
public interface Status {
   /**
    * The status' severity represents a degree of importance.
    *
    * The smallest number represents the smallest priority.
    * @return the severity number.
    */
   int getSeverity();

   /**
    * The status description.
    * @return String
    */
   String getDescription();

   /**
    * A possible way to repair the Entry to make it match the Rule.
    * @return String or null.
    */
   String getPossibleResolution();
}
