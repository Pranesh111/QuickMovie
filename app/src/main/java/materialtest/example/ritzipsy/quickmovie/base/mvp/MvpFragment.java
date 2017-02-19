package materialtest.example.ritzipsy.quickmovie.base.mvp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

import materialtest.example.ritzipsy.quickmovie.R;
import materialtest.example.ritzipsy.quickmovie.base.BaseFragment;
import materialtest.example.ritzipsy.quickmovie.base.BasePresenter;
import materialtest.example.ritzipsy.quickmovie.base.BaseView;


public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment implements BaseView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract P getPresenter();

    protected abstract int getContentLayoutResource();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(getContentLayoutResource(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            Activity a = getActivity();
            if(a != null) a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public void setFragment(Fragment frag, String TAG, Bundle bundle, boolean isAddToStack) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (bundle != null)
            frag.setArguments(bundle);
        ft.replace(R.id.base_container, frag, TAG);
        if (isAddToStack)
        {
            for (int i=0; i<manager.getBackStackEntryCount(); i++){

                if (frag.getClass().getName().equalsIgnoreCase(manager.getBackStackEntryAt(i).getName())){
                    isAddToStack = false;
                    break;
                }
            }
        }
        if (isAddToStack)
            ft.addToBackStack(frag.getClass().getName());
        ft.commit();
    }

}
