package pk.org.assignment6;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TypePickerActivity extends Activity implements OnClickListener {

	private Button btnTypeInt, btnTypeString, btnTypeJsonObject,
			btnTypeJsonArray;
	private String name, value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_type_picker);

		name = getIntent().getStringExtra("name");
		value = getIntent().getStringExtra("value");

		btnTypeInt = (Button) findViewById(R.id.button_number);
		btnTypeString = (Button) findViewById(R.id.button_string);
		btnTypeJsonObject = (Button) findViewById(R.id.button_jsonobject);
		btnTypeJsonArray = (Button) findViewById(R.id.button_jsonarray);

		btnTypeInt.setOnClickListener(this);
		btnTypeString.setOnClickListener(this);
		btnTypeJsonObject.setOnClickListener(this);
		btnTypeJsonArray.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		try {
			switch (view.getId()) {
			case R.id.button_number:
				try {
					JSONBuilderCore.currentBuildJSONObjectActivity
							.addNameValuePair(this.name,
									Integer.parseInt(value));
					this.onBackPressed();
				} catch (NumberFormatException e) {
					Toast.makeText(getApplicationContext(),
							"Invalid number entered", Toast.LENGTH_SHORT)
							.show();
				}
				break;
			case R.id.button_string:
				JSONBuilderCore.currentBuildJSONObjectActivity.addNameValuePair(
						this.name, this.value);
				break;
			case R.id.button_jsonobject:
				try {
					String json = '{'+this.name + ':'
							+ this.value+'}';
					JSONBuilderCore.currentBuildJSONObjectActivity
							.addNameValuePair(new JSONObject(json));
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"Invalid JSON Format", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.button_jsonarray:
				try {
					String jsonArr = "[{"+this.name + ':'
							+ this.value+"}]";
					JSONBuilderCore.currentBuildJSONObjectActivity
							.addNameValuePair(new JSONArray(jsonArr));
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"Invalid JSONArray Format", Toast.LENGTH_SHORT)
							.show();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.onBackPressed();
	}
}
