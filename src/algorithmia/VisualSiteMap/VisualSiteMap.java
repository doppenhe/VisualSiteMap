package algorithmia.VisualSiteMap;

import com.algorithmia.*;
import com.algorithmia.algo.*;
import com.algorithmia.data.*;
import com.google.gson.*;
import java.util.*;

/**
 * This class defines your algorithm, and its input/output.
 * Algorithms must define at least one apply(...) method.
 *
 * Examples:
 *   public int apply(int[][] array) {...}
 *   public String apply(Map<String,String> object) {...}
 *   public List<Double> apply(double a, double b, double c) {...}
 */
public class VisualSiteMap {
    // The input and output of apply() automatically turns into JSON
    public String apply(String input) throws Exception {
        // Your algorithm code goes here
        return "Hello " + input;
    }
}