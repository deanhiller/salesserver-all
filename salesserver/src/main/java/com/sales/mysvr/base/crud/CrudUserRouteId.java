package com.sales.mysvr.base.crud;

import org.webpieces.router.api.routing.RouteId;

public enum CrudUserRouteId  implements RouteId {
	//list
	LIST_USERS,
	//add/edit
	GET_ADD_USER_FORM, GET_EDIT_USER_FORM, POST_USER_FORM,
	//delete
	CONFIRM_DELETE_USER, POST_DELETE_USER

}
