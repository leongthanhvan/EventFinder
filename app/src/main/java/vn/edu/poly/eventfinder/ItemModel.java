package vn.edu.poly.eventfinder;

import android.animation.TimeInterpolator;

public class ItemModel {
    public final String ten;
    public final String sdt;
    public final int hinh;
    public final int colorId1;
    public final int colorId2;
    public final TimeInterpolator interpolator;

    public ItemModel(String ten,String sdt,int hinh, int colorId1, int colorId2, TimeInterpolator interpolator) {
        this.ten = ten;
        this.sdt = sdt;
        this.hinh = hinh;
        this.colorId1 = colorId1;
        this.colorId2 = colorId2;
        this.interpolator = interpolator;
    }
}