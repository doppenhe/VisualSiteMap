package algorithmia.VisualSiteMap;

import com.algorithmia.*;
import java.net.*;
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
    public String apply(String startingUrl, int maxPages,int viewWidth,int viewHeight) throws Exception {
        // Your algorithm code goes here
        
        Object[] mapperInput = {startingUrl, maxPages};
        Map<String,List<String>> sitemap = Algorithmia.algo("/web/BreadthFirstSiteMap/0.2.17").pipe(mapperInput).as(new TypeToken<Map<String,List<String>>>(){});
        Set<String> urls = new HashSet<String>();
        for(String key : sitemap.keySet()) {
            List<String> values = sitemap.get(key);
            urls.add(key);
            urls.addAll(values);
        }
        Integer count = 0;
        for(String key : urls) {
            count++;
            URL url = new URL(key);
            String dataUrl = "data://.algo/perm/" + url.getHost() + url.getPath().replace("/","-") + ".png";
            System.out.println(dataUrl);
            Object[] algoInput = {key, dataUrl, viewWidth, viewHeight};
            String ok = Algorithmia.algo("bkyan/url2png").pipe(algoInput).as(new TypeToken<String>(){});
        }
        return "Done!" + " " + count + " pages imaged.";
    }
}