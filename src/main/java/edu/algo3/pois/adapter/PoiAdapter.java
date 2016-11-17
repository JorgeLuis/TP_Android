package edu.algo3.pois.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import edu.algo3.pois.domain.Poi;
import edu.algo3.poissapp.R;

/**
 * Created by Aangus on 13/11/16.
 */
public class PoiAdapter extends ArrayAdapter<Poi> {

    public PoiAdapter(Context context, List<Poi> poi) {
        super(context, R.layout.poi_row, poi);
    }

    @Override
    public long getItemId(int position) {
        Poi poi = getItem(position);

        return poi.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.poi_row, parent, false);
        final Poi poi = getItem(position);

        TextView nombre = (TextView) rowView.findViewById(R.id.lblPoi);
        nombre.setText(poi.getNombre());

        TextView tvActores = (TextView) rowView.findViewById(R.id.lblNombre);
        tvActores.setText(poi.getTipo());
        return rowView;
    }
}
