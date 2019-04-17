package nv.thuong.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import nv.thuong.model.CacSo;
import nv.thuong.thi_giua_ky.R;

public class PhepChiaAdapter extends ArrayAdapter<CacSo> {
    Activity context;
    int resource;
    List<CacSo> objects;
    public PhepChiaAdapter(Activity context, int resource, List<CacSo> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }


    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row= inflater.inflate(this.resource,null);
        TextView itemKQ = (TextView) row.findViewById(R.id.itemKQ);
        CacSo cacSo = this.objects.get(position);

        itemKQ.setText(cacSo.getTxtKQ());

        return row;
    }
}
