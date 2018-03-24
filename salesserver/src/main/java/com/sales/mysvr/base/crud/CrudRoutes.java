package com.sales.mysvr.base.crud;

import static com.sales.mysvr.base.crud.CrudUserRouteId.CONFIRM_DELETE_USER;
import static com.sales.mysvr.base.crud.CrudUserRouteId.GET_ADD_USER_FORM;
import static com.sales.mysvr.base.crud.CrudUserRouteId.GET_EDIT_USER_FORM;
import static com.sales.mysvr.base.crud.CrudUserRouteId.LIST_USERS;
import static com.sales.mysvr.base.crud.CrudUserRouteId.POST_DELETE_USER;
import static com.sales.mysvr.base.crud.CrudUserRouteId.POST_USER_FORM;

import org.webpieces.router.api.routing.CrudRouteIds;
import org.webpieces.router.api.routing.ScopedRoutes;

public class CrudRoutes extends ScopedRoutes {

	@Override
	protected String getScope() {
		return "/secure/crud";
	}
	
	@Override
	protected boolean isHttpsOnlyRoutes() {
		return true;
	}

	@Override
	protected void configure() {
		//basic crud example(which just calls the same addRoute methods for you for Create/Read/Update/Delete and 
		//the GET render page views as well)
		//it adds all these routes for you in one method call
		//addRoute(GET ,   "/user/list",        "crud/CrudUserController.userList", listRoute);
		//addRoute(GET ,   "/user/new",         "crud/CrudUserController.userAddEdit", addRoute);
		//addRoute(GET ,   "/user/edit/{id}",   "crud/CrudUserController.userAddEdit", editRoute);
		//addRoute(POST,   "/user/post",        "crud/CrudUserController.postSaveUser", saveRoute);
		//addRoute(GET,    "/user/confirmdelete/{id}", "crud/CrudUserController.confirmDeleteUser", confirmDelete);
		//addRoute(POST,   "/user/delete/{id}", "crud/CrudUserController.postDeleteUser", deleteRoute);

		CrudRouteIds routeIds = new CrudRouteIds(
				LIST_USERS, GET_ADD_USER_FORM, GET_EDIT_USER_FORM,
				POST_USER_FORM, CONFIRM_DELETE_USER, POST_DELETE_USER);
		addCrud("user", "CrudUserController", routeIds);
	}

}
