package wj.com.fragementrstu;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<Fragment> fragmentList = new ArrayList<Fragment>();
    ViewPager viewPager;

     TextView A_tab ;
     TextView B_tab ;
     TextView C_tab ;
     TextView D_tab ;
     TextView a_point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //A 小红点
        a_point = (TextView)findViewById(R.id.A_point);


        viewPager = (ViewPager)findViewById(R.id.viewPager);
        A_tab = (TextView)findViewById(R.id.A_tab);
        B_tab = (TextView)findViewById(R.id.B_tab);
        C_tab = (TextView)findViewById(R.id.C_tab);
        D_tab = (TextView)findViewById(R.id.D_tab);

        A_tab.setOnClickListener(this);
        B_tab.setOnClickListener(this);
        C_tab.setOnClickListener(this);
        D_tab.setOnClickListener(this);

        fragmentList.add(new AFragment());
        fragmentList.add(new BFragment());
        fragmentList.add(new CFragment());
        fragmentList.add(new DFragment());
        FragemntAdapter fragemntAdapter = new FragemntAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(fragemntAdapter);
        //viewpager滑动监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当页面被选择时，先将导航栏所有字体颜色设置为灰色
                A_tab.setTextColor(Color.rgb(80,80,80));
                B_tab.setTextColor(Color.rgb(80,80,80));
                C_tab.setTextColor(Color.rgb(80,80,80));
                D_tab.setTextColor(Color.rgb(80,80,80));
                //被选中页面字体颜色设置为绿色
                switch (position){
                    case 0:
                        A_tab.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        B_tab.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        C_tab.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        D_tab.setTextColor(Color.GREEN);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.A_tab:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.B_tab:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.C_tab:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.D_tab:
                viewPager.setCurrentItem(3,false);
                break;

        }
    }
    //A小红点
    public void addpoint(){
        int num = Integer.parseInt(a_point.getText().toString());
        if (num==0){
         a_point.setVisibility(View.VISIBLE);
        }
        num++;
        a_point.setText(String.valueOf(num));
    }
}
