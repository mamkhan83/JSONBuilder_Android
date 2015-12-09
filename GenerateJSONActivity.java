package pk.org.assignment6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class GenerateJSONActivity extends Activity
{
    private EditText theJSONET;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_json_generate);
        this.theJSONET = (EditText)this.findViewById(R.id.theJSONET);
        this.theJSONET.setText(JSONBuilderCore.theJSON);
    }
}
