package com.celt.estation.template.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.celt.estation.template.R;
import com.celt.estation.template.bean.FreeApply;
import com.sch.rfview.AnimRFRecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 00013811 on 2016/7/13.
 */
public class FreeCardAdapter extends AnimRFRecyclerView.Adapter<FreeCardAdapter.MyViewHolder>
{
    private Context context;
    private List<FreeApply> freeApplies;
    public FreeCardAdapter(Context context, List<FreeApply> freeApplies) {
        this.context = context;
        this.freeApplies = freeApplies;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.carditems, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {

        FreeApply faoApplyOutput = freeApplies.get(position);

            if(faoApplyOutput.getStatus()==0) {
                holder.tv_estation_apply.setText("即将开始");
            }
      else  if(faoApplyOutput.getStatus()==1) {
            holder.tv_estation_apply.setText("立即申请");
        }
            else if(faoApplyOutput.getStatus()==2) {
            holder.tv_estation_apply.setText("已经结束");
        }
            else if(faoApplyOutput.getStatus()==3) {
            holder.tv_estation_apply.setText("已经申请");
        }
            else if(faoApplyOutput.getStatus()==4) {
            holder.tv_estation_apply.setText("公布中奖名单");
        }
        holder.tv_estation_apply_content.setText(faoApplyOutput.getName());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String sd = sdf.format(new Date(Long.parseLong(faoApplyOutput.getApply_start_time())*1000));
        holder.tv_estation_apply_date.setText(sd);
        holder.tv_estation_apply_num.setText(faoApplyOutput.getNumber()+"人已申请");
         RequestQueue requestQueue = Volley.newRequestQueue(context);
        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(20);
        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public void putBitmap(String key, Bitmap value) {
                lruCache.put(key, value);
            }

            @Override
            public Bitmap getBitmap(String key) {
                return lruCache.get(key);
            }
        };
        ImageLoader imageLoader = new ImageLoader(requestQueue, imageCache);
        holder.iv_good_portrait.setTag("url");
        holder.iv_good_portrait.setImageUrl(faoApplyOutput.getImg_url().get(0),imageLoader);
    }

    @Override
    public int getItemCount()
    {
        return freeApplies.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {


          NetworkImageView iv_good_portrait;
        TextView tv_estation_apply;
          TextView tv_estation_apply_date;
         TextView tv_estation_apply_content;
         TextView tv_estation_apply_num;
        public MyViewHolder(View convertView)
        {
            super(convertView);
            iv_good_portrait = (NetworkImageView) convertView.findViewById(R.id.iv_estation_apply_good_portrait);
            tv_estation_apply = (TextView) convertView.findViewById(R.id.tv_estation_apply_or_not);
           tv_estation_apply_date = (TextView) convertView.findViewById(R.id.tv_estation_apply_date);
            tv_estation_apply_num = (TextView) convertView.findViewById(R.id.tv_estation_apply_num);
            tv_estation_apply_content = (TextView) convertView.findViewById(R.id.tv_estation_apply_content);

        }
    }
}


