package com.android.arrays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer pics[] = {R.drawable.pic1};
        String result[] = getResources().getStringArray(R.array.cust_array);
        try {
            String name = "",code = "";
            JSONObject objName = null;
            StringTokenizer st = new StringTokenizer("");
            for (int i=0; i<result.length; i++)
            {
                JSONObject json= (JSONObject) new JSONTokener(result[i]).nextValue();
                name = (String)json.getString("name");
                code = json.get("code").toString();
            }

            ImageView imageView = (ImageView)findViewById(R.id.imageViewCust);
            imageView.setImageResource(pics[0]);
            TextView tv = (TextView)findViewById(R.id.TextViewCust);
            tv.setText(name + " " + code);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
