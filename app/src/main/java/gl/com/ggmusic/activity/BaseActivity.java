package gl.com.ggmusic.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewStub;

import gl.com.ggmusic.R;

/**
 * Created by guilinlin on 16/4/13.<p/>
 * 注意事项:
 * 1.构造方法中需调用setContentView()；
 */
public abstract class BaseActivity extends AppCompatActivity {


    /**
     * 统一toolBar
     */
    protected android.support.v7.widget.Toolbar toolbar;
    /**
     * 显示子控件的viewStud,轻量级
     */
    protected ViewStub containerViewStub;

    /**
     * 继承自baseActiviy需要引用的布局ID，构造函数中传入
     */
    protected int containerLayoutId;

    protected Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);

        this.context = this;
        this.containerViewStub = (ViewStub) findViewById(R.id.viewStub);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);


        setContainerLayout();

        init();

        initView();

        setListener();
    }

    /**
     * 设置之类继承自BaseActivity需要引用的布局id
     */
    private void setContainerLayout() {
        containerViewStub.setLayoutResource(containerLayoutId);
        containerViewStub.inflate();
    }

    protected void initToolBar(String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 为了方便使用preety自动生成view的插件，所以将次方法命令成setContentView，
     * 在BaseActivity中应使用super().setContentView代替setContentView
     *
     * @param containerLayoutId
     */
    public void setContentView(int containerLayoutId) {
        this.containerLayoutId = containerLayoutId;
    }

    abstract void init();

    abstract void initView();

    abstract void setListener();


    protected void goto

}
