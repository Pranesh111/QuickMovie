package materialtest.example.ritzipsy.quickmovie.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.util.AttributeSet;
import android.widget.TextView;


public class IMDTextViewBold extends TextView {

	private final static String NAME = "SourceSansRegular";
	private static LruCache<String, Typeface> sTypefaceCache = new LruCache<String, Typeface>(12);

	public IMDTextViewBold(Context context) {

        super(context);
//        if(!isInEditMode()){
//            init();
//        }
	}

	public IMDTextViewBold(Context context, AttributeSet attrs) {
		super(context, attrs);
//        if(!isInEditMode()){
//            init();
//        }
	}

	public void init() {

		Typeface typeface = sTypefaceCache.get(NAME);

		if (typeface == null) {

			typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/HelveticaNeueLTStdMd.otf");
			sTypefaceCache.put(NAME, typeface);


		}

		setTypeface(typeface);

	}

}


