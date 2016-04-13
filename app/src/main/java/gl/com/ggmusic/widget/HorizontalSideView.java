package gl.com.ggmusic.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import gl.com.ggmusic.R;
import gl.com.ggmusic.util.DensityUtils;

/**
 * 一个配合viewPager使用的水平滚动条，主要思想是一个垂直线性布局中嵌套一个水平线性布局和一个高度
 * 为3dp（非固定）的view,然后根据每次的item修改view的leftMargin,从而达到类似滚动的效果
 * Created by guilinlin on 16/4/13.
 */
public class HorizontalSideView extends LinearLayout implements View.OnClickListener {

    private Context context;
    /**
     * 状态栏的高度，默认为40dp
     */
    private LayoutParams lp;
    /**
     * 保存几个滑动的文字
     */
    protected TextView[] textList;
    /**
     * 记录之前滑动的item,用于绘制动画
     */
    private int beforePosition;
    /**
     * 子布局，容纳文字
     */
    private LinearLayout container;
    /**
     * 底部的动态条
     */
    private View divider;
    private int dividerWidth = 0;


    public HorizontalSideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initLayout(context);

        //默认一个布局，高度40dp,每个自布局自适应
        lp = new LayoutParams(0, DensityUtils.dp2px(context, 40f));
        lp.weight = 1;
    }


    public void addText(String... strings) {
        textList = new TextView[strings.length];

        for (int i = 0; i < strings.length; i++) {
            TextView textView = new TextView(context);
            textView.setTextSize(17);
            textView.setGravity(Gravity.CENTER);
            textView.setTag(i);
            textView.setText(strings[i]);
            container.addView(textView, lp);
            textView.setOnClickListener(this);
            textList[i] = textView;
        }

        //第一次默认显示第一个
        beforePosition = 0;
        setSelectedTextColor(0);

        initDivider();

    }

    /**
     * 初始化动态条
     */
    private void initDivider() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (divider != null)
                    return;
                dividerWidth = getWidth() / 4;
                divider = new View(context);
                divider.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                LayoutParams lp = new LayoutParams(dividerWidth, DensityUtils.dp2px(context, 3f));
                addView(divider, lp);
            }
        });

    }


    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        setSelectedTextColor(position);
    }

    /**
     * 设置选中的文字高亮效果
     */
    public void setSelectedTextColor(int position) {
        for (int i = 0; i < textList.length; i++) {
            if (position == i) {
                textList[i].setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                textList[i].setTextColor(getResources().getColor(R.color.colorDefaultGrey));
            }
            setDividerMargin(position);
        }
        beforePosition = position;//记住之前是第几个，滑动动画需要

    }

    /**
     * 初始化布局
     *
     * @param context
     */
    private void initLayout(Context context) {
        setOrientation(LinearLayout.VERTICAL);
        container = new LinearLayout(context);
        LayoutParams lpContainer = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.dp2px(context, 40f));
        addView(container, lpContainer);
    }

    /**
     * 动态设置底部滑动条的位置
     *
     * @param position
     */
    private void setDividerMargin(float position) {
        if (divider == null)
            return;
        LayoutParams lp = (LayoutParams) divider.getLayoutParams();
        lp.leftMargin = (int) (dividerWidth * position);
        divider.setLayoutParams(lp);
    }
}
