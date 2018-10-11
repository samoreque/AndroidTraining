package avantica.training.com.myfirstapplication.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

public class PrefixTextView extends AppCompatTextView {
    public PrefixTextView(Context context) {
        super(context);
        init();
    }

    public PrefixTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PrefixTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        text = "PRE-" + text;
        super.setText(text, type);
    }
    public void init() {
        this.setText("POST",null);
    }
}
