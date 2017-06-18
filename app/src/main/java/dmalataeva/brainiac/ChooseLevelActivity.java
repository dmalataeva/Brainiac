package dmalataeva.brainiac;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dmalataeva on 2017-05-09.
 */

public class ChooseLevelActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context myContext = getApplicationContext();
        setContentView(R.layout.activity_choose_level);
    }
}
