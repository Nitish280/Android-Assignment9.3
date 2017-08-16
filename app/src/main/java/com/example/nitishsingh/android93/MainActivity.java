package com.example.nitishsingh.android93;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //declaration

    ListView listView;
    ListViewAdapter listViewAdapter;
    int index=0;
    //here we taking to different String
    private final static String name[]={"Nitish","Vikash","Vishal","Abhishek","Utkarsh","Sachin","Ritik","Bhawani","Vishwas","Mithun","Utkarsh"};
    private final static String number[]={"8791108392","9754367876","8798545642","7854378929","7154896547","9065378432","7809457254",
            "9097534246","7589435686","8165890432","7954637892"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);
        listViewAdapter = new ListViewAdapter(this,name,number);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(this, "Long press to Call /SMS", Toast.LENGTH_SHORT).show();
        index=position;
    }

    @Override
    //here we are creating context Menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //here we are adding header in the menu
        menu.setHeaderTitle("Select the Action");
        //here we are adding two diffrent action in the menu
        menu.add(0, 1, 0, "Call");
        menu.add(0, 2, 1, "Send SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //here we are applying condition for two different action
        try {
            //here we are applying condition for call
            if(item.getItemId()==1 && item.getGroupId()==0){
                //here we are creating intent
                Intent i=new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+number[index]));
                startActivity(i);
            }
            //here we are applying condition for sms
            else if(item.getItemId()==2 && item.getGroupId()==0){
                //here we are creating intent
                Intent i=new Intent();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+ number[index])));
                startActivity(i);
            }
            else{
                return false;
            }
            return true;
        } catch (Exception e) {
            return true;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
