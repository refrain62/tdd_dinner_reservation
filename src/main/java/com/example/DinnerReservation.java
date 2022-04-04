package com.example;

import java.util.HashMap;

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
// また、1つの宴会で、複数のコース種類が注文されることもある
// (主賓の3人は松コース、一般参加者の10人は竹コースなど)
// ----------------------------------------

// ----------------------------------------
// TODO LIKST
// ----------------------------------------
// ◎料金計算(松)
// 　◎クーポンの使用
// 　◎クーポンは3枚まで
// ◎料金計算(竹)
// ◎料金計算(梅)
// ◎コースの定数化
// ◎単価判定の別メソッド化
// ・複数コース対応の追加
//   ◎１コースの追加
//   ◎HasshMapの使用
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
     * 複数コース保持用（コース、人数）
     */
    private HashMap< Course, Integer > __courseTable = new HashMap<>();

    /**
     * 選択コース
     */
    private Course __course;

    /**
     * クーポン
     */
    private int __coupon;

    /**
     * クーポン適用
     * @param coupon クーポン枚数
     */
	public void setCoupon( int coupon )
    {
        // 3枚以上の場合は例外発生
        if( coupon > 3 )
        {
            throw new CouponException();
        }

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

        // 人数取得
        int number = this.__courseTable.get( this.__course );

        // 単価 × 人数 - クーポンs
        return ( price * number ) - ( 10000 * this.__coupon );
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

    /**
     * コース追加
     * @param number 人数
     * @param course コース
     */
    public void addCourse(int number, Course course)
    {
        this.__course = course;

        // コーステーブルに追加
        this.__courseTable.put( course, number );
    }
}
