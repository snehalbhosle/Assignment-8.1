package com.project.my.assignment8_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewDemo extends AppCompatActivity {

    GridView androidGridView;
    String[] web = {
            "GingerBread",
            "Honeycomb",
            "IceCream",
            "JellyBean",
            "Kitkat",
            "Lollipop"
    };
    Integer[] imageIDs = {
            R.drawable.gingerbreadimage,
            R.drawable.honeycombimage,
            R.drawable.icecreamimage,
            R.drawable.jellybeanimage,
            R.drawable.kitkatimage,
            R.drawable.lollipopimage
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);
        androidGridView = (GridView) findViewById(R.id.grid);
        androidGridView.setAdapter(new ImageAdapterGridView(this, web, imageIDs));

    }

    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;
        private final String[] web;
        private final Integer[] Imageid;

        public ImageAdapterGridView(Context c, String[] web, Integer[] Imageid) {
            mContext = c;
            this.Imageid = Imageid;
            this.web = web;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return web.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View grid;

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {

                grid = new View(mContext);
                grid = inflater.inflate(R.layout.grid_single, null);
                TextView textView = (TextView) grid.findViewById(R.id.grid_text);
                ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
                textView.setText(web[position]);
                imageView.setImageResource(Imageid[position]);
            } else {
                grid = (View) convertView;
            }

            return grid;
        }
    }
}
