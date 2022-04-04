package com.example;

import static org.junit.Assert.*;

import com.CourseOrder;

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
        CourseOrder order = CourseOrder.createMatsuCourse( 10 );        // 松コース 10人

        // 選択オーダーの追加
        reserv.addCourseOrder( order );

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
        CourseOrder order = CourseOrder.createTakeCourse( 10 );        // 竹コース 10人

        // 選択オーダーの追加
        reserv.addCourseOrder( order );

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

        // コースの追加(梅)
        reserv.addCourse(
                             10
                            ,DinnerReservation.Course.Ume
                            );

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

        // コースの追加(松)
        reserv.addCourse(
                             10
                            ,DinnerReservation.Course.Matsu
                            );

        // クーポン適用 - 1枚
        reserv.setCoupon( 1 );

        // 結果 - 料金 = 60,000 円(7,000円 × 10名 - 10,000円<クーポン>)
        assertEquals( 60000, reserv.getCharget() );
    }
    
    /**
     * クーポン適用 3枚まで テスト
     */
    @Test( expected = CouponException.class )
    public void testCouponException()
    {
        DinnerReservation reserv = new DinnerReservation();

        // クーポン適用 - 4枚で例外発生
        reserv.setCoupon( 4 );
    }

    /**
     * コース追加のテスト
     */
    @Test
    public void testAddOneCourse()
    {
        DinnerReservation reserv = new DinnerReservation();

        // コースの追加(松)
        reserv.addCourse(
                             10
                            ,DinnerReservation.Course.Matsu
                            );

        // 結果 - 料金 = 70,000 円(7,000円 × 10名)
        assertEquals( 70000, reserv.getCharget() );
    }

    /**
     * 複数コースのテスト
     */
    @Test
    public void testTwoCourse()
    {
        DinnerReservation reserv = new DinnerReservation();

        // コースの追加(松)
        reserv.addCourse(
                             3
                            ,DinnerReservation.Course.Matsu
                            );

        // コースの追加(竹)
        reserv.addCourse(
                             10
                            ,DinnerReservation.Course.Take
                            );

        // 結果 - 料金 = 71,000 円(7,000円 × 3名 + 5,000円 × 10名)
        assertEquals( 71000, reserv.getCharget() );
    }
    
    /**
     * 同一コースの複数追加テスト
     */
    @Test
    public void testAddSameCourse()
    {
        DinnerReservation reserv = new DinnerReservation();

        // コースの追加(松)
        reserv.addCourse(
                             3
                            ,DinnerReservation.Course.Matsu
                            );

        // コースの追加(竹)
        reserv.addCourse(
                             10
                            ,DinnerReservation.Course.Matsu
                            );

        // 後から追加した内容で上書きされるので（仕様）
        // 結果 - 料金 = 70,000 円(7,000円 × 10名)
        assertEquals( 70000, reserv.getCharget() );
    }
}
