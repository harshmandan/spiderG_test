package com.danman.harsh.spidergtest;

/**
 * Created by Harsh on 20-05-2017.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

//Import glide API to fetch images from the internet

public class Rock_thumb_adap extends ArrayAdapter<String> {

        public final String some = new String ("https://i3.ytimg.com/vi/");
        public final String end = new String ("/0.jpg");            //Strings to hold address, see below how these are implemented
        String[] VideoName;
        String[] vid;
        Context mC;

        public Rock_thumb_adap(Context context, String[] vn, String[] vvv) {    //constructor to set video names, vid ID and context
            super(context, R.layout.listview_adap);
            this.VideoName=vn;
            this.vid=vvv;
            this.mC=context;
        }

      @Override
        public int getCount() {
            return VideoName.length; //returns the list size by counting no. of videos in the string array
        }
    @Override

        @NonNull  public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vH = new ViewHolder();  //viewholder implementation to hold the views in memory to employ smoother scrolling
            if(convertView==null) {
                LayoutInflater layinflater = (LayoutInflater) mC.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  //layout inflater to inflate the view
                convertView=layinflater.inflate(R.layout.listview_adap,parent,false);
                vH.iview = (ImageView) convertView.findViewById(R.id.imageView);  //initialize viewholder's imageview and textview to hold data
                vH.tname = (TextView) convertView.findViewById(R.id.textView2);
                convertView.setTag(vH);
            }
            else {
                vH=(ViewHolder)convertView.getTag();
            }
            Glide.with(parent).load(some + vid[position] +end).into(vH.iview); // Use glide APU to load images with the default youtube thumbnail format with video_id in between
            vH.tname.setText(VideoName[position]);  // set text
            return convertView;
        }

        static class ViewHolder     //Viewholder class to improve scrolling
        {
            ImageView iview;
            TextView tname;
        }
    }
