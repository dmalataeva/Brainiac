package dmalataeva.brainiac;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dmalataeva on 2017-06-20.
 */

public class LevelScrollView extends HorizontalScrollView {

    private ArrayList<ImageView> levelViews;
    private String levelName[] = {"level_english", "level_math", "level_chemistry", "level_compsci"};
    private GestureDetector gestureDetector;
    private int selectionLevel = 0;

    private static final int SWIPE_DISTANCE_MIN = 5;
    private static final int VELOCITY_MIN = 300;

    public LevelScrollView(Context context, AttributeSet attributes, int defStyleAttr) {
        super(context, attributes, defStyleAttr);
    }

    public LevelScrollView(Context context, AttributeSet attributes) {
        super(context, attributes);
    }

    public LevelScrollView(Context context) {
        super(context);
    }

    public void includeLevels() {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear_layout_scroll);
        levelViews = new ArrayList<ImageView>();
        for ( int i = 0; i < 4; i++ ) {
            int id = getResources().getIdentifier(levelName[i], "id", getContext().getPackageName());
            levelViews.add((ImageView)findViewById(id));
        }

        setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View level, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                    int scrollX = getScrollX();
                    int viewWidth = level.getMeasuredWidth();
                    selectionLevel = ((scrollX + viewWidth/2)/viewWidth);
                    int scrollTo = selectionLevel * viewWidth;
                    smoothScrollTo(scrollTo, 0);
                    Toast.makeText(getContext(), "AY", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            }
        });

        gestureDetector = new GestureDetector(getContext(), new LevelGestureDetector());
    }

    public class LevelGestureDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float vx, float vy) {
            try {
                // Left to Right
                if (e2.getX() - e1.getX() > SWIPE_DISTANCE_MIN && Math.abs(vx) > VELOCITY_MIN) {
                    int viewWidth = getMeasuredWidth();
                    selectionLevel = selectionLevel < (levelViews.size() - 1)? selectionLevel + 1 : levelViews.size() - 1;
                    smoothScrollTo(selectionLevel * viewWidth, 0);
                    Toast.makeText(getContext(), "swiped right!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                // Right to Left
                if (e1.getX() - e2.getX() > SWIPE_DISTANCE_MIN && Math.abs(vx) > VELOCITY_MIN) {
                    int viewWidth = getMeasuredWidth();
                    selectionLevel = selectionLevel > 0? selectionLevel - 1 : 0;
                    smoothScrollTo(selectionLevel * viewWidth, 0);
                    Toast.makeText(getContext(), "swiped left!", Toast.LENGTH_SHORT).show();
                    return true;
                }

            } catch (Exception e) {
                Log.e("Motion", "There was an error detecting the swiping event: " + e.getMessage());
            }
            return false;
        }

    }

}
