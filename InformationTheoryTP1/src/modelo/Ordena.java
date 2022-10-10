package modelo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Ordena {
    public static <K, V extends Comparable<V> > Map<K, V> valueSort(final Map<K,V> map){

        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2)
            {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }
}
