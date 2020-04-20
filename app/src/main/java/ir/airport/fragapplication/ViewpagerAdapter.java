package ir.airport.fragapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                BlankFragment fragment=new BlankFragment();
                return fragment;
            case 1:
                BlankFragment fragment1=new BlankFragment();
                return fragment1;
            case 2:
                BlankFragment fragment2=new BlankFragment();
                return fragment2;
            case 3:
                BlankFragment fragment3=new BlankFragment();
                return fragment3;
            case 4:
                BlankFragment fragment4=new BlankFragment();
                return fragment4;
            case 5:
                BlankFragment fragment5=new BlankFragment();
                return fragment5;
            default:
                BlankFragment fragment6=new BlankFragment();
                return fragment6;


        }

    }



    @Override
    public int getCount() {
        return 6;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "Contact";
            case 2:
                return "Live";
            case 3:
                return "Chat";
            case 4:
                return "Phone";
            case 5:
                return "Camera";
            default:
                return "";
        }

    }
}
