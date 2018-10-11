package avantica.training.com.myfirstapplication.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import avantica.training.com.myfirstapplication.R;

public class GamerControl extends LinearLayout {
    private Button btnUp;
    private Button btnDown;
    private Button btnLeft;
    private Button btnRight;
    private GamerControlListener listener;
    public GamerControl(Context context) {
        super(context);
        init(context);
    }

    public GamerControl(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GamerControl(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.control_gamer, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // Sets the images for the previous and next buttons. Uses
        // built-in images so you don't need to add images, but in
        // a real application your images should be in the
        // application package so they are always available.
        btnDown = this
                .findViewById(R.id.btnDown);
        btnDown.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAction(ActionGame.DOWN);
            }
        });

        btnLeft = (Button)this
                .findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAction(ActionGame.LEFT);
            }
        });

        btnRight = (Button)this
                .findViewById(R.id.btnRight);
        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAction(ActionGame.RIGHT);
            }
        });

        btnUp = (Button)this
                .findViewById(R.id.btnUp);
        btnUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAction(ActionGame.UP);
            }
        });

    }

    private void sendAction(ActionGame actionGame) {
        if (listener != null) {
            listener.onClickAction(actionGame);
        }
    }

    public void setGameControlListener(GamerControlListener listener) {
        this.listener = listener;
    }

    public interface GamerControlListener {
        void onClickAction(ActionGame actionGame);
    }

    public enum ActionGame {
        UP("UP"), DOWN("DOWN"), LEFT("LEFT"), RIGHT("RIGHT");

        private String description;
        ActionGame(String description) {
          this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
