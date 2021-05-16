package com.student.module;

import com.google.inject.AbstractModule;
import com.student.resource.StudentDetailsResource;
import com.student.service.StudentDetailsService;
import com.student.service.StudentDetailsServiceImpl;

public class StudentDetailsModule  extends AbstractModule {

	@Override
	protected void configure() {
		bind(StudentDetailsResource.class);
		bind(StudentDetailsService.class).to(StudentDetailsServiceImpl.class);
	}
}