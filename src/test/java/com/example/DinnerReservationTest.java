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

        // コース:松
        reserv.setCourse( 1 );

        // 結果 - 料金 = 70,000 円(7,000円 × 10名)
        assertEquals( 70000, reserv.getCharget() );
    }    
}
