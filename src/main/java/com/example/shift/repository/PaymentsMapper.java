//package com.example.shift.repository;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//import com.example.shift.entity.Payments;
//
//@Mapper
//public interface PaymentsMapper {
//	
//	void insertPayment(Payments payment); //Payments エンティティを payments テーブルに挿入
//
//	Payments getPaymentByMonth(@Param("month") String month); // 指定された月のレコードを取得
//
//    List<Payments> getMonthlyPayments();// ユーザーごと、月ごとの合計勤務時間と給与を集計して取得
//
//}
package com.example.shift.repository;


