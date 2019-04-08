package com.example.directorioempleado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.directorioempleado.Modelo.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter implements Filterable {


    Context mContext;
    LayoutInflater inflater;
    private List<Empleado> empleadoLista = null;
    private ArrayList<Empleado> arraylist;

    public ListViewAdapter(Context context, List<Empleado> empleadoLista) {
        mContext = context;
        this.empleadoLista = empleadoLista;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Empleado>();
        this.arraylist.addAll(empleadoLista);
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return empleadoLista.size();
    }

    @Override
    public Empleado getItem(int position) {
        return empleadoLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(empleadoLista.get(position).getNombre() + " " + empleadoLista.get(position).getApellidoP() + " " + empleadoLista.get(position).getApellidoM());
        return view;
    }

    // Filtrado
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        empleadoLista.clear();
        if (charText.length() == 0) {
            empleadoLista.addAll(arraylist);
        } else {
            for (Empleado wp : arraylist) {
                //filtra las coincidencias
                if (wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText) ||
                        wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText)
                        || wp.getApellidoP().toLowerCase(Locale.getDefault()).contains(charText)
                        || wp.getApellidoM().toLowerCase(Locale.getDefault()).contains(charText)) {
                    empleadoLista.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}