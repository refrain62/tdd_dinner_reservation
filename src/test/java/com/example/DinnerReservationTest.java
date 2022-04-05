package com.example;

import static org.junit.Assert.*;

import com.CourseOrder;
import com.example.DinnerReservation.Course;

import org.junit.Test;

/**
 * 宴会料金計算テスト
 */
public class DinnerReservationTest
{
    /**
     * コース注文の金額確認
     */
    @Test
    public void testOrerCharge()
    {
        CourseOrder order = CourseOrder.createMatsuCourse( 10 );

        // 金額の確認
        assertEquals( 70000, order.getOrderCharge() );
    }

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
        assertEquals( 70000, reserv.getCharge() );
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
        assertEquals( 50000, reserv.getCharge() );
    }
    
    /**
     * 料金計算（梅）のテスト
     */
    @Test
    public void testUme()
    {
        DinnerReservation reserv = new DinnerReservation();
        CourseOrder order = CourseOrder.createUmeCourse( 10 );          // 梅コース 10人

        // 選択オーダーの追加
        reserv.addCourseOrder( order );

        // 結果 - 料金 = 30,000 円(3,000円 × 10名)
        assertEquals( 30000, reserv.getCharge() );
    }
    
    /**
     * クーポン適用テスト
     */
    @Test
    public void testCoupon()
    {
        DinnerReservation reserv = new DinnerReservation();
        CourseOrder order = CourseOrder.createMatsuCourse( 10 );        // 松コース 10人

        // 選択オーダーの追加
        reserv.addCourseOrder( order );

        // クーポン適用 - 1枚
        reserv.setCoupon( 1 );

        // 結果 - 料金 = 60,000 円(7,000円 × 10名 - 10,000円<クーポン>)
        assertEquals( 60000, reserv.getCharge() );
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
        CourseOrder order = CourseOrder.createMatsuCourse( 10 );        // 松コース 10人

        // 選択オーダーの追加
        reserv.addCourseOrder( order );

        // 結果 - 料金 = 70,000 円(7,000円 × 10名)
        assertEquals( 70000, reserv.getCharge() );
    }

    /**
     * 複数コースのテスト
     */
    @Test
    public void testTwoCourse()
    {
        DinnerReservation reserv = new DinnerReservation();
        CourseOrder orderMatsu = CourseOrder.createMatsuCourse( 3 );         // 松コース 3人
        CourseOrder orderTake = CourseOrder.createTakeCourse( 10 );        // 竹コース 10人

        // 選択オーダーの追加
        reserv.addCourseOrder( orderMatsu );

        // 選択オーダーの追加
        reserv.addCourseOrder( orderTake );

        // 結果 - 料金 = 71,000 円(7,000円 × 3名 + 5,000円 × 10名)
        assertEquals( 71000, reserv.getCharge() );
    }
    
    /**
     * 同一コースの複数追加テスト
     */
    @Test
    public void testAddSameCourse()
    {
        DinnerReservation reserv = new DinnerReservation();
        CourseOrder orderMatsu03 = CourseOrder.createMatsuCourse( 3 );      // 松コース 3人
        CourseOrder orderMatsu10 = CourseOrder.createMatsuCourse( 10 );     // 松コース 10人

        // 選択オーダーの追加
        reserv.addCourseOrder( orderMatsu03 );

        // 選択オーダーの追加
        reserv.addCourseOrder( orderMatsu10 );

        // 後から追加した内容で上書きされるので（仕様）
        // 結果 - 料金 = 70,000 円(7,000円 × 10名)
        assertEquals( 70000, reserv.getCharge() );
    }

    /**
     * スタイル(和／洋／中)のテスト
     */
    @Test
    public void testStyle()
    {
        DinnerReservation reserv = new DinnerReservation();
        CourseOrder orderMatsu = CourseOrder.createMatsuCourse( 10 );       // 松コース 10人

        // スタイル：和食
        orderMatsu.setStyle( DinnerReservation.Style.Japanse );

        // 選択オーダーの追加
        reserv.addCourseOrder( orderMatsu );
        
        // 結果 - 料金 = 70,000 円(7,000円 × 10名)
        assertEquals( 70000, reserv.getCharge() );
    }

    /**
     * 中華風の場合に竹／梅のエラー
     */
    @Test
    public void testValidation()
    {
        // スタイル：竹 - 中華のチェック
        CourseOrder order = CourseOrder.createTakeCourse( 10 );         // 竹コース 10人

        order.setStyle( DinnerReservation.Style.Chinese );

        assertFalse( order.isValid() );


        // スタイル：梅 - 中華のチェック
        order = CourseOrder.createUmeCourse( 10 );                      // 梅コース 10人

        order.setStyle( DinnerReservation.Style.Chinese );

        assertFalse( order.isValid() );
        

        // スタイル：松 - 中華のチェック
        order = CourseOrder.createMatsuCourse( 10 );                    // 松コース 10人

        order.setStyle( DinnerReservation.Style.Chinese );

        assertTrue( order.isValid() );
    }

    /**
     * 中華風の場合に松の料金対応確認
     */
    @Test
    public void testAdditionalCharge()
    {
        DinnerReservation reserv = new DinnerReservation();
        CourseOrder orderMatsu = CourseOrder.createMatsuCourse( 10 );       // 松コース 10人

        // スタイル：中華
        orderMatsu.setStyle( DinnerReservation.Style.Chinese );

        // 選択オーダーの追加
        reserv.addCourseOrder( orderMatsu );
        
        // 松コースで中華の場合は単価が＋５００円
        // 結果 - 料金 = 75,000 円( ( 7,000円 + 500円 ) × 10名 )
        assertEquals( 75000, reserv.getCharge() );
    }
}
