//package com.example.shift.service.impl;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.shift.entity.Payments;
//import com.example.shift.repository.PaymentsMapper;
//import com.example.shift.service.PaymentsService;
//
//import lombok.RequiredArgsConstructor;
//
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class PaymentsServiceImpl implements PaymentsService {
//	
//	private final PaymentsMapper paymentsMapper;
//
//	@Override
//	//支払い情報を新規作成
//	public void savePayment(Payments payment) {
//		paymentsMapper.insertPayment(payment);
//
//	}
//
//	@Override
//	//支払い情報IDを取得する
//	public Payments getPaymentById(Integer id) {
//		
//		return paymentsMapper.getPaymentById(id);
//	}
//
//	@Override
//	//すべての支払い情報を取得する
//	public List<Payments> getAllPayments() {
//		
//		return paymentsMapper.getAllPayments();
//	}
//
//	@Override
//	//支払い情報の更新
//	public void updatePayment(Payments payment) {
//		paymentsMapper.updatePayment(payment);
//	}
//
//	@Override
//	//支払い情報の削除
//	public void deletePayment(Integer id) {
//		paymentsMapper.deletePayment(id);
//
//	}
//
//	@Override
//	//月ごとの給料と合計時間
//	public List<Payments> getMonthlyPayments() {
//		
//		return null;
//	}
//
//}
package com.example.shift.service.impl;


