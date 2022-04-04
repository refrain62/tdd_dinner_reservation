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

        // コース: 1:松
        reserv.setCourse( DinnerReservation.Matsu );

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

        // コース: 2:竹
        reserv.setCourse( DinnerReservation.Take);

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

        // コース: 3:梅
        reserv.setCourse( DinnerReservation.Ume );

        // 結果 - 料金 = 30,000 円(3,000円 × 10名)
        assertEquals( 30000, reserv.getCharget() );
    }
}
