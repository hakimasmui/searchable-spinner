package com.hakimasmui.searchablespinner;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SearchableSpinner extends LinearLayout {

    LinearLayout linSpinner;
    RelativeLayout relSpinner;
    TextView label;

    Typeface font;
    Drawable background;
    String hint;
    String header;
    String text;
    List<String> items = new ArrayList<>();

    OnItemSelected onItemSelected;

    public SearchableSpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray s = context.obtainStyledAttributes(attrs, R.styleable.SearchableSpinner, 0, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            font = s.getFont(R.styleable.SearchableSpinner_font);
        }
        background = s.getDrawable(R.styleable.SearchableSpinner_background);
        hint = s.getString(R.styleable.SearchableSpinner_hint);
        header = s.getString(R.styleable.SearchableSpinner_header);
        text = s.getString(R.styleable.SearchableSpinner_text);

        s.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.spinner, this, true);

        linSpinner = v.findViewById(R.id.linSpinner);
        relSpinner = v.findViewById(R.id.relSpinner);
        label = v.findViewById(R.id.label);

        label.setText(text);

        if (background != null) {
            relSpinner.setBackground(background);
        }

        linSpinner.setOnClickListener(view -> {
            dialogPilihan(context, hint);
        });
    }

    public SearchableSpinner(Context context) {
        this(context, null);
    }

    public void dialogPilihan(Context context, String hint) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(true);

        LayoutInflater inflater = LayoutInflater.from(context);
        View vi = inflater.inflate(R.layout.dialog_pilihan, null);
        TextView tvHeader = vi.findViewById(R.id.header);
        EditText edtSearch = vi.findViewById(R.id.edtSearch);
        ListView listItem = vi.findViewById(R.id.listItem);

        if (font != null)
            tvHeader.setTypeface(font);

        ArrayAdapter<String> adapter = new ItemsAdapter(context, items, font);
        listItem.setAdapter(adapter);
        listItem.setOnItemClickListener((adapterView, view, i, l) -> {
            if (adapter.getItem(i) != null) {
                label.setText(adapter.getItem(i));
                if (onItemSelected != null) {
                    onItemSelected.onSelected(adapter.getItem(i), i);
                }
            }
            dialog.dismiss();
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tvHeader.setText(header);
        edtSearch.setHint(hint);

        dialog.setView(vi);

        try {
            dialog.show();

            dialog.getWindow().setLayout(new RoundDialog().getWidth(context), ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        } catch (Exception e) {

        }
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void setLabelSelected(String string) {
        label.setText(string);
    }

    public interface OnItemSelected {
        void onSelected(String nama, int position);
    }

    public void setOnItemSelected(OnItemSelected onItemSelected) {
        this.onItemSelected = onItemSelected;
    }
}
