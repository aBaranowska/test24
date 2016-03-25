package com.rec.spring;

import java.util.Calendar;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.INTERFACES)
public class ExampleService implements Service {

	private long ms;

	public ExampleService() {
		ms = Calendar.getInstance().getTimeInMillis();
	}

	public String getMessage() {
		return "ms = " + ms;
	}

}
