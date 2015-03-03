package com.lalvani.anand.cs491interface;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener
{

    public static final ListItem[] items = new ListItem[]
    {
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine"),
        new ListItem(R.drawable.marine, "10" , "Marine")
    };

    ListView listView;
    List<ListItem> rowItems;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.list_item, items);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
