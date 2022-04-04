package com.example;

// ----------------------------------------
// 基本シナリオ - 宴会料金計算
//
// 食事料金を計算する
// 利用人数とコースんお種類を基に、食事料金を計算する。
// コースの種類は 松 / 竹 / 梅の３種類があり、それぞれ
// 7,000円 / 5,000円 / 3,000円 と料金が異なる。
// このコースに利用人数をかけて、食事料金は計算される。
// また、販売促進キャンペーンの為、割引クーポンが配布されており
// この割引クーポン１枚につき 10,000円 を値引く必要がある。
// また、この和引きクーポンは３枚まで同時に使用可能である。 
// ----------------------------------------

// ----------------------------------------
// TODO LIKST
// ----------------------------------------
// ◎料金計算(松)
// 　◎クーポンの使用
// 　・クーポンは3枚まで
// ◎料金計算(竹)
// ◎料金計算(梅)
// ◎コースの定数化
// ◎単価判定の別メソッド化
// ----------------------------------------

/**
 * 宴会料金計算
 */
public class DinnerReservation
{
    /**
     * 定数：コース
     */
    public enum Course {
         Matsu
        ,Take
        ,Ume
    }

    /**
     * 人数
     */
    private int __number;

    /**
     * 選択コース
     */
    private Course __course;

    /**
     * クーポン
     */
    private int __coupon;

    /**
     * 人数設定
     * @param number 人数
     */
    public void setUser( int number )
    {
        this.__number = number;
    }

    /**
     * コース選択
     * @param course コース
     */
    public void setCourse( Course course )
    {
        this.__course = course;
    }

    /**
     * クーポン適用
     * @param coupon クーポン枚数
     */
	public void setCoupon( int coupon )
    {
        this.__coupon = coupon;
	}
    
    /**
     * 料金取得
     * @return
     */
    public int getCharget()
    {
        // 単価取得
        int price = this.getPrice( this.__course );

        // 単価 × 人数 - クーポンs
        return ( price * this.__number ) - ( 10000 * this.__coupon );
    }

    /**
     * 単価取得
     * @param course 選択コース
     * @return 単価
     */
    private int getPrice( Course course )
    {
        // 料金判定
        switch( course )
        {
            // コース : 1:松
            case Matsu:
                return 7000;
                
            // コース : 2:竹
            case Take:
                return 5000;
                
            // コース : 3:梅
            case Ume:
                return 3000;

            // それ以外
            default:
                return 0;
        }
    }
}
