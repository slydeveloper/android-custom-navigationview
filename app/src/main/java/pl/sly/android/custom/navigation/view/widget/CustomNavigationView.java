package pl.sly.android.custom.navigation.view.widget;

import android.content.Context;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import pl.sly.android.custom.navigation.view.R;

public class CustomNavigationView extends FrameLayout {

    private NavigationView mNavigationView;
    private TextView mTopTextView;
    private TextView mBottomTextView;

    public CustomNavigationView(Context context) {
        this(context, null);
    }

    public CustomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(getContext(), R.layout.custom_navigation_view, this);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        mTopTextView = (TextView) findViewById(R.id.topTextView);
        mBottomTextView = (TextView) findViewById(R.id.bottomTextView);

        mTopTextView.setTypeface(EasyFonts.captureIt(context));
        mBottomTextView.setTypeface(EasyFonts.captureIt(context));

        removeOverScroll();
    }

    public void setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener listener) {
        mNavigationView.setNavigationItemSelectedListener(listener);
    }

    private void removeOverScroll() {
        NavigationMenuView navigationMenuView = findNavigationMenuView();

        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }
    }

    private NavigationMenuView findNavigationMenuView() {
        for (int i = 0; i < mNavigationView.getChildCount(); i++) {
            if (mNavigationView.getChildAt(i) instanceof NavigationMenuView) {
                return (NavigationMenuView) mNavigationView.getChildAt(i);
            }
        }

        return null;
    }
}
