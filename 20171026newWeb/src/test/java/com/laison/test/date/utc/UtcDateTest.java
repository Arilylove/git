package com.laison.test.date.utc;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import com.laison.common.enumerate.Constant;
import com.laison.common.utils.DateUtils;

import freemarker.template.utility.DateUtil;

public class UtcDateTest {

	@Test
	public void testName() throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date utcDate = DateUtils.utcDate();
		Date defaultDate = DateUtils.defaultDate();
		System.out.println(defaultDate);
		System.out.println(sdf.format(utcDate));
	}
}
