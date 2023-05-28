package com.example.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.ConfirmOrder;
import com.example.dao.ConfirmOrderRepo;

@Service
public class ConfirmOrderService {

	@Autowired
	private ConfirmOrderRepo confirmOrderRepo;
	
	public String submitOrder(ConfirmOrder confirmOrder) {
		this.confirmOrderRepo.saveAndFlush(confirmOrder);
		return "Success";
	}

	public List<ConfirmOrder> getTodayOrder() {
		// TODO Auto-generated method stub
		//return this.confirmOrderRepo.findAllByData(new Date(System.currentTimeMillis()));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = dateFormat.format(new Date());
		return this.confirmOrderRepo.findAllByData(format);
	}

	public List< ConfirmOrder> getHistory(String customerId) {
		// TODO Auto-generated method stub
		return this.confirmOrderRepo.findAllByCustomerIdOrderByDataDesc(customerId);
	}

	public void markOrderComplete(Integer integer) {
		// TODO Auto-generated method stub
		Optional<ConfirmOrder> findById = this.confirmOrderRepo.findById(integer);
		ConfirmOrder confirmOrder = findById.get();
		confirmOrder.setFlag(true);
		this.confirmOrderRepo.saveAndFlush(confirmOrder);
	}
}
