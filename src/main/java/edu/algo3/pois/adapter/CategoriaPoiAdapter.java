package edu.algo3.pois.adapter;

import java.util.HashMap;
import java.util.Map;

import edu.algo3.pois.domain.Poi;
import edu.algo3.poissapp.R;

/**
 * Created by Aangus on 13/11/16.
 */
public class CategoriaPoiAdapter {

    static Map<String, Integer> mapaCategoria;

    private Map<String, Integer> getMapaGeneros() {
        if (mapaCategoria == null) {
            mapaCategoria = new HashMap<String, Integer>();
            mapaCategoria.put("banco", R.drawable.banco);
            mapaCategoria.put("Cgp", R.drawable.cgp);
            mapaCategoria.put("colectivo", R.drawable.colectivo);
            mapaCategoria.put("local", R.drawable.local);
        }
        return mapaCategoria;
    }

    public int getIconoGenero(Poi poi) {
        Integer result = getMapaGeneros().get(poi.getTipo());
        if (result == null) {
            return R.drawable.cgp;
        }
        return result.intValue();
    }

}
