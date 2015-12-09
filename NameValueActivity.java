package pk.org.assignment6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NameValueActivity extends Activity
{
    private EditText nameET;
    private EditText valueET;
    private Button btnSetValue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_create_name_and_value);

        this.nameET = (EditText)this.findViewById(R.id.nameET);
        this.valueET = (EditText)this.findViewById(R.id.valueET);
        btnSetValue = (Button) findViewById(R.id.button2);
        btnSetValue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setValueButtonPressed(v);
			}
		});
    }

    public void setValueButtonPressed(View v)
    {
    	Intent intent = new Intent(NameValueActivity.this, TypePickerActivity.class);
    	intent.putExtra("name", nameET.getText().toString());
    	intent.putExtra("value", valueET.getText().toString());
    	startActivity(intent);
       // BuilderCore.currentBuildJSONObjectActivity.addNameValuePair(this.nameET.getText().toString(), this.valueET.getText().toString());
        // this.onBackPressed();
    }
}
