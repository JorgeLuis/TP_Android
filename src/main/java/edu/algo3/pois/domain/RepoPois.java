package edu.algo3.pois.domain;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PC on 14/11/2016.
 */

public class RepoPois {
    public static List<Poi> poisList = new ArrayList<Poi>();

    private static List<JsonObject> pois;

    public static Map<String, Class<? extends Poi>> tipos;
    static{ tipos  = new HashMap<String, Class<? extends Poi>>() {{
        put("banco", Banco.class);
        put("local", Local.class);
        put("cgp", CGP.class);
        put("colectivo", Colectivo.class);
    }}; }


    public static List<Poi> getPoisList() {
        return poisList;
    }
    public static List<JsonObject> getPois() {
        return pois;
    }

    public static void setPois(List<JsonObject> pois) {
        //RepoPois.pois = pois;

        int a=pois.size();
        for(int i=0;i< pois.size();i++){
                switch(pois.get(i).get("tipo").getAsString()){

                    case "colectivo":
                        Colectivo col = new Colectivo(pois.get(i).get("id").getAsInt());
                        col.setNombre(pois.get(i).get("nombre").getAsString());
                        //col.setCantParadas(pois.get(i).get("cantParadas").getAsInt());
                        poisList.add(col);
                    break;
                    case "banco":
                        Banco banco = new Banco(pois.get(i).get("id").getAsInt());
                        banco.setNombre(pois.get(i).get("nombre").getAsString());
                        banco.setDireccion(pois.get(i).get("direccion").getAsString());
                        for (JsonElement je : pois.get(i).get("servicios").getAsJsonArray()) {
                            banco.agregarServicio(je.getAsString());
                        }
                        poisList.add(banco);
                        break;
                    case "local":
                        Local local = new Local(pois.get(i).get("id").getAsInt());
                        local.setNombre(pois.get(i).get("nombre").getAsString());
                        local.setDireccion(pois.get(i).get("direccion").getAsString());
                        local.setCategoria(pois.get(i).get("categoria").getAsString());
                        for (JsonElement je : pois.get(i).get("palabrasClaves").getAsJsonArray()) {
                            local.agregarPalabrasClaves(je.getAsString());
                        }
                        poisList.add(local);
                        break;
                    case "cgp":
                        CGP cgp = new CGP(pois.get(i).get("id").getAsInt());
                        cgp.setNombre(pois.get(i).get("nombre").getAsString());
                        cgp.setDireccion(pois.get(i).get("direccion").getAsString());
                        poisList.add(cgp);



                }

        }

    }

    public static void setPoisList(List<Poi> poisList) {
        RepoPois.poisList = poisList;
    }

    public static Poi findById(int id){
        for (int i=0; i< poisList.size(); i++) {
            Poi poi = poisList.get(i);
            if (poi.getId() == id) {
                return poi;
            }
        }
        return null;
    }
}
