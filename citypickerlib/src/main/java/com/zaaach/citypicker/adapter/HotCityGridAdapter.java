package com.zaaach.citypicker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zaaach.citypicker.R;
import com.zaaach.citypicker.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * author zaaach on 2016/1/26.
 */
public class HotCityGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<City> mCities;
//    String  string1 [][]={{"北京","beijing","110100"},{"上海","shanghai","310100"}
//                            ,{"广州","guangzhou","310100"},{"深圳","shengzheng","440300"}
//                            ,{"杭州","hangzhou","330100"},{"南京","nanjing","320100"}
//                            ,{"天津","tianjin","120100"},{"武汉","wuhan","420100"}
//                            ,{"重庆","zhongqing","500100"}
//};
    private  String  string1 [] = {"北京","上海","广州","深圳","杭州","南京","天津","武汉","重庆"};
    private  String  string2 [] = {"beijing","shanghai","guangzhou","shengzheng","hangzhou","nanjing","tianjin","wuhan","zhongqing"};
    private  String  string3 [] = {"110100","310100","440100","440300","330100","320100","120100","420100","500100"};
    private City city ;
    public HotCityGridAdapter(Context context) {
        this.mContext = context;
        mCities = new ArrayList<>();
        for (int i = 0; i < string1.length; i++) {
            city = new City(string1[i],string2[i],string3[i]);
            mCities.add(city);
        }
//        city= new City("北京","beijing","110100");
//        city= new City("上海","shanghai","310100");
//        city= new City("广州","guangzhou","440100");
//        city= new City("深圳","shengzheng","440300");
//        city= new City("杭州","hangzhou","330100");
//        city= new City("南京","nanjing","320100");
//        city= new City("天津","tianjin","120100");
//        city= new City("武汉","wuhan","420100");
//        city= new City("重庆","zhongqing","500100");

//        mCities.add("北京");
//        mCities.add("上海");
//        mCities.add("广州");
//        mCities.add("深圳");
//        mCities.add("杭州");
//        mCities.add("南京");
//        mCities.add("天津");
//        mCities.add("武汉");
//        mCities.add("重庆");
    }

    @Override
    public int getCount() {
        return mCities == null ? 0 : mCities.size();
    }

    @Override
    public String getItem(int position) {
        return mCities == null ? null : mCities.get(position).getName();
    }
    public String getItemCity_id(int position) {
        return mCities == null ? null : mCities.get(position).getCity_id();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        HotCityViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.cp_item_hot_city_gridview, parent, false);
            holder = new HotCityViewHolder();
            holder.name = (TextView) view.findViewById(R.id.tv_hot_city_name);
            view.setTag(holder);
        }else{
            holder = (HotCityViewHolder) view.getTag();
        }
        holder.name.setText(mCities.get(position).getName());
        return view;
    }

    public static class HotCityViewHolder{
        TextView name;
    }
}
