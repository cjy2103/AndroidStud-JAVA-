package com.example.bottomnavigation.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.example.bottomnavigation.fragment.DjMaxFragment;
import com.example.bottomnavigation.fragment.MidoriFragment;
import com.example.bottomnavigation.fragment.MomoiFragment;
import com.example.bottomnavigation.util.SystemUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Fragment djMaxFragment;
    private Fragment momoiFramgnet;
    private Fragment midoriFragment;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding();

        initialize();

        bottomNavigationSelect();
    }

    /**
     * @DESC: 뷰바인딩
     */
    private void viewBinding(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    /**
     * @DESC: 초기화
     */
    private void initialize(){
        binding.bottomNav.setItemIconTintList(null);
        menu = binding.bottomNav.getMenu();

        SystemUtil systemUtil = new SystemUtil();
        systemUtil.sofNavigationBarHide(getWindow());
        systemUtil.statusbarSetting(getWindow(),this,binding.mainConstraint);

        djMaxFragment = new DjMaxFragment();
        // 첫화면
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, djMaxFragment).commit();
        menu.findItem(R.id.djmax_fragment).setIcon(R.drawable.iv_djmax_fail);
    }

    /**
     * @DESC: 바텀 네비바 메뉴 선택
     */
    private void bottomNavigationSelect(){
        binding.bottomNav.setOnItemSelectedListener(item->{
            changeFramgnet(item);
            return true;
        });
    }

    /**
     * @DESC: Navigation 아이콘 클릭
     * @param item
     */
    @SuppressLint("NonConstantResourceId")
    private void changeFramgnet(MenuItem item){
        switch (item.getItemId()){
            case R.id.djmax_fragment:
                if(djMaxFragment == null){
                    djMaxFragment = new DjMaxFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.main_frame, djMaxFragment).commit();
                }
                screenChange(djMaxFragment,item);
                break;
            case R.id.momoi_fragment:
                if(momoiFramgnet == null){
                    momoiFramgnet = new MomoiFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.main_frame, momoiFramgnet).commit();
                }
                screenChange(momoiFramgnet,item);
                break;
            case R.id.midori_fragment:
                if(midoriFragment == null){
                    midoriFragment = new MidoriFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.main_frame, midoriFragment).commit();
                }
                screenChange(midoriFragment,item);
                break;
            default:
                break;
        }
    }

    /**
     * @DESC: 화면 전환
     * @param fragment
     * @param item
     */
    @SuppressLint("NonConstantResourceId")
    private void screenChange(Fragment fragment, MenuItem item){
        allScreenHide();
        if(fragment != null) getSupportFragmentManager().beginTransaction().show(fragment).commit();
        menu.findItem(R.id.djmax_fragment).setIcon(R.drawable.iv_djmax);
        menu.findItem(R.id.momoi_fragment).setIcon(R.drawable.iv_momoi);
        menu.findItem(R.id.midori_fragment).setIcon(R.drawable.iv_midori);

        switch (item.getItemId()){
            case R.id.djmax_fragment:
                item.setIcon(R.drawable.iv_djmax_fail);
                break;
            case R.id.momoi_fragment:
                item.setIcon(R.drawable.iv_alice);
                break;
            case R.id.midori_fragment:
                item.setIcon(R.drawable.iv_yuse);
                break;
            default:
                break;
        }
    }

    /**
     * @DESC: 생성된 모든화면 숨김처리
     */
    private void allScreenHide(){
        if(djMaxFragment!=null) getSupportFragmentManager().beginTransaction().hide(djMaxFragment).commit();
        if(momoiFramgnet!=null) getSupportFragmentManager().beginTransaction().hide(momoiFramgnet).commit();
        if(midoriFragment!=null) getSupportFragmentManager().beginTransaction().hide(midoriFragment).commit();
    }

}

