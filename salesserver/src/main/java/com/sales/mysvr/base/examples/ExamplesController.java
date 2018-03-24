package com.sales.mysvr.base.examples;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.webpieces.router.api.actions.Action;
import org.webpieces.router.api.actions.Actions;

import com.sales.mysvr.base.libs.RemoteService;
import com.sales.mysvr.base.libs.SomeLibrary;

@Singleton
public class ExamplesController {

	@Inject
	private RemoteService service;
	@Inject
	private SomeLibrary someLib;

	
	public Action index() {
		//this is so the test can throw an exception from some random library that is mocked
		someLib.doSomething(5); 
		
		//renderThis renders index.html in the same package as this controller class
		return Actions.renderThis(); 
	}
	
	public Action exampleList() {
		return Actions.renderThis("user", "Dean Hiller");
	}

	public Action redirect(String id) {
		return Actions.redirect(ExamplesRouteId.MAIN_ROUTE);
	}
	
	public CompletableFuture<Action> myAsyncMethod() {
		CompletableFuture<Integer> remoteValue = service.fetchRemoteValue("dean", 21);
		return remoteValue.thenApply(s -> convertToAction(s));
	}
	//called from method above
	private Action convertToAction(int value) {
		return Actions.renderThis("value", value);
	}
	
	public Action notFound() {
		return Actions.renderThis();
	}
	
	public Action internalError() {
		return Actions.renderThis();
	}
}
