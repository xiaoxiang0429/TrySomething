package com.tianzhen.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tianzhen.viewpager2.R;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * @author Tian
 * @date 2020/6/12.
 * email：piner1029@gmail.com
 * description：
 */
public class BaseBannerAdapter extends BannerAdapter<String, BaseBannerAdapter.BannerViewHolder> {
    public BaseBannerAdapter(List<String> mDatas) {
        //设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
        super(mDatas);
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(final BannerViewHolder holder, final String data, int position, int size) {
        Glide.with(holder.itemView.getContext()).load("").placeholder(R.mipmap.ic_launcher).into(holder.imageView);

    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}
