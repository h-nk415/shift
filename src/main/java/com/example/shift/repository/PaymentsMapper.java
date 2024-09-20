package com.example.shift.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.shift.entity.Payments;

@Mapper
public interface PaymentsMapper {
	
	void insertPayment(Payments payment); //Payments エンティティを payments テーブルに挿入します。

    Payments getPaymentById(@Param("id") Integer id); //指定されたIDのレコードを取得します。

    List<Payments> getAllPayments(); //すべての支払いレコードを取得します。

    void updatePayment(Payments payment); //指定されたIDのレコードを更新します。

    void deletePayment(@Param("id") Integer id); //指定されたIDのレコードを削除します。

    List<Payments> getMonthlyPayments();// ユーザーごと、月ごとの合計勤務時間と給与を集計して取得します。

}
