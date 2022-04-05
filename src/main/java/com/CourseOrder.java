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
     * 選択スタイル
     */
    private DinnerReservation.Style _style;

    /**
     * コース(松)オーダー生成メソッド
     * @param number
     */
    public static CourseOrder createMatsuCourse( int number )
    {
        CourseOrder order = new CourseOrder();

        // 人数の設定
        order.setUser( number );

        // 選択コースの設定：松
        order.setCourse( DinnerReservation.Course.Matsu );

        return order;
    }

    /**
     * コース(竹)オーダー生成メソッド
     * @param number
     */
    public static CourseOrder createTakeCourse( int number )
    {
        CourseOrder order = new CourseOrder();

        // 人数の設定
        order.setUser( number );

        // 選択コースの設定：竹
        order.setCourse( DinnerReservation.Course.Take );

        return order;
    }

    /**
     * コース(梅)オーダー生成メソッド
     * @param number
     */
    public static CourseOrder createUmeCourse( int number )
    {
        CourseOrder order = new CourseOrder();

        // 人数の設定
        order.setUser( number );

        // 選択コースの設定：梅
        order.setCourse( DinnerReservation.Course.Ume );

        return order;
    }

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
    
    /**
     * 選択スタイル設定
     * @param style
     */
    public void setStyle( DinnerReservation.Style style )
    {
        this._style = style;
    }

    /**
     * 選択スタイル取得
     * @return
     */
    public DinnerReservation.Style getStyle()
    {
        return this._style;
    }

    /**
     * コース × スタイルの有効性チェック
     */
    public boolean isValid()
    {
        // 中華で松の場合はTRUE
        if( DinnerReservation.Style.Chinese.equals( this._style ) == true )
        {
            if( DinnerReservation.Course.Matsu.equals( this._course ) == true )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }

    /**
     * 注文の料金を取得
     * @return
     */
    public int getOrderCharge()
    {
        int price = this.getPrice( this._course );

        // コースが松で中華の場合は単価を+500円する
        if(     DinnerReservation.Course.Matsu.equals( this._course ) == true
            &&  DinnerReservation.Style.Chinese.equals( this._style ) == true
            )
        {
            price += 500;
        }

        return price * this._number;
    }

    /**
     * コースの料金を取得
     * @param course 選択コース
     * @return 単価
     */
    private int getPrice( DinnerReservation.Course course )
    {
        // 料金判定
        switch( course )
        {
            // コース : 松
            case Matsu:
                return 7000;
                
            // コース : 竹
            case Take:
                return 5000;
                
            // コース : 梅
            case Ume:
                return 3000;

            // それ以外
            default:
                return 0;
        }
    }
}
