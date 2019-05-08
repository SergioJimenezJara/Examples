package com.example.retrofit_example.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.retrofit_example.R;
import com.example.retrofit_example.model.Repository;

import java.util.List;

public class RepositoryAdapter extends ArrayAdapter<Repository> {

    private Context context;
    private List<Repository> values;

    public RepositoryAdapter(Context context, List<Repository> values) {
        super(context, R.layout.layout_listview, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_listview, parent, false);
        }

        TextView tvName = (TextView) row.findViewById(R.id.tvName);
        TextView tvURL = (TextView) row.findViewById(R.id.tvURL);

        Repository item = values.get(position);

        tvName.setText(item.getName());
        tvURL.setText(item.getUrl());

        return row;
    }
}