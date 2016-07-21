package com.qingao.hello;

import java.util.*;
import org.springframework.context.annotation.*;

@Configuration
public class MyConfig {
	@Bean(name="dataList")
	public ArrayList<String> getDataList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		return list;
	}
}
