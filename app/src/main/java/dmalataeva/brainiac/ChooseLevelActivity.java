package dmalataeva.brainiac;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by dmalataeva on 2017-05-09.
 */

public class ChooseLevelActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context myContext = getApplicationContext();
        setContentView(R.layout.activity_choose_level);

        LevelScrollView levelScroll = new LevelScrollView(myContext);
        levelScroll.includeLevels();
        ImageView iconEnglish = (ImageView)findViewById(R.id.level_english);
        ImageView iconMath = (ImageView)findViewById(R.id.level_math);
        ImageView iconChemistry = (ImageView) findViewById(R.id.level_chemistry);
        ImageView iconCompSci = (ImageView)findViewById(R.id.level_compsci);


    }
}
