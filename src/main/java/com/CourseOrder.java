package com;

import com.example.DinnerReservation;

/**
 * コース種類・スタイルの管理
 */
public class CourseOrder
{
    /**
     * 人数
     */
    private int _number;
    
    /**
     * 選択コース
     */
    private DinnerReservation.Course _course;

    /**
     * 人数設定
     * @param number 人数
     */
    public void setUser( int number )
    {
        this._number = number;
    }

    /**
     * 人数取得
     * @return
     */
    public int getUser()
    {
        return this._number;
    }

    /**
     * 選択コース設定
     * @param course
     */
    public void setCourse( DinnerReservation.Course course )
    {
        this._course = course;
    }

    /**
     * 選択コース取得
     * @return
     */
    public DinnerReservation.Course getCourse()
    {
        return this._course;
    }
}
