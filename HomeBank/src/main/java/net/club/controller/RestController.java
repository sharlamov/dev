package net.club.controller;

import java.util.List;

import net.club.model.Bet;
import net.club.model.Shop;
import net.club.service.BetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/service")
public class RestController {
 
	@Autowired
	private BetService betService;
	
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON(@PathVariable String name) {
		System.out.println("json");
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"mkyong1", "mkyong2", "mkyong3"});
 		return shop;
 
	}
 
	@RequestMapping(value="/bets/{date}", method = RequestMethod.GET)
	public @ResponseBody List<Bet> getBetsByDate(@PathVariable String date) {
		System.out.println("bet rest service");
		List<Bet> l =  betService.getList(false);
 		return l;
 
	}
 
	

}
