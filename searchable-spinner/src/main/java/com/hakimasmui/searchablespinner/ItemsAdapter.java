package com.hakimasmui.searchablespinner;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemsAdapter extends ArrayAdapter<String> {
    Typeface font;

    public ItemsAdapter(@NonNull Context context, List<String> items, Typeface typeface) {
        super(context, 0, items);
        this.font = typeface;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items, parent, false);
        }

        TextView tvItem = convertView.findViewById(R.id.tvItem);
        tvItem.setText(item);
        if (font != null)
            tvItem.setTypeface(font);

        return convertView;
    }
}
