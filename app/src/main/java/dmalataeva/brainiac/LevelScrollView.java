package dmalataeva.brainiac;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by dmalataeva on 2017-06-20.
 */

public class LevelScrollView extends HorizontalScrollView {

    private ArrayList<ImageView> levelViews = null;
    private String levelName[] = {"level_english", "level_math", "level_chemistry", "level_compsci"};
    private GestureDetector gestureDetector;
    private int selectionLevel = 0;

    public LevelScrollView(Context context, AttributeSet attributes, int defStyleAttr) {
        super(context, attributes, defStyleAttr);
    }

    public LevelScrollView(Context context, AttributeSet attributes) {
        super(context, attributes);
    }

    public LevelScrollView(Context context) {
        super(context);
    }

    public void includeLevels(String levels[]) {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear_layout_scroll);
        for ( int i = 0; i <= 4; i++ ) {
            //ImageView this_level = (ImageView)getResources().getIdentifier(levelName[i], "id", "dmalataeva.brainiac");
        }
    }

}
