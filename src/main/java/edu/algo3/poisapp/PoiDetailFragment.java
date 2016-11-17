package edu.algo3.poisapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.algo3.pois.adapter.CategoriaPoiAdapter;
import edu.algo3.pois.domain.Banco;
import edu.algo3.pois.domain.Local;
import edu.algo3.pois.domain.Poi;
import edu.algo3.poissapp.R;

/**
 * A fragment representing a single Poi detail screen.
 * This fragment is either contained in a {@link PoiListActivity}
 * in two-pane mode (on tablets) or a {@link PoiDetailActivity}
 * on handsets.
 */
public class PoiDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Poi selectPoi;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PoiDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            selectPoi = (Poi) getArguments().get(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(selectPoi.getNombre());
            } else {
                activity.setTitle(selectPoi.getNombre());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = null;



        // Show the dummy content as text in a TextView.
        if (selectPoi != null) {

            switch (selectPoi.getTipo()){
                case "colectivo":
                    rootView=colectivoView(inflater, container,savedInstanceState);
                    break;
                case "banco":
                    rootView=bancoView(inflater, container,savedInstanceState);
                    break;
                case "local":
                    rootView=localView(inflater, container,savedInstanceState);
                    break;
                case "cgp":
                rootView=cgpView(inflater, container,savedInstanceState);
                break;

            }

            ((TextView) rootView.findViewById(R.id.poi_categoria)).setText(selectPoi.getTipo());
            ImageView imgGenero = ((ImageView) rootView.findViewById(R.id.imgGenero));
            imgGenero.setImageDrawable(getResources().getDrawable(new CategoriaPoiAdapter().getIconoGenero(selectPoi)));

        }

        return rootView;
    }

    private View colectivoView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_poi_colectivo_detail, container, false);

    return rootView;
    }
    private View bancoView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_poi_banco_detail, container, false);
        ((TextView) rootView.findViewById(R.id.dia_atencion)).setText(((Banco)selectPoi).getServicio().toString());
        ((TextView) rootView.findViewById(R.id.poi_direccion)).setText(selectPoi.getDireccion());
        return rootView;
    }
    private View cgpView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_poi_cgp_detail, container, false);
        ((TextView) rootView.findViewById(R.id.poi_direccion)).setText(selectPoi.getDireccion());
        return rootView;
    }
    private View localView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_poi_local_detail, container, false);
        ((TextView) rootView.findViewById(R.id.categoria)).setText(((Local)selectPoi).getCategoria().toString());
        ((TextView) rootView.findViewById(R.id.poi_claves)).setText(((Local)selectPoi).getPalabrasClaves().toString());
        ((TextView) rootView.findViewById(R.id.poi_direccion)).setText(selectPoi.getDireccion());
        return rootView;
    }
}
