package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 宴会料金計算テスト
 */
public class DinnerReservationTest
{
    /**
     * 料金計算（松）のテスト
     */
    @Test
    public void testMatsu()
    {
        DinnerReservation reserv = new DinnerReservation();

        // 人数 - 10人
        reserv.setUser( 10 );

        // コース: 松
        reserv.setCourse( DinnerReservation.Course.Matsu );

        // 結果 - 料金 = 70,000 円(7,000円 × 10名)
        assertEquals( 70000, reserv.getCharget() );
    }

    /**
     * 料金計算（竹）のテスト
     */
    @Test
    public void testTake()
    {
        DinnerReservation reserv = new DinnerReservation();

        // 人数 - 10人
        reserv.setUser( 10 );

        // コース: 竹
        reserv.setCourse( DinnerReservation.Course.Take);

        // 結果 - 料金 = 50,000 円(5,000円 × 10名)
        assertEquals( 50000, reserv.getCharget() );
    }
    
    /**
     * 料金計算（梅）のテスト
     */
    @Test
    public void testUme()
    {
        DinnerReservation reserv = new DinnerReservation();

        // 人数 - 10人
        reserv.setUser( 10 );

        // コース: 梅
        reserv.setCourse( DinnerReservation.Course.Ume );

        // 結果 - 料金 = 30,000 円(3,000円 × 10名)
        assertEquals( 30000, reserv.getCharget() );
    }
    
    /**
     * クーポン適用テスト
     */
    @Test
    public void testCoupon()
    {
        DinnerReservation reserv = new DinnerReservation();

        // 人数 - 10人
        reserv.setUser( 10 );

        // コース: 松
        reserv.setCourse( DinnerReservation.Course.Matsu );

        // クーポン適用 - 1枚
        reserv.setCoupon( 1 );

        // 結果 - 料金 = 60,000 円(7,000円 × 10名 - 10,000円<クーポン>)
        assertEquals( 60000, reserv.getCharget() );

    }
}
