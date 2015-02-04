package com.paypal.first.contactsadapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<ContactBean> {

    private Activity activity;
    private List<ContactBean> contacts;
    private int row;
    private ContactBean contactBean;

    public ContactAdapter(Activity act, int row, List<ContactBean> contacts) {
        super(act, row, contacts);
        this.activity = act;
        this.row = row;
        this.contacts = contacts;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, null);

            holder = new ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if ((contacts == null) || ((position + 1) > contacts.size()))
            return view;

        contactBean = contacts.get(position);


        holder.tvname = (TextView) view.findViewById(R.id.tvname);
        holder.tvPhoneNo = (TextView) view.findViewById(R.id.tvphone);


        if (holder.tvname != null && null != contactBean.getName()
                && contactBean.getName().trim().length() > 0) {
            holder.tvname.setText(Html.fromHtml(contactBean.getName()));
        }
        if (holder.tvPhoneNo != null && null != contactBean.getPhoneNo()
                && contactBean.getPhoneNo().trim().length() > 0) {
            holder.tvPhoneNo.setText(Html.fromHtml(contactBean.getPhoneNo()));
        }

        return view;
    }

    public class ViewHolder {
        public TextView tvname, tvPhoneNo;
    }

}
