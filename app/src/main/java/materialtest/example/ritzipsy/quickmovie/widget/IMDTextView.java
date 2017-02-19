package materialtest.example.ritzipsy.quickmovie.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.util.AttributeSet;
import android.widget.TextView;

public class IMDTextView extends TextView {

	private final static String NAME = "LatoRegular";
	private static LruCache<String, Typeface> sTypefaceCache = new LruCache<String, Typeface>(12);

	public IMDTextView(Context context) {
        super(context);
//        if(!isInEditMode()){
//            init();
//        }
	}

	public IMDTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
//        if(!isInEditMode()){
//            init();
//        }
	}

	public void init() {
		Typeface typeface = sTypefaceCache.get(NAME);
		if (typeface == null) {
         	typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Regular.ttf");
			sTypefaceCache.put(NAME, typeface);
		}
		setTypeface(typeface);
	}

}


