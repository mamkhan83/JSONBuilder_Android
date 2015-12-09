package pk.org.assignment6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class BuildJSONObjectActivity extends Activity
{
    private ListView theListView;
    private ArrayAdapter<String> theArrayAdapter;
    private Button btnNameValue, btnJSON;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_build_jsonobject);
        btnNameValue = (Button) findViewById(R.id.button);
        btnJSON = (Button) findViewById(R.id.button3);
        this.theListView = (ListView)this.findViewById(R.id.theListView);

        this.theArrayAdapter = new ArrayAdapter<String>(this, R.layout.simple_table_row, R.id.rowText);
        this.theListView.setAdapter(this.theArrayAdapter);
        
        btnNameValue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				addNameValuePairButtonPressed(v);
			}
		});
        btnJSON.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				generateJSONButtonPressed(v);
			}
		});
    }

    public void addNameValuePair(String name, String value)
    {
        this.theArrayAdapter.add(name + ":" + value);
    }
    
    public void addNameValuePair(String name, Integer value)
    {
        this.theArrayAdapter.add(name + ":" + value);
    }
    
    public void addNameValuePair(JSONObject value)
    {
        this.theArrayAdapter.add(value.toString());
    }
    
    public void addNameValuePair(JSONArray value)
    {
        this.theArrayAdapter.add(value.toString());
    }

    public void addNameValuePairButtonPressed(View v)
    {
        JSONBuilderCore.currentBuildJSONObjectActivity = this;
        Intent i = new Intent(this, NameValueActivity.class);
        this.startActivity(i);
    }

    public void generateJSONButtonPressed(View v)
    {
        //create the JSON string
        String answer = "{\n";
        for(int i = 0; i < this.theArrayAdapter.getCount(); i++)
        {
            String[] parts = this.theArrayAdapter.getItem(i).split(":");
            answer += "\t" + "\"" + parts[0] + "\" : \"" + parts[1] + "\"";
            if(i != this.theArrayAdapter.getCount()-1)
            {
                answer += ",\n";
            }
            else
            {
                answer += "\n";
            }
        }
        answer += "}";
        JSONBuilderCore.theJSON = answer;
        Intent i = new Intent(this, GenerateJSONActivity.class);
        this.startActivity(i);
    }
}
