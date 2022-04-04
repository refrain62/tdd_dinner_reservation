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
// 　・クーポンの使用
// 　・クーポンは3枚まで
// ◎料金計算(竹)
// ◎料金計算(梅)
// ----------------------------------------

/**
 * 宴会料金計算
 */
public class DinnerReservation
{
    /**
     * 人数
     */
    private int __number;

    /**
     * 選択コース
     */
    private int __course;

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
    public void setCourse( int course )
    {
        this.__course = course;
    }

    /**
     * 料金取得
     * @return
     */
    public int getCharget()
    {
        int charge = 0;

        // 料金 × 人数
        switch( this.__course )
        {
            // コース : 1:松
            case 1:
                charge = 7000 * this.__number;
                break;
                
            // コース : 2:竹
            case 2:
            charge = 5000 * this.__number;
            break;
                
            // コース : 3:梅
            case 3:
            charge = 3000 * this.__number;
            break;
        }

        return charge;
    }
    
}
