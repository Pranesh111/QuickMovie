package materialtest.example.ritzipsy.quickmovie.base.mvp;

import android.os.Bundle;

import materialtest.example.ritzipsy.quickmovie.base.BaseAppcompatActivity;
import materialtest.example.ritzipsy.quickmovie.base.BasePresenter;
import materialtest.example.ritzipsy.quickmovie.base.BaseView;


public abstract class MvpActivity<P extends BasePresenter> extends BaseAppcompatActivity implements BaseView {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
        setContentView(getContentLayoutResource());
    }

    protected abstract P createPresenter();

    protected abstract int getContentLayoutResource();
}
