package dmalataeva.brainiac;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class BrainiacActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context myContext = getApplicationContext();
        setContentView(R.layout.activity_brainiac);

        addLogo(myContext);
        addButtonPlay();
        addButtonHighscores();
        addButtonExit();
    }

    public void addLogo(Context cont) {
        ImageView logo = (ImageView)findViewById(R.id.logo);
        AnimatorSet logoSet = (AnimatorSet) AnimatorInflater.loadAnimator(cont, R.animator.animation_logo);
        logoSet.setTarget(logo);
        logoSet.start();
    }

    public void addButtonPlay() {
        ImageButton play = (ImageButton)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "PLAY is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addButtonHighscores() {
        ImageButton highscores = (ImageButton)findViewById(R.id.highscores);
        highscores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "HS is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addButtonExit() {
        ImageButton exit = (ImageButton)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "EXIT is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
